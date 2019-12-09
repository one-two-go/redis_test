package com.sunhao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目名称：redistest
 * 类 名 称：User
 * 类 描 述：TODO
 * 创建时间：2019/12/7 9:27 上午
 * 创 建 人：sunhao
 */
public class User implements Serializable{

    private static final long serialVersionUID = 2138365804886952972L;

    private  int id;
    private  String  name;
    private  String gender;
    private  String phonenum;
    private String birthday;
    private  String  email;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phonenum=" + phonenum +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                '}';
    }

    public User(int id, String name, String gender, String phonenum, String birthday, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phonenum = phonenum;
        this.birthday = birthday;
        this.email = email;
    }
    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
