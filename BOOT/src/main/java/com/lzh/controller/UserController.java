package com.lzh.controller;

import com.lzh.domain.User;
import com.lzh.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("get/{uid}")
    @ResponseBody
    public User get(@PathVariable String uid){
        User user = userService.getUserById(uid);
        return user;

    }


    @HystrixCommand(fallbackMethod = "testFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "6"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000")
    })
    @RequestMapping("test/{id}")
    @ResponseBody
    public String test(@PathVariable int id){
        if(id==1){
            System.out.println("xxxxxxxxxx");
            throw new RuntimeException("cuowu");
        }
        return "11111111111";

    }

    public String testFallback(@PathVariable int id){

        return "服务器错误";

    }

    @RequestMapping("test2")
    // @ResponseBody
    public void test2() throws IOException {
        System.out.println(11);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println(request.getParameter("name"));
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("aaaaaa");

        //response2.getWriter().write("bbbb");
        //return null;

    }

    @RequestMapping("test3")
    public void test3(HttpServletResponse response2){
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        try {
            response.getWriter().write("123");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
