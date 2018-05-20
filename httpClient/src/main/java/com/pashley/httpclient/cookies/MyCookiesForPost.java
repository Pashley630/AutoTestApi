package com.pashley.httpclient.cookies;

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
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private ResourceBundle resourceBundle;
    private String baseUrl;
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        resourceBundle = ResourceBundle.getBundle("application");
        baseUrl = resourceBundle.getString("test.url");
    }

    @Test
    public void getCookies() throws IOException {
        String url = baseUrl+resourceBundle.getString("getCookies.uri");

        HttpGet httpGet = new HttpGet(url);
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(httpGet);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

        store = ((DefaultHttpClient) httpClient).getCookieStore();
        List<Cookie> list = store.getCookies();
        for (Cookie cookie : list){
            System.out.println("name = "+cookie.getName()+", value = "+cookie.getValue());
        }
    }

    @Test(dependsOnMethods = {"getCookies"})
    public void testPostMethod() throws IOException {
        String url = baseUrl+resourceBundle.getString("post.with.cookies");
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","huhansan");
        jsonObject.put("age","18");

        httpPost.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(jsonObject.toString(),"utf-8");
        httpPost.setEntity(entity);

        ((DefaultHttpClient) httpClient).setCookieStore(store);

        HttpResponse response = httpClient.execute(httpPost);
        String result = EntityUtils.toString(response.getEntity());

        System.out.println("带参数和cookies请求的post 成功啦 ！ status ="+response.getStatusLine().getStatusCode());
        System.out.println("result ==="+result);

    }
}
