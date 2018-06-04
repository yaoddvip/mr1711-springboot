package com.mr.service.impl;

import com.mr.mapper.UserMapper;
import com.mr.model.User;
import com.mr.service.UserService;
import com.mr.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ydd on 2018/5/30.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //@Autowired
    //private RedisUtil redisUtil;

    @Override
    public User getById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    /**
     * allEntries=true表示删除缓存中的所有数据。
     * @param user
     */
    @CacheEvict(value = "userList",allEntries = true)
    @Transactional
    @Override
    public void save(User user) {
        userMapper.insertSelective(user);
    }

    /**
     * 查询集合
     *  @Cacheable
     *      注解代表从缓存中查询指定的key,如果有,从缓存中取,不再执行方法.
     *      如果没有则执行方法,并且将方法的返回值和指定的key关联起来,放入到缓存中.

        @CacheEvict
            注解代表则是从缓存中清除指定的key对应的数据.使用的代码如下:
     */
    @Cacheable(value = "userList",key = "1")
    public List<User> list() {

        List<User> list = userMapper.selectByExample(null);

        return list;
    }
    //使用配置文件版的redis使用方法
    /*@Override
    public List<User> list() {

        if(redisUtil.hasKey("userList")){
            List<User> list = (List<User>) redisUtil.get("userList");
            return list;
        }

        List<User> list = userMapper.selectByExample(null);

        //查询到数据之后将数据存放在redis中
        redisUtil.set("userList",list);

        return list;
    }*/

    /**
     * 删除
     * @param id
     */
    @Transactional
    @Override
    public void del(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public void update(User user) {

        userMapper.updateByPrimaryKey(user);

    }

}
