package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

//    @GetMapping(value = "/{id:\\d+}")
//    @JsonView(User.UserSimpleView.class)
//    public User queryUserInfo(@PathVariable(name = "id", required = false) String idxxx) {
//        User user = new User();
//        user.setUsername(idxxx);
//        user.setPassword("132145");
////        System.out.println(user.toString());
//        return user;
//    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public List<User> query() {
//        List<User> users = new ArrayList<>();
//        users.add(new User());
//        users.add(new User());
//        users.add(new User());
//        return users;
//    }
//
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public User queryByUsername(@RequestParam(name = "username", required = false, defaultValue = "tom") String nickname) {
//        User user = new User();
//        user.setUsername(nickname);
//        return user;
//    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public UserQueryCondition queryByObj(UserQueryCondition userQueryCondition) {
//        System.out.println(userQueryCondition);
//        return userQueryCondition;
//    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public UserQueryCondition queryByObj(UserQueryCondition userQueryCondition, Pageable pageable) {
//
//        System.out.println(userQueryCondition);
//
//        System.out.println(pageable.toString());
//
//        return userQueryCondition;
//    }
//
//    @PostMapping
//    @JsonView(User.UserDetailView.class)
//    public User createUser(@Valid @RequestBody User user, BindingResult errors) {
//        if (errors.hasErrors()) {
//            errors.getAllErrors().stream().forEach(error -> System.out.println(error));
//        }
//        System.out.println(errors.hasErrors());
//        System.out.println(user.getBirthday());
//        return user;
//    }

    @PutMapping("/{username}")
    @JsonView(User.UserDetailView.class)
    public User updateUser(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
//                FieldError fieldError = (FieldError) error;
//                String message = fieldError.getField()+"====="+error.getDefaultMessage();
                System.out.println(error.getDefaultMessage());
            });
        }
        System.out.println(errors.hasErrors());
        System.out.println(user.toString());
        return user;
    }

}
