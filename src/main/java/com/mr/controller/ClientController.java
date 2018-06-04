package com.mr.controller;

import com.mr.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ydd on 2018/6/4.
 */
@RestController
public class ClientController {

    @RequestMapping("client/test1")
    public String test1(){
        System.out.println("client--test1方法被调用...");
        return "success";
    }

    @GetMapping("client/test2")
    public String test2(User user){
        System.out.println(user);
        System.out.println("client--test1方法被调用...");
        return "success";
    }

    @GetMapping("client/test3")
    public User test3(User user){
        user.setName("李四");
        user.setAge(18);
        user.setId(1);
        System.out.println("client--test1方法被调用...");
        return user;
    }

    @PostMapping("client/test4")
    public User test4(User user){
        user.setName("李四");
        user.setAge(18);
        user.setId(2);
        System.out.println("client--test4方法被调用...");
        return user;
    }

    @PostMapping("client/test5")
    public String test5(User user){
        System.out.println(user);
        System.out.println("client--test5方法被调用...");
        return "success";
    }
}
