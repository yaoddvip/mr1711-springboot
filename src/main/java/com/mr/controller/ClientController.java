package com.mr.controller;

import com.mr.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ydd on 2018/6/4.
 */
@RestController
public class ClientController {


    @GetMapping("/client/test1")
    public String test1(){
        System.out.println("test1方法被调用！");
        return "success";
    }

    @GetMapping("/client/test2")
    public String test2(String name , Integer age){
        System.out.println(name+"------"+age);
        System.out.println("test2方法被调用！");
        return "success";
    }

    @PostMapping("/client/test3")
    public String test3(User user){
        System.out.println(user);
        System.out.println("test3方法被调用！");
        return "success";
    }

    @PostMapping("/client/test4")
    public User test3(){
        //模拟查询
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setAge(19);

        System.out.println("test4方法被调用！");
        return user;
    }


}
