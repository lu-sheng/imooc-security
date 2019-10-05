package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import com.imooc.exception.UserNotExistException;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    //获取当前登录用户的信息 方法一
//    @GetMapping("/me")
//    public Object getCurrentUser() {
//        return SecurityContextHolder.getContext().getAuthentication();
//    }

    //    //获取当前登录用户的信息  方法二
//    @GetMapping("/me")
//    public Object getCurrentUser(Authentication authentication) {
//        return authentication;
//    }
    //获取指定的信息
//只获取principal中信息
    @GetMapping("/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "用户查询服务")
    public User queryUserInfo(@ApiParam(value = "用户ID") @PathVariable(name = "id", required = false) String idxxx) {
//        throw new UserNotExistException(idxxx);
        System.out.println("进去queryUserInfo服务");
        User user = new User();
        user.setUsername(idxxx);
        user.setPassword("132145");
        return user;
    }

    //
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
//
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public UserQueryCondition queryByObj(UserQueryCondition userQueryCondition) {
//        System.out.println(userQueryCondition);
//        return userQueryCondition;
//    }
//
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
    @PostMapping
    @JsonView(User.UserDetailView.class)
    public User createUser(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error));
        }
        System.out.println(errors.hasErrors());
        System.out.println(user.getBirthday());
        return user;
    }
//
//    @PutMapping("/{username}")
//    @JsonView(User.UserDetailView.class)
//    public User updateUser(@Valid @RequestBody User user, BindingResult errors) {
//        if (errors.hasErrors()) {
//            errors.getAllErrors().stream().forEach(error -> {
////                FieldError fieldError = (FieldError) error;
////                String message = fieldError.getField()+"====="+error.getDefaultMessage();
//                System.out.println(error.getDefaultMessage());
//            });
//        }
//        System.out.println(errors.hasErrors());
//        System.out.println(user.toString());
//        return user;
//    }

    @DeleteMapping("/{username}")
    @JsonView(User.UserDetailView.class)
    public String updateUser(@PathVariable String username) {

        return "删除成功";
    }

}
