package edu.jluzh.test_layuimini.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/22 15:08
 * @version:
 * @modified By:
 */
public class OrderList implements Serializable {
    private Integer orderId;
    private String userId;
    private String licenseNumber;
    private String orderStatus;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date beginDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date closeDate;

    public OrderList() {
    }

    public OrderList(Integer orderId, String userId, String licenseNumber, String orderStatus, Date beginDate, Date closeDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.licenseNumber = licenseNumber;
        this.orderStatus = orderStatus;
        this.beginDate = beginDate;
        this.closeDate = closeDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId='" + userId + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", beginDate=" + beginDate +
                ", closeDate=" + closeDate +
                '}';
    }
}
