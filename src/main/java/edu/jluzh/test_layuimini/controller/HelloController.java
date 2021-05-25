package edu.jluzh.test_layuimini.controller;

import edu.jluzh.test_layuimini.mapper.ICarMapper;
import edu.jluzh.test_layuimini.service.ICarService;
import edu.jluzh.test_layuimini.service.IOrderService;
import edu.jluzh.test_layuimini.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @description: 管理员端登录界面控制器
 * @author: icecool
 * @date: Created in 2021/5/20 9:06
 * @version:
 * @modified By:
 */
@Controller
public class HelloController {
    @Autowired
    IUserService userService;
    @Autowired
    ICarService carService;
    @Autowired
    IOrderService orderService;
    //设置访问主页url的地址参数
    @GetMapping(value = {"/","login"})
    public String login(){
        return "login-3";
    }

    //接收admin登录数据
    @PostMapping("/userLogin")
    public String userLogin(String username, String password, HttpSession session, Model model){
        if(!username.isBlank()&&password.equals("123456")){
            session.setAttribute("user",username);
            return "redirect:/index.html";
        }else {
            model.addAttribute("msg","账号密码错误，请重新输入!");
            return  "login-3";
        }

    }

    //直接跳转到主页并过滤未登录请求
    @GetMapping("/index.html")
    public String toIndex(HttpSession session,Model model){
        Object user = session.getAttribute("user");
        if(user != null){
            return "index";
        }else {
            model.addAttribute("msg","请登录!");
            return  "login-3";
        }

    }
    //跳转到欢迎页
    @GetMapping(value = "/welcome")
    public String toWelcome(HttpSession session){
        session.setAttribute("userNum",userService.findUserTotal());
        session.setAttribute("carNum",carService.findCarTotal());
        session.setAttribute("orderNum",orderService.findOrderTotal());
        session.setAttribute("data",orderService.findOrderByMonths());

        return "pages/welcome-1";
    }

    //按月查询数据
    @GetMapping(value = "/getdata")
    @ResponseBody
    public int[] getData(){
        int [] data = orderService.findOrderByMonths();
        return data;
    }
}
