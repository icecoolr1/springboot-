package edu.jluzh.test_layuimini.mapper;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import edu.jluzh.test_layuimini.bean.OrderList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/23 9:08
 * @version:
 * @modified By:
 */
@Mapper
public interface IOrderMapper {
    //查询所有订单
    List<OrderList> findAllOrder();

    //查询订单总数
    int findOrderTotal();

    //按月查询订单
    int findOrderByMonth(int month);

    //删除订单
    void deleteOrder(int id);

    //按用户id查询订单
    List<OrderList> findOrderById(int id);

    //更新订单
    void updateOrder(OrderList order);

    //通过订单id查询订单
    OrderList findOrderByOrderId(int id);

    void BorrowCar(OrderList orderList);

    List<OrderList> findDoingOrderList(int id);

    void backCar(@Param("id") int id);


}
