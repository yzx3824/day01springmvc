package com.yzx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: day01springmvc
 * @description: 控制器类
 * @author: yanzhixian
 * @create: 2020-06-10 00:00
 */
@Controller
@RequestMapping(path="/user")
public class HelloController {

    /**
     * 入门案例
     * @return
     */
    @RequestMapping(path="/sayHello")
    public String sayHello(){
        System.out.println("Hello StringMVC");
        return "success";
    }

    /**
     * RequestMapping注解
     * @return
     */
//    @RequestMapping(value="/testRequestMapping")
//    @RequestMapping(value="/testRequestMapping", method = {RequestMethod.POST})
//    @RequestMapping(value="/testRequestMapping", params = {"username"})
    @RequestMapping(value="/testRequestMapping", params = {"username=heihei"}, headers = {"Accept"})
    public String testRequestMapping() {
        System.out.println("测试RequestMapping注解...");
        return "success";
    }
}
