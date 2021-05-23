package edu.jluzh.test_layuimini;

import edu.jluzh.test_layuimini.service.IOrderService;
import edu.jluzh.test_layuimini.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class TestLayuiminiApplicationTests {
    @Autowired
    IUserService userService;
    @Autowired
    IOrderService orderService;

    @Test
    public void testDeleteUser(){
        userService.deleteUser(1);
    }


//    @Test
//    public void testSelectUSer(){
//        UserMessage userMessage  = new UserMessage();
//        userMessage.setUserSex("女");
//        PageInfo<User> pageInfo = userService.searchUser(userMessage);
//        List<User> list = pageInfo.getList();
//        System.out.println(pageInfo.getTotal());
//        for (User user : list) {
//            System.out.println("进入方法");
//            System.out.println(user);
//        }
//    }

    @Test
    public void testMonth(){
        System.out.println(orderService.findOrderByMonth(10));
        System.out.println(Arrays.toString(orderService.findOrderByMonths()));
    }
}
