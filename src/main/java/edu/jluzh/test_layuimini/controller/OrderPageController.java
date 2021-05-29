package edu.jluzh.test_layuimini.controller;

import edu.jluzh.test_layuimini.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    IOrderService orderService;
    //转到订单列表
    @GetMapping("orderlist")
    public String toOrderList(){
        return "pages/orderlist";
    }
    //转到订单编辑
    @GetMapping("orderEdit")
    public String toOrderEdit(int id, HttpSession session){
        session.setAttribute("orderId",id);
        //数据回显
        session.setAttribute("Order",orderService.findOrderByOrderID(id));
        return "pages/orderEdit";
    }

}
