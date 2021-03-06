package edu.jluzh.test_layuimini.service;

import com.github.pagehelper.PageInfo;
import edu.jluzh.test_layuimini.bean.Car;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/22 19:50
 * @version:
 * @modified By:
 */
public interface ICarService {
    PageInfo<Car> findAllCar(int page,int limit);
    PageInfo<Car> findCarByLicence(int page,int limit,String license);
    void deleteCarList(int carId);
    void updateCar(Car car);
    void addCar(Car car);
    int findCarTotal();
    Car findCarById(int id);
    PageInfo<Car> findAllCarWithImg(int page,int limit);
    PageInfo<Car> findAllCarWithImgByLicense(int page,int limit,String license);
    Car findAllCarWithImgById(int id);
    int findCarId(String license);
    PageInfo<Car> findCarsForUse(int page,int limit);
    void updateBorrow(int carid);
    void updateBack(String number);
    Car findCarByLi(String license);


}
