package com.course.httpclient.demo.Cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet3 {
    private  String url;
    private  ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public  void  beforTest(){
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public  void  TestGetCookies() throws IOException {
        String uri = bundle.getString("getCookies.uri");
        String TestUrl = url + uri;
        HttpGet get = new HttpGet(TestUrl);
        DefaultHttpClient  client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);



        //获取cookies
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for(Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name:" + name +"\nvalue" + value);
        }

    }

    @Test(dependsOnMethods = "TestGetCookies")
    public  void  GetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String TestUrl= url + uri;
        HttpGet get = new HttpGet(TestUrl);
        DefaultHttpClient client =new DefaultHttpClient();
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);

        int code = response.getStatusLine().getStatusCode();
        if (code == 200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }
    }




}
