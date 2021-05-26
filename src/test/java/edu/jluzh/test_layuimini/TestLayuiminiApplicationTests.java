package edu.jluzh.test_layuimini;

import com.baidu.aip.ocr.AipOcr;
import edu.jluzh.test_layuimini.bean.CarImg;
import edu.jluzh.test_layuimini.mapper.ICarMapper;
import edu.jluzh.test_layuimini.service.ICarImgService;
import edu.jluzh.test_layuimini.service.ICarService;
import edu.jluzh.test_layuimini.service.IOrderService;
import edu.jluzh.test_layuimini.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;

@SpringBootTest
class TestLayuiminiApplicationTests {
    @Autowired
    ICarMapper carMapper;
    @Autowired
    IUserService userService;
    @Autowired
    IOrderService orderService;
    @Autowired
    ICarImgService carImgService;
    public static final String APP_ID = "24242714";
    public static final String API_KEY = "hdyQSqxI7NGPhmXbOZ6dPvpV";
    public static final String SECRET_KEY = "l8VT9nPcoqK3AG3lIHyXCRQkqy8O4dWi";

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

    @Test
    public void testImg(){
        System.out.println(carMapper.findCarByResultMap());
    }


    @Test
    public void insert(){
        CarImg img = new CarImg();
        img.setImgPath("test");
        img.setLicenseNumber("苏EB06E6");
        carImgService.addCarImg(img);

    }


}
