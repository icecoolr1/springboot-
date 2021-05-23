package edu.jluzh.test_layuimini.service;

import com.github.pagehelper.PageInfo;
import edu.jluzh.test_layuimini.bean.OrderList;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/23 9:07
 * @version:
 * @modified By:
 */
public interface IOrderService {
    PageInfo<OrderList> findAllOrder(int limit, int page);
    int findOrderTotal();
    int findOrderByMonth(int month);
    int[] findOrderByMonths();
    void deleteOrder(int id);
    PageInfo<OrderList> findOrderById(int page,int limit,int userId);
    void uodateOrderList(OrderList order);
}
