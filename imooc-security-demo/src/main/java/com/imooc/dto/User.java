package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * LN
 * 2019/8/22 0022 15:25
 */
public class User {
    public interface UserSimpleView {
    }

    public interface UserDetailView extends UserSimpleView {
    }


    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserSimpleView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
