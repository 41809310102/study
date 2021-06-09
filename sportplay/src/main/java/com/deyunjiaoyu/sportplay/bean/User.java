package com.deyunjiaoyu.sportplay.bean;
/*
* 用户实体*/
public class User {
    private  int id ;
    private  String username;//用户名
    private  String password;//密码
    private  String  email;//邮箱
    private  boolean state;//标记，逻辑删除
    private  String  role;


    public User(){

       }


    public User( String username, String password, String email, boolean state, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.state = state;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean getState(boolean b) {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", state=" + state +
                ", role='" + role + '\'' +
                '}';
    }
}
