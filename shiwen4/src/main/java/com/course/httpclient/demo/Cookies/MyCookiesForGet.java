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

public class MyCookiesForGet {
    private  String url;
    private ResourceBundle bundle;
    private  CookieStore store;
    @BeforeTest
    public  void  beforeTest(){
        //读取配置文件的方法
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);
        url=bundle.getString("test.url");
        //System.out.println(url);
    }

    @Test
    public  void  testGetCookies() throws IOException {
        String result;
        String uri = bundle.getString("getCookies.uri");
        //从配置文件中 拼接测试的url
        String testUrl = url + uri;
        //        测试逻辑代码书写
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //获取cookies信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies() ;
        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = " + name
                    + ";  cookie value = " + value);
        }
    }


    @Test(dependsOnMethods = "testGetCookies")
    public  void  testGetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = url + uri;
        String result;
        DefaultHttpClient  client = new DefaultHttpClient();
        HttpGet get = new HttpGet(testUrl);
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
//        result = EntityUtils.toString(response.getEntity(),"utf-8");
//        System.out.println(result);

        int stateCode = response.getStatusLine().getStatusCode();
        System.out.println(stateCode);
        if (stateCode == 200){
            result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }


    }
}

