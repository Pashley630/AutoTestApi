package com.pashley.httpclient.test;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class MyHttpClient {

    @Test
    public void test1() throws IOException {
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(httpGet);
        String str = EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(str);

        CookieStore store = ((DefaultHttpClient) httpClient).getCookieStore();
        List<Cookie> list = store.getCookies();
        for (Cookie cookie : list){
            System.out.println("name = "+cookie.getName()+" value = "+cookie.getValue());
        }
    }
}
