package com.pashley.springboot;


import com.sun.deploy.net.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import  com.pashley.bean.UserBean;

@RestController
@Api(value = "/",description = "这是所有的post方法")
@RequestMapping("/v1")//所有接口添加这个
public class MyPostMethod {


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登陆成功返回cookie")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName",required = true) String username,
                        @RequestParam(value = "password",required = true) String password){

        if (username.equals("zhangsan") && password.equals("123456")){
            Cookie cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "登陆成功啦~";
        }else {
            return "用户名或密码错误 !";
        }
    }

    //需要用jmeter传递cookie 进行测试 jmeter设置CookiesManager.sxxx=true
    @RequestMapping(value = "/getUserList" ,method = RequestMethod.POST)
    @ApiOperation(value = "获取userlist",httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                              @RequestBody UserBean user){

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if (cookie.getName().equals("login")& cookie.getValue().equals("true")
                    & user.getUserName().equals("zhangsan")
                    &user.getPassword().equals("1233456")){
                return user.toString();
            }
        }
        return "参数不合法";
    }
}
