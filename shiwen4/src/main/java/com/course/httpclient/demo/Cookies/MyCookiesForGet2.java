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

public class MyCookiesForGet2 {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeTest
    public void  beforeTest(){
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);
         url = bundle.getString("test.url");
    }

    @Test
    public  void  GetCookies() throws IOException {
        String uri = bundle.getString("getCookies.uri");
        String testUrl = url + uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);


        //获取cookies
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie : cookieList){
            String name = cookie.getName();
            String status = cookie.getValue();
            System.out.println("name:"+ name + "\nstatus:" + status) ;
        }

    }

        @Test(dependsOnMethods = "GetCookies")
        public  void  GetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String TestUrl = url + uri;
        HttpGet get = new HttpGet(TestUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);



        int stateCode = response.getStatusLine().getStatusCode();
        if (stateCode == 200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }

        }
}
