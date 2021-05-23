package edu.jluzh.test_layuimini.bean;

import java.io.Serializable;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/20 20:23
 * @version:
 * @modified By:
 */
public class User implements Serializable {
    private Integer userId;//用户id
    private String userName;//用户名
    private String userPassword;//用户密码
    private String userStatus;//当前用户状态
    private String userSex;//用户性别
    private String userMail;//用户邮箱
    private String userPhone;//用户手机号
    private Integer userAge;//用户年龄

    public User() {
    }

    public User(Integer userId, String userName, String userPassword, String userStatus, String userSex, String userMail, String userPhone, Integer userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userStatus = userStatus;
        this.userSex = userSex;
        this.userMail = userMail;
        this.userPhone = userPhone;
        this.userAge = userAge;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
