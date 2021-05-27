package edu.jluzh.test_layuimini.mapper;

import edu.jluzh.test_layuimini.bean.CarImg;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/26 19:23
 * @version:
 * @modified By:
 */
@Mapper
public interface ICarImgMapper {
    //添加图片方法
    void addCarImg(CarImg img);
    //先执行图片delete方法 再执行汽车delete方法
    void deleteImg(int id);
    //更新汽车图片方法
    void updateImg(CarImg img);
    CarImg findCarImg(String licenseNumber);
}
