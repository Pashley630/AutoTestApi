package com.pashley.springboot;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是所有的get方法")
public class MyGetMethod {


    @RequestMapping(value = "/getCookie")
    @ApiOperation(value = "get方法获取cookie")
    public String getCookies(HttpServletResponse response){

        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜您获取cookies成功 ~";
    }

    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value = "要求传递cookie才可访问的get方法")
    public String getCookies(HttpServletRequest request){

        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return "您没有携带cookies来访问啊 ！";
        }
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "你带了cookies呢！cookie name ="+cookie.getName()+",cookie value ="+cookie.getValue();
            }
        }
        return "不知道您有没有传cookies哈哈哈哈哈";
    }

    //url=http://localhost:port/get/with/param/start/end
    @RequestMapping(value = "/get/with/param/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "带参数的get请求方式一")
    public String getWithParamOne(@PathVariable String start, @PathVariable String end){
        String result = "带参数的get请求方式一：访问成功！！ start ="+start+", end ="+end;
        return  result;
    }

    //url=http://localhost:port/get/with/param?start=?&end=?
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "带参数的get请求方式一")
    public String getWithParamTwo(@RequestParam String start,@RequestParam String end){
        String result = "带参数的get请求方式二：访问成功！！ start ="+start+", end ="+end;
        return  result;
    }
}
