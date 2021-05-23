package edu.jluzh.test_layuimini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @description: 用户管理模块界面控制器
 * @author: icecool
 * @date: Created in 2021/5/21 10:48
 * @version:
 * @modified By:
 */
@Controller
public class UserPageController {

    //跳转userlist界面
    @GetMapping("/userlist")
    public String userList(){
        return "pages/userlist";
    }

    //跳转用户编辑界面 并将用户id存入session
    @GetMapping("/userEdit")
    public String userEdit( Integer id, HttpSession session){
        session.setAttribute("userId",id);
        System.out.println(id);
        return "pages/edit";
    }
}
