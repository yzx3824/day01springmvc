package com.yzx.controller;

import com.yzx.domain.Account;
import com.yzx.domain.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: day01springmvc
 * @description: 请求参数绑定
 * @author: yanzhixian
 * @create: 2020-06-21 17:19
 */
@Controller
@RequestMapping(path="/param")
public class ParamController {

    /**
     * 请求参数绑定入门
     * @return
     */
    @RequestMapping(value = "/testParam")
    public String testParam(String username, String password) {
        System.out.println("testParam执行了...");
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        return "success";
    }

    /**
     * 请求参数绑定把数据封装到JavaBean的类中
     * @param account
     * @return
     */
    @RequestMapping(path="/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("saveAccount执行了...");
        System.out.println(account);
        return "success";
    }


    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping(path="/saveUser")
    public String saveUser(User user) {
        System.out.println("saveUser执行了...");
        System.out.println(user);
        return "success";
    }

    /**
     * 原生的API
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(path="/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("testServlet执行了...");
        
        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);

        return "success";
    }



}
