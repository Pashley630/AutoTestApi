package com.pashley.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class MyCookiesForGet {
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
            System.out.println("name = "+cookie.getName()+" value = "+cookie.getValue());
        }
    }

    @Test(dependsOnMethods = {"getCookies"})
    public void getWithCookies() throws IOException {
        String url = baseUrl+resourceBundle.getString("get.with.cookies");

        HttpGet httpGet = new HttpGet(url);
        HttpClient httpClient = new DefaultHttpClient();
        ((DefaultHttpClient) httpClient).setCookieStore(store);
        HttpResponse response = httpClient.execute(httpGet);
        int status = response.getStatusLine().getStatusCode();
        System.out.println("带cookies的get请求成功过啦 ~ status ==="+status);
    }
}
