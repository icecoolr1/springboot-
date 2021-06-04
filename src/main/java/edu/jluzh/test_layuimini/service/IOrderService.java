package edu.jluzh.test_layuimini.service;

import com.github.pagehelper.PageInfo;
import edu.jluzh.test_layuimini.bean.Car;
import edu.jluzh.test_layuimini.bean.OrderList;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/23 9:07
 * @version:
 * @modified By:
 */
public interface IOrderService {
    //分页查询订单列表
    PageInfo<OrderList> findAllOrder(int limit, int page);
    //订单总数
    int findOrderTotal();
    //按月查询订单
    int findOrderByMonth(int month);
    int[] findOrderByMonths();
    //删除订单
    void deleteOrder(int id);
    //通过id查询订单
    PageInfo<OrderList> findOrderById(int page,int limit,int userId);
    //更新订单列表
    void uodateOrderList(OrderList order);

    OrderList findOrderByOrderID(int id);
    PageInfo<OrderList> findDoingOrderList(int page,int limit,int userId);



    void borrowCar(OrderList orderList);
    void backCar( int orderId);

}
