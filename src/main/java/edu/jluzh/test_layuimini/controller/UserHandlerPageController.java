package edu.jluzh.test_layuimini.controller;

import edu.jluzh.test_layuimini.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: icecool
 * @date: Created in 2021/5/31 16:08
 * @version:
 * @modified By:
 */
@Controller
public class UserHandlerPageController {
    @Autowired
    IUserService userService;
    @RequestMapping("/userIndex")
    public String userEnter(){
        return "login-1";
    }
    @RequestMapping("/userLogin")
    public String userLogin(){
        return "pages/addUser";
    }
    @RequestMapping("/userHandlerEnter")
    public String userHandlerEnter(String userName, String userPassword, Model model, HttpSession session){
        System.out.println("用户名是:"+userName);

        int flag =  userService.isUserExist(userName,userPassword);
        System.out.println("值为"+flag);
        if(flag !=0){
            session.setAttribute("userId",flag);
            System.out.println(flag);
            return "redirect:/userIndex.html";
        }else{
            model.addAttribute("msg","账号密码错误");
            return "login-1";
        }


    }

    @GetMapping("userIndex.html")
    public String toUserIndexPage(){
        return "pages/userIndex";
    }
    @GetMapping("userCarList")
    public String toUserCarList(){
        return "pages/userCarList";
    }
    @GetMapping("userOrderList")
    public String toUserHandlerOrderList(){
        return "pages/userOrderList";
    }
    @GetMapping("userOrderHistory")
    public String toUserHistory(){
        return "pages/userOrderHistory";
    }




}
