package com.mr.controller;

import com.mr.model.User;
import com.mr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by ydd on 2018/5/30.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 查询集合
     * @param map
     * @return
     */
    @GetMapping("/user")
    public String list(ModelMap map){

        List<User> list = userService.list();
        map.put("list",list);

        return "list";
    }

    @GetMapping("/user/{id}")
    public User getById(@PathVariable("id") Integer id){
        User user = userService.getById(id);
        return user;
    }

    @GetMapping("/addUser")
    public String addUser(){
        return "add";
    }

    /**
     * 增加
     * @param user
     * @return
     */
    @PostMapping("/user")
    public String save(User user){
        userService.save(user);
        return "redirect:/user";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    public String del(@PathVariable Integer id){

        userService.del(id);

        return "redirect:/user";
    }


    @GetMapping("/updatePage/{id}")
    public String updatePage(@PathVariable Integer id , ModelMap map){

        User user = userService.getById(id);
        map.put("user",user);

        return "update";
    }

    @PutMapping("/user")
    public String update(User user){

        userService.update(user);

        return "redirect:/user";
    }

}
