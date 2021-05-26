package edu.jluzh.test_layuimini.service;

import edu.jluzh.test_layuimini.bean.CarImg;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/26 19:14
 * @version:
 * @modified By:
 */
public interface ICarImgService {
    //添加图片方法
    void addCarImg(CarImg img);
    //先执行图片delete方法 再执行汽车delete方法
    void deleteImg(String licenseNumber);
    //更新汽车图片方法
    void updateImg(CarImg img);
    CarImg findCarImg(String licenseNumber);

}
