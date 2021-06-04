package edu.jluzh.test_layuimini.controller;

import edu.jluzh.test_layuimini.bean.Car;
import edu.jluzh.test_layuimini.bean.OrderList;
import edu.jluzh.test_layuimini.bean.User;
import edu.jluzh.test_layuimini.pojo.UserResult;
import edu.jluzh.test_layuimini.service.ICarService;
import edu.jluzh.test_layuimini.service.IOrderService;
import edu.jluzh.test_layuimini.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/31 19:15
 * @version:
 * @modified By:
 */
@RestController
@RequestMapping("/userHandler")
public class UserHandlerController {
    UserResult result = new UserResult();
    @Autowired
    IUserService userService;
    @Autowired
    ICarService carService;
    @Autowired
    IOrderService orderService;
    OrderList orderList = new OrderList();
    @RequestMapping("/userLogin")
    public UserResult userHandlerAdd(User user){
        System.out.println(user);
        userService.addUser(user);
        result.setMessage("正常");
        result.setStatus("0");
        return result;
    }

    @PostMapping("bCar")
    public UserResult userHandlerBCar(@RequestParam(value = "params") int params, HttpSession session){
        //获取汽车id值
        System.out.println(params);
        int userId = (int) session.getAttribute("userId");
        //修改用户表状态
        userService.userBorrow(userId);
        Car car =  carService.findCarById(params);
        System.out.println("汽车为"+car);
        //修改订单表状态
        orderList.setBeginDate(new Date());
        orderList.setLicenseNumber(car.getLicenseNumber());
        orderList.setOrderStatus("订单进行中");
        orderList.setUserId(userId);
        orderService.borrowCar(orderList);
        //修改汽车表状态
        carService.updateBorrow(params);
        result.setMessage("正常");
        result.setStatus("0");
        System.out.println(params);
        return result;
    }




}
