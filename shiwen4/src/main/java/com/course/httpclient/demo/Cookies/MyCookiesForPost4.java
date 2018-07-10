package com.course.httpclient.demo.Cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost4 {
    private ResourceBundle bundle;
    private String url;
    private CookieStore store;

    @BeforeTest
    public  void  beforeTest() throws IOException {
        bundle = ResourceBundle.getBundle("application",Locale.CHINA);
        url = bundle.getString("test.url");

    }
    @Test
    public  void  getCookies() throws IOException {
        String uri = bundle.getString("getCookies.uri");
        String TestUrl = url + uri;
        HttpGet get = new HttpGet(TestUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);


       this.store= client.getCookieStore();
        //List<Cookie> cookielist = store.getCookies();
    }


    @Test(dependsOnMethods ="getCookies")
    public  void  PostWithCookies() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        String TestUrl = url + uri;
        HttpPost post = new HttpPost(TestUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.store);
        post.setHeader("application/json","charset=UTF-8");
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");

        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);


        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");

        JSONObject resJson = new JSONObject(result);

        String success = resJson.getString("huhansan");
        String status = resJson.getString("status");

        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);

    }
}
