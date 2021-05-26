package edu.jluzh.test_layuimini.bean;

import java.io.Serializable;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/26 16:01
 * @version:
 * @modified By:
 */
public class CarImg implements Serializable {
    private String CarImgId;
    private String imgPath;
    private String licenseNumber;

    public CarImg() {
    }

    public CarImg(String carImgId, String imgPath, String licenseNumber) {
        CarImgId = carImgId;
        this.imgPath = imgPath;
        this.licenseNumber = licenseNumber;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getCarImgId() {
        return CarImgId;
    }

    public void setCarImgId(String carImgId) {
        CarImgId = carImgId;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String toString() {
        return "CarImg{" +
                "CarImgId='" + CarImgId + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                '}';
    }
}
