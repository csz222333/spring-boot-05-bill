package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.entities.User;
import com.mengxuegu.springboot.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserMapper userMapper;

    @GetMapping("/users")
    public String list(Map<String, Object> map, User user) {
        logger.info("用户列表查询" + user);

        List<User> users = userMapper.getUsers(user);

        map.put("users", users);
        map.put("username", user.getUsername());
        return "user/list";
    }

    @GetMapping("/user/{id}")
    public String view(@PathVariable("id") Integer id,
                       @RequestParam(value = "type", defaultValue = "view") String type,
                       Map<String, Object> map) {
        logger.info("查询" + id + "的用户详细信息");
        User user = userMapper.getUserById(id);
        map.put("user", user);
// type = null 则进入view.html， type=update 则是进入update.html
        return "user/" + type;
    }

    //修改
    @PutMapping("/user")
    public String update(User user) {
        logger.info("更改用户信息。。。");
//更新操作
        userMapper.updateUser(user);
        return "redirect:users";
    }

    //前往添加 页面
    @GetMapping("/user")
    public String toAddPage() {
        return "user/add";
    }

    @PostMapping("/user")
    public String add(User user){
        logger.info("添加用户"+user);
        userMapper.addUser(user);
                return "redirect:/users";
    }

    public String delet(Integer id){
        logger.info("删除用户,pid="+id);
        userMapper.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/user/pwd")
    public String toPwd(){
        return "main/password";
    }

    @GetMapping("/user/pwd/{oldPwd}")
    @ResponseBody
    public Boolean updatePwd(HttpSession session,@PathVariable("oldPwd") String password){
        User user = (User) session.getAttribute("loginUser");
        if (password.equals(user.getPassword())){
            return true;
        }
            return false;
    }

    @PostMapping("user/pwd")
    public String updatepassord(HttpSession session,String password){
        User user = (User) session.getAttribute("loginUser");
        user.setPassword(password);
        userMapper.updateUser(user);

        return "redirect:/   logout";

    }

}
