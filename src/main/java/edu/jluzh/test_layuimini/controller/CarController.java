package edu.jluzh.test_layuimini.controller;

import com.github.pagehelper.PageInfo;
import edu.jluzh.test_layuimini.bean.Car;
import edu.jluzh.test_layuimini.pojo.UserResult;
import edu.jluzh.test_layuimini.pojo.UserTable;
import edu.jluzh.test_layuimini.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/22 19:24
 * @version:
 * @modified By:
 */
@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    ICarService carService;

    UserResult result = new UserResult();
    @PostMapping("/getCarList")
    public UserTable getCarList(int page, int limit,String licenseNumber){
        UserTable table = new UserTable();
        PageInfo<Car> pageInfoAll = carService.findAllCar(page, limit);
        PageInfo<Car> carPageInfo = carService.findCarByLicence(page, limit, licenseNumber);
        table.setCode(0);
        table.setMsg("成功");
        if (licenseNumber==null){
            table.setCount(pageInfoAll.getTotal());
            table.setData(pageInfoAll.getList());
        }else {
            table.setCount(carPageInfo.getTotal());
            table.setData(carPageInfo.getList());
        }
        return table;
    }

    @PostMapping("/delete")
    public UserResult deleteCarlist(@RequestParam(value = "params[]") int[] params){

        for (int i : params) {
            carService.deleteCarList(i);
        }
        result.setStatus("0");
        result.setMessage("Ok");
        return result;
    }

    @PostMapping("/editCar")
    public UserResult updateCar(HttpSession session,Car car){
        Integer id = (Integer) session.getAttribute("carId");
        car.setCarId(id);
        carService.updateCar(car);
        result.setStatus("0");
        result.setMessage("Ok");
        return result;
    }

    @PostMapping("/carAdd")
    public UserResult addCar(Car car){
        carService.addCar(car);
        result.setStatus("0");
        result.setMessage("Ok");
        return result;
    }

}
