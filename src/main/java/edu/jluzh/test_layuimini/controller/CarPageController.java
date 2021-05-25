package edu.jluzh.test_layuimini.controller;

import edu.jluzh.test_layuimini.bean.Car;
import edu.jluzh.test_layuimini.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/22 19:24
 * @version:
 * @modified By:
 */
@Controller
public class CarPageController {
    @Autowired
    ICarService carService;
    //转到列表页面
    @GetMapping("/carlist")
    public String toCarList(){
        return "pages/carlist";
    }
    //转到汽车编辑页面
    @GetMapping("/carEdit")
    public String toCarEdit(HttpSession session,int id ){
        session.setAttribute("carId",id);
        Car car = carService.findCarById(id);
        session.setAttribute("Car",car);
        return "pages/carEdit";
    }
    //转到用户添加页面
    @GetMapping("/carAdd")
    public String toCarAdd(){
        return "pages/carAdd";
    }
}
