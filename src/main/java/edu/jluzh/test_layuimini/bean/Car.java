package edu.jluzh.test_layuimini.bean;

import java.io.Serializable;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/22 15:08
 * @version:
 * @modified By:
 */
public class Car implements Serializable {
    private Integer carId;//汽车id号
    private String licenseNumber;//汽牌号
    private String carStatus;//车辆状态
    private String carDescribe;//车辆描述
    private CarImg carImg;//图片地址

    public Car() {
    }

    public Car(Integer carId, String licenseNumber, String carStatus, String carDescribe) {
        this.carId = carId;
        this.licenseNumber = licenseNumber;
        this.carStatus = carStatus;
        this.carDescribe = carDescribe;
    }

    public Car(Integer carId, String licenseNumber, String carStatus, String carDescribe, CarImg carImg) {
        this.carId = carId;
        this.licenseNumber = licenseNumber;
        this.carStatus = carStatus;
        this.carDescribe = carDescribe;
        this.carImg = carImg;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getCarDescribe() {
        return carDescribe;
    }

    public void setCarDescribe(String carDescribe) {
        this.carDescribe = carDescribe;
    }

    public CarImg getCarImg() {
        return carImg;
    }

    public void setCarImg(CarImg carImg) {
        this.carImg = carImg;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", carStatus='" + carStatus + '\'' +
                ", carDescribe='" + carDescribe + '\'' +
                ", carImg=" + carImg +
                '}';
    }
}
