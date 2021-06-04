package edu.jluzh.test_layuimini.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.jluzh.test_layuimini.bean.OrderList;
import edu.jluzh.test_layuimini.pojo.UserResult;
import edu.jluzh.test_layuimini.pojo.UserTable;
import edu.jluzh.test_layuimini.service.ICarService;
import edu.jluzh.test_layuimini.service.IOrderService;
import edu.jluzh.test_layuimini.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

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
    @Autowired
    IUserService userService;
    @Autowired
    ICarService carService;
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

    @PostMapping("/bOrder")
    public UserTable orderListForOneUser(int page,int limit,HttpSession session){
        int userid = (int) session.getAttribute("userId");
        PageInfo<OrderList> orderListPageInfo = orderService.findDoingOrderList(page,limit,userid);
        userTable.setCode(0);
        userTable.setMsg("正常");
        userTable.setCount(orderListPageInfo.getTotal());
        userTable.setData(orderListPageInfo.getList());
        return userTable;
    }
    @PostMapping("/back")
    public UserResult orderBack(@RequestParam(value = "params") int params, @RequestParam(value = "params2") String params2,HttpSession session){
        int userid = (int) session.getAttribute("userId");
        System.out.println("orderId"+params);
        System.out.println("carId"+params2);
        //修改订单表状态
        Date date = new Date();
        orderService.backCar(params);
        //修改用户状态
        userService.userBack(userid);
        //修改汽车状态
        carService.updateBack(params2);
        result.setStatus("0");
        result.setMessage("正常");
        return result;
    }

    @PostMapping("/orderHistory")
    public UserTable OrderHistory(int page,int limit,HttpSession session){
        int userid = (int) session.getAttribute("userId");
        PageInfo<OrderList> pageInfo = orderService.findOrderById(page,limit,userid);
        userTable.setCode(0);
        userTable.setMsg("正常");
        userTable.setCount(pageInfo.getTotal());
        userTable.setData(pageInfo.getList());
        return userTable;
    }
}
