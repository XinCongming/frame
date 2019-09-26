package com.zpark.springbt.controller;

import com.zpark.springbt.model.User;
import com.zpark.springbt.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用Thymeleaf 模板引擎：把index.html这样的前台页面放在templates这个路径下
 */
@Controller
@RequestMapping()
public class IndexController {

    @Resource
    public UserService userService;

    @RequestMapping("/")
    public String testModel() {
        return "login";
    }

    @RequestMapping("/dashboard")
    public String dashbord() {
        return "dashboard";
    }

    @RequestMapping(value = "/index.html")
    public String testModel1() {
        return "index";
    }

    @RequestMapping("/editPassword2")
    @ResponseBody
    public String editPassword2(@RequestBody User user) {
        String password = userService.getPassword(user.getUsername());
        if(password !=null) {
            if(user.getPassword().equals(password))
            {
                return "1";
            }else {
                return "2";
            }
        }
        return "3";
    }
}