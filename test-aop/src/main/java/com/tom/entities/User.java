package com.tom.entities;

/**
 * Created by tom on 2016/5/4.
 */
public class User extends IdEntity{

     //   private int id;
        private String username;
        private String password;
        private Integer sex;

    public User(String username, String password, Integer sex) {
        this.username=username;
        this.password=password;
        this.sex=sex;
    }

    //setter和getter方法省略……

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
