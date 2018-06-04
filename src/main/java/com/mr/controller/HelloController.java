package com.mr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ydd on 2018/5/30.
 */
@Controller
//@RestController  //=@Controller+@ResponseBody
public class HelloController {

    //get  post   delete  put

    //@RequestMapping(value = "/hello" , method = RequestMethod.POST)
    @PostMapping("/hello")
    public String hello(){
        return "hello springboot post ....";
    }

    @GetMapping("/hello")
    public String hello1(){
        return "hello springboot get xxx....";
    }


    @GetMapping("/hello/test1")
    public String test1(ModelMap map){
        map.put("xxx","hello springboot ...");

        return "aaa";
    }

}
