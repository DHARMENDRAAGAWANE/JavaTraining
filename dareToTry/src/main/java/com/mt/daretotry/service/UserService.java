package com.mt.daretotry.service;

import java.util.List;

import com.mt.daretotry.entity.User;

public interface UserService {

    User create(User object);

    User find(String id);

    User findByUsername(String userName);

    List<User> findAll();

    User update(String id, User object);

    String delete(String id);
}