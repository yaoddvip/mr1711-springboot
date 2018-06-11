package com.mr.controller;

import com.mr.model.User;
import com.mr.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ydd on 2018/6/11.
 */
@RestController
@Api("用户信息接口")  //修饰整个类，描述Controller的作用
public class SwgUserController {

    @Autowired
    private UserService userService;

    // /swg/user/{id}
    //1：通过id查询
    //@ApiOperation :对一个类中的方法进行描述
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    // 参数： required ：必填项
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/swg/user/{id}")
    public User getById(@PathVariable Integer id){
        User user = userService.getById(id);
        return user;
    }

    //2：查询全部
    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @GetMapping("/swg/user")
    public List<User> getList(){
        List<User> list = userService.list();
        return list;
    }

    //3：增加
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping("/swg/user")
    //@RequestBody :将Request中的json数据转换为user对象
    public void save(@RequestBody User user){
        userService.save(user);
    }

    //4：通过id删除数据
    @ApiOperation(value="通过id删除数据", notes="根据url的id来删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @DeleteMapping("/swg/user/{id}")
    public void delById(@PathVariable Integer id){
        userService.del(id);
    }

    //5：通过id修改数据
    @ApiOperation(value="更新信息", notes="根据url的id来指定更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    @PutMapping("/swg/user/{id}")
    public void update(@PathVariable Integer id,@RequestBody User user){
        user.setId(id);
        userService.update(user);
    }

}
