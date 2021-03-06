package edu.jluzh.test_layuimini.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.jluzh.test_layuimini.bean.Car;
import edu.jluzh.test_layuimini.mapper.ICarMapper;
import edu.jluzh.test_layuimini.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/22 19:50
 * @version:
 * @modified By:
 */
@Service
public class CarServiceImpl implements ICarService {
    @Autowired
    ICarMapper carMapper;
    @Override
    public PageInfo<Car> findAllCar(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<Car> carList = carMapper.findAllCar();
        PageInfo<Car> pageInfo = new PageInfo<>(carList);
        return pageInfo;
    }

    @Override
    public PageInfo<Car> findCarByLicence(int page, int limit, String license) {
        PageHelper.startPage(page, limit);
        List<Car> cars = carMapper.findCarByLicense(license);
        PageInfo<Car> pageInfo = new PageInfo<>(cars);
        return pageInfo;
    }

    @Override
    public void deleteCarList(int carId) {
        carMapper.deleteCarList(carId);
    }

    @Override
    public void updateCar(Car car) {
        carMapper.updareCar(car);
    }

    @Override
    public void addCar(Car car) {
        carMapper.addCar(car);
    }

    @Override
    public int findCarTotal() {
        return carMapper.getCarTotal();
    }

    @Override
    public Car findCarById(int id) {
        return carMapper.findCarById(id);
    }

    @Override
    public PageInfo<Car> findAllCarWithImg(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<Car> carList = carMapper.findCarByResultMap();
        PageInfo<Car> pageInfo = new PageInfo<>(carList);
        return pageInfo;
    }



//    @Override
//    public String findLicense(int id) {
//     return  carMapper.findLicense(id);
//    }

    @Override
    public PageInfo<Car> findAllCarWithImgByLicense(int page, int limit, String license) {
        PageHelper.startPage(page, limit);
        List<Car> cars = carMapper.findCarByResultMapWithLicense(license);
        PageInfo<Car> pageInfo = new PageInfo<>(cars);
        return  pageInfo;
    }

    @Override
    public Car findAllCarWithImgById(int id) {
        return carMapper.findCarByResultMapWithLicenseWithId(id);

    }

    @Override
    public int findCarId(String license) {
       return carMapper.findCarId(license);
    }

    @Override
    public PageInfo<Car> findCarsForUse(int page, int limit) {
       PageHelper.startPage(page,limit);
       List<Car> cars = carMapper.findCarForUser();
       return new PageInfo<>(cars);
    }

    @Override
    public void updateBorrow(int carid) {
        carMapper.updateBorrow(carid);
    }

    @Override
    public void updateBack(String number) {
        carMapper.updateBack(number);
    }

    @Override
    public Car findCarByLi(String license) {
        return carMapper.findCarByLi(license);

    }
}
