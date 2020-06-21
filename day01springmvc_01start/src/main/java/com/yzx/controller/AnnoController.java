package com.yzx.controller;

import com.yzx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @program: day01springmvc
 * @description: 常用的注解
 * @author: yanzhixian
 * @create: 2020-06-21 18:37
 */
@Controller
@RequestMapping(value="/anno")
@SessionAttributes(value={"msg"})   // 把msg=美美存入到session域对中
public class AnnoController {

    /**
     * RequestParam注解
     * @param username
     * @return
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username) {
        System.out.println("testRequestParam执行了...");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取到请求体的内容
     * @param body
     * @return
     */
    @RequestMapping(path="/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("testRequestBody执行了...");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解
     * @param id
     * @return
     */
    @RequestMapping(path="/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name="sid") String id) {
        System.out.println("testPathVariable执行了...");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头的值
     * @param header
     * @return
     */
    @RequestMapping(path="/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println("testRequestHeader执行了...");
        System.out.println(header);
        return "success";
    }

    /**
     * 获取Cookie的值
     * @param cookieValue
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println("testCookieValue执行了...");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute注解
     * @return
     */
//    @RequestMapping("/testModelAttribute")
//    public String testModelAttribute() {
//        System.out.println("testModelAttribute执行了...");
//        return "success";
//    }
//
//    @ModelAttribute
//    public void showUser() {
//        System.out.println("showUser执行了...");
//    }

//    @RequestMapping("/testModelAttribute")
//    public String testModelAttribute(User user) {
//        System.out.println("testModelAttribute执行了...");
//        System.out.println(user);
//        return "success";
//    }
//
//    /**
//     * 该方法会先执行
//     */
//    @ModelAttribute
//    public User showUser(String uname) {
//        System.out.println("showUser执行了...");
//        // 通过用户查询数据库（模拟）
//        User user = new User();
//        user.setUname(uname);
//        user.setAge(30);
//        user.setDate(new Date());
//        return user;
//    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute(value = "abc") User user) {
        System.out.println("testModelAttribute执行了...");
        System.out.println(user);
        return "success";
    }

    /**
     * 该方法会先执行
     */
    @ModelAttribute
    public void showUser(String uname, Map<String, User> map) {
        System.out.println("showUser执行了...");
        // 通过用户查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(30);
        user.setDate(new Date());
        map.put("abc", user);
    }

    /**
     * 原生的HttpServletRequest
     * @param request
     * @return
     */
//    @RequestMapping(value="/testSessionAttributes")
//    public String testSessionAttributes(HttpServletRequest request) {
//        System.out.println("testSessionAttributes执行了...");
//        request.setAttribute("msg", "美美");
//        return "success";
//    }

    @RequestMapping(value="/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes执行了...");
        // 底层会存储到request域对象中
        model.addAttribute("msg", "美美");
        return "success";
    }

    /**
     * 获取session域值
     * @param modelMap
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("getSessionAttributes执行了...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除session域值
     * @param status
     * @return
     */
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status) {
        System.out.println("delSessionAttributes执行了...");
        status.setComplete();
        return "success";
    }

}
