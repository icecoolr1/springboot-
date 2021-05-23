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
    public int getCarTotal();
    public List<Car> findAllCar();

    public List<Car> findCarByLicense(String license);

    public void deleteCarList(int carId);

    public void updareCar(Car car);

    public void addCar(Car car);
}
