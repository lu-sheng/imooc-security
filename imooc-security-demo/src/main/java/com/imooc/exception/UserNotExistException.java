package com.imooc.exception;

/**
 * 这是我们自定义的异常信息
 * LN
 * 2019/8/29 0029 13:53
 */
public class UserNotExistException extends RuntimeException {
    private String id;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
