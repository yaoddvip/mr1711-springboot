package com.mr.service;

import com.mr.model.User;

import java.util.List;

/**
 * Created by ydd on 2018/5/30.
 */
public interface UserService {
    User getById(Integer id);

    void save(User user);

    List<User> list();

    void del(Integer id);

    void update(User user);
}
