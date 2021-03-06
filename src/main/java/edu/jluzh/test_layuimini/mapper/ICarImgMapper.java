package edu.jluzh.test_layuimini.mapper;

import edu.jluzh.test_layuimini.bean.Car;
import edu.jluzh.test_layuimini.bean.CarImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
    //通过车牌号查找图片信息
    String findCarImgById(int carId);


}
