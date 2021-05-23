package edu.jluzh.test_layuimini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/23 9:03
 * @version:
 * @modified By:
 */
@Controller
public class OrderPageController {
    @GetMapping("orderlist")
    public String toOrderList(){
        return "pages/orderlist";
    }
    @GetMapping("orderEdit")
    public String toOrderEdit(int id, HttpSession session){
        session.setAttribute("orderId",id);
        return "pages/orderEdit";
    }

}
