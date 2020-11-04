package com.mengxuegu.springboot.mapper;

import com.mengxuegu.springboot.entities.Bill;
import com.mengxuegu.springboot.entities.ProviderBill;
import com.mengxuegu.springboot.entities.User;

import java.util.List;

public interface UserMapper {
    List<User> getUsers(User user);
    User getUserById(Integer id);
    int addUser(User user);
    int updateUser(User user);
    int deleteUserById(Integer id);
    User getUserByUsername(String username);
}
