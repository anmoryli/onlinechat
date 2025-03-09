package com.anmory.onlinechat.model;

/**
 * @author Anmory/李梦杰
 * @description TODO
 * @date 2025-03-08 下午9:20
 */

public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String phone;

    public int getUserid() {
        return userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public void setUserid(int userid) {
        this.userId = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
