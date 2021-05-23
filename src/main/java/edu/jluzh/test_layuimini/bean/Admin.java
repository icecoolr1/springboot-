package edu.jluzh.test_layuimini.bean;

import java.io.Serializable;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/22 15:07
 * @version:
 * @modified By:
 */
public class Admin implements Serializable {
    private String adminId;
    private String adminName;
    private String adminPassword;

    public Admin() {
    }

    public Admin(String adminId, String adminName, String adminPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}
