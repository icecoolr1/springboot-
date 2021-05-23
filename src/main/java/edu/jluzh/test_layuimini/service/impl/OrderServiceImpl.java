package edu.jluzh.test_layuimini.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.jluzh.test_layuimini.bean.OrderList;
import edu.jluzh.test_layuimini.mapper.IOrderMapper;
import edu.jluzh.test_layuimini.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/23 9:08
 * @version:
 * @modified By:
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IOrderMapper orderMapper;
    @Override
    public PageInfo<OrderList> findAllOrder(int page, int limit) {
        PageHelper.startPage(page, limit);
        List<OrderList> orderList = orderMapper.findAllOrder();
        PageInfo<OrderList> pageInfo = new PageInfo<>(orderList);
        return pageInfo;
    }

    @Override
    public int findOrderTotal() {
        return  orderMapper.findOrderTotal();
    }

    @Override
    public int findOrderByMonth(int month) {
       return orderMapper.findOrderByMonth(month);
    }

    @Override
    public int[] findOrderByMonths() {
        int[] orderlist = new int[12];
        for(int i = 0 ; i<12; i++){
            orderlist[i] = orderMapper.findOrderByMonth(i);
        }
        return orderlist;
    }

    @Override
    public void deleteOrder(int id) {
        orderMapper.deleteOrder(id);
    }

    @Override
    public PageInfo<OrderList> findOrderById(int page,int limit,int userId) {
        PageHelper.startPage(page,limit);
        List<OrderList> orderLists = orderMapper.findOrderById(userId);
        PageInfo<OrderList> pageInfo = new PageInfo<>(orderLists);
        return  pageInfo;
    }

    @Override
    public void uodateOrderList(OrderList order) {
        orderMapper.updateOrder(order);
    }
}
