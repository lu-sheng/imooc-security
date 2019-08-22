package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import org.junit.Test;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    //    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping(value = "")
    @JsonView(User.UserSimpleView.class)
    public User query(User user) {
        System.out.println(user.toString());
//        List<User> users = new ArrayList<>();
//        users.add(new User("张三", "123"));
//        users.add(new User("李四", "456"));
//        users.add(new User("王五", "789"));
//
//        for (User user : users) {
//            if (user.getUsername().equals(username)) {
//                return user;
//            }
//        }
        return user;
    }

    @GetMapping(value = "/{id:\\d+}")
    //@PathVariable:从url地址中获取参数值
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable(name = "id") String id) {
        User user = new User();
        user.setUsername("tom");
        return user;
    }


}
