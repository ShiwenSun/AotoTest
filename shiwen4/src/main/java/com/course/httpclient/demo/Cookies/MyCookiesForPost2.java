package com.course.httpclient.demo.Cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost2 {
    private  String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public  void  beforTest(){
        bundle  = ResourceBundle.getBundle("application",Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public  void  GetWithCookies() throws IOException {
        String uri = bundle.getString("getCookies.uri");
        String TestUrl = url + uri;
        HttpGet get = new HttpGet(TestUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);

        //获取cookies
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name:" + name + "\nvalue:" + value);
        }

//        int code = response.getStatusLine().getStatusCode();
//        if (code == 200) {
//            String res = EntityUtils.toString(response.getEntity(), "utf-8");
//            System.out.println(res);
//        }

    }
    //带cookies的post请求
    @Test(dependsOnMethods ="GetWithCookies" )
    public  void  PostWithCookies() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        String TestUrl = url + uri;
        HttpPost post = new HttpPost(TestUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        post.setHeader("content-type", "application/json");
        client.setCookieStore(this.store);
        String result;

        HttpResponse response = client.execute(post);

        result = EntityUtils.toString(response.getEntity(),"utf-8");

        JSONObject resJson = new JSONObject(result);

        String success = (String) resJson.get("huhansan");
        String status = (String) resJson.get("status");

        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);

    }
}
