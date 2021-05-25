package edu.jluzh.test_layuimini.controller;

import com.github.pagehelper.PageInfo;
import edu.jluzh.test_layuimini.bean.OrderList;
import edu.jluzh.test_layuimini.pojo.UserResult;
import edu.jluzh.test_layuimini.pojo.UserTable;
import edu.jluzh.test_layuimini.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/23 9:04
 * @version:
 * @modified By:
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    IOrderService orderService;
    UserTable userTable = new UserTable();
    UserResult result = new UserResult();

    //返回订单列表
    @PostMapping("/getOrderlist")
    public UserTable getOrderList(int page,int limit,String id){
        userTable.setMsg("正常");
        userTable.setData(0);
        PageInfo<OrderList> pageInfo = new PageInfo<>();
        if(id == null){
           pageInfo = orderService.findAllOrder(page, limit);
        }else {
             int userid = Integer.parseInt(id);
            pageInfo = orderService.findOrderById(page,limit,userid);
         }
        userTable.setCount(pageInfo.getTotal());
        userTable.setData(pageInfo.getList());
        return userTable;
    }

    //删除订单
    @PostMapping("/delete")
    public UserResult deleteOrder(@RequestParam(value = "params[]") int[] params){
        for (int param : params) {
            orderService.deleteOrder(param);
        }
        result.setMessage("正常");
        result.setStatus("0");
        return result;
    }
    //订单编辑
    @PostMapping("/orderEdit")
    public UserResult updateOrder(OrderList orderList, HttpSession session){
        Integer orderId = (Integer) session.getAttribute("orderId");
        System.out.println(orderId);
        System.out.println(orderList.getUserId());
        Date begindate = orderList.getBeginDate();

        orderList.setOrderId(orderId);
        orderService.uodateOrderList(orderList);
        result.setMessage("正常");
        result.setStatus("0");
        return result;
    }

}
