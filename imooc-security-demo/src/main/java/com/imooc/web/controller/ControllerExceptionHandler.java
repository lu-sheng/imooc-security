package com.imooc.web.controller;

import com.imooc.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 错误处理器
 * LN
 * 2019/8/29 0029 13:57
 */
//处理其他controller抛出的异常
@ControllerAdvice
public class ControllerExceptionHandler {
    //其他控制其中任何一个方法抛出UserNotExistException异常都交给这个方法来处理
    @ExceptionHandler(UserNotExistException.class)
    //用这个注解将返回结果转为json格式的数据
    @ResponseBody
    //设置异常的状态码
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleUserNotExistException(UserNotExistException e) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", e.getId());
        result.put("message", e.getMessage());
        return result;
    }
}
