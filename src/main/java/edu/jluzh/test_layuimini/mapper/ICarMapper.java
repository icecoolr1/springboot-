package edu.jluzh.test_layuimini.mapper;

import edu.jluzh.test_layuimini.bean.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/22 19:46
 * @version:
 * @modified By:
 */
@Mapper
public interface ICarMapper {
    //获得汽车总数
    public int getCarTotal();
    //查询所有车辆
    public List<Car> findAllCar();
    //按车牌号查询车辆
    public List<Car> findCarByLicense(String license);
    //删除汽车
    public void deleteCarList(int carId);
    //更新车辆信息
    public void updareCar(Car car);
    //添加车辆
    public void addCar(Car car);
    //通过id查询车辆
    public Car findCarById(int id);
    //多表查询车辆信息
    List<Car> findCarByResultMap();
    //通过车牌号查询carID
    int findCarId(String license);
    //通过车牌号多表查询车辆信息
    List<Car> findCarByResultMapWithLicense(String license);
    //通过carId多表查询车辆信息
    Car findCarByResultMapWithLicenseWithId(int id);
    List<Car> findCarForUser();

    void updateBorrow(int carId);

    void updateBack(String number);

    Car findCarByLi(String license);

}
