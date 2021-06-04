package edu.jluzh.test_layuimini.controller;

import edu.jluzh.test_layuimini.service.ICarImgService;
import edu.jluzh.test_layuimini.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    IUserService service;

    //跳转userlist界面
    @GetMapping("/userlist")
    public String userList(){
        return "pages/userlist";
    }

    
    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [id, session]
     * @Return: java.lang.String
     * @Author: icecool
     * @Date: 2021/5/27 18:10
     */
    
    //跳转用户编辑界面 并将用户id存入session
    @GetMapping("/userEdit")
    public String userEdit(Integer id, HttpSession session){
        session.setAttribute("userId",id);
        session.setAttribute("User",service.findUserByid(id));
        System.out.println(id);
        return "pages/edit";
    }


    @GetMapping("enter")
    public String toEnter(){
        return "enter";
    }



}
