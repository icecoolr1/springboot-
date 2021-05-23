package edu.jluzh.test_layuimini.mapper;

import edu.jluzh.test_layuimini.bean.OrderList;
import org.apache.ibatis.annotations.Mapper;

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
    List<OrderList> findAllOrder();
    int findOrderTotal();
    int findOrderByMonth(int month);
    void deleteOrder(int id);
    List<OrderList> findOrderById(int id);
    void updateOrder(OrderList order);
}
