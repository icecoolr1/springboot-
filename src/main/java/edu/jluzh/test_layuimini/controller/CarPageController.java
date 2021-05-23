package edu.jluzh.test_layuimini.controller;

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
    @GetMapping("/carlist")
    public String toCarList(){
        return "pages/carlist";
    }
    @GetMapping("/carEdit")
    public String toCarEdit(HttpSession session,int id ){
        session.setAttribute("carId",id);
        return "pages/carEdit";
    }
    @GetMapping("/carAdd")
    public String toCarAdd(){
        return "pages/carAdd";
    }
}
