package com.appleieye.maya.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.testng.AssertJUnit.assertEquals;

public class CookieTest {

    private String uri;
    private String cookieUri;
    private ResourceBundle bundle;
    private String getCookie;
    private CookieStore store;
    private String postCookieUri;
    @BeforeTest
    public void getResource(){
        bundle = ResourceBundle.getBundle("client", Locale.CHINA);
        uri = bundle.getString("test.url");
        cookieUri = bundle.getString("cookies.uri");
        getCookie = bundle.getString("getCookie.uri");
        postCookieUri = bundle.getString("post.cookie.uri");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        HttpGet get = new HttpGet(this.uri + this.cookieUri);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        store = client.getCookieStore();
        List<Cookie> cookies = store.getCookies();
        for (Cookie cookie:cookies){
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }
    }

    @Ignore
    @Test(dependsOnMethods = {"testGetCookies"})
    public void getCookie() throws Exception{
        String result;
        HttpGet get = new HttpGet(this.uri+this.getCookie);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(store);
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
    }


    @Test(dependsOnMethods = {"testGetCookies"})
    public void postWithCookie() throws IOException {

        DefaultHttpClient client = new DefaultHttpClient();
        System.out.println(this.uri+this.postCookieUri);
        HttpPost post = new HttpPost(this.uri+this.postCookieUri);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","wu");

        post.setHeader("Content-Type","application/json");
        StringEntity entity = new StringEntity(jsonObject.toString(),"utf-8");
        post.setEntity(entity);
        client.setCookieStore(this.store);

        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
       JSONObject jsonObject1 = new JSONObject(result);
       String name = (String) jsonObject1.get("name");
        System.out.println(response.getStatusLine().getStatusCode());
        assertEquals("wujianjun",name);
        assertEquals(200,response.getStatusLine().getStatusCode());
    }
}
