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
}
