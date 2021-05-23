package edu.jluzh.test_layuimini.controller;

import com.github.pagehelper.PageInfo;
import edu.jluzh.test_layuimini.bean.User;
import edu.jluzh.test_layuimini.pojo.UserResult;
import edu.jluzh.test_layuimini.pojo.UserTable;
import edu.jluzh.test_layuimini.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @description: 管理员端用户前后端交互处理控制器
 * @author: icecool
 * @date: Created in 2021/5/20 21:55
 * @version:
 * @modified By:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    /**
     * 功能描述: 获取用户列表
     * 〈〉
     * @Param: [page, limit, userName]
     * @Return: edu.jluzh.test_layuimini.pojo.UserTable
     * @Author: icecool
     * @Date: 2021/5/22 15:21
     */

    //layui表单初始请求是get方法
    @RequestMapping("/getUserlist")
    public @ResponseBody UserTable getUserList(int page, int limit,String userName){
        UserTable userTable = new UserTable();
        //layui的表格重载方法和员表格请求一个url，则判断是否有username参数为区分两种的业务逻辑
        //为空 返回完整用户列表
        if(userName== null){
            PageInfo<User> allUser = userService.findAllUser(page, limit);
            userTable.setCode(0);
            userTable.setMsg("成功");
            userTable.setCount(allUser.getTotal());
            userTable.setData(allUser.getList());
            //System.out.println(allUser.getList());
        }else {
            //不为空 返回查询结果
            PageInfo<User> selectUser = userService.searchUser(page,limit,userName);
            System.out.println(userName);
            userTable.setCode(0);
            userTable.setMsg("成功");
            userTable.setCount(selectUser.getTotal());
            userTable.setData(selectUser.getList());
        }
        return userTable;

    }


    /**
     * 功能描述: 删除用户信息方法
     * 〈〉
     * @Param: [params] 注意加数组符号
     * @Return: edu.jluzh.test_layuimini.pojo.UserResult
     * @Author: icecool
     * @Date: 2021/5/22 15:22
     */

    @PostMapping("/delete")
    public  @ResponseBody UserResult deleteUser(@RequestParam(value = "params[]") int[] params){
        for (int id : params) {
            userService.deleteUser(id);
        }
        UserResult result = new UserResult();

        result.setStatus("1");
        result.setMessage("ok");
        return result;
    }

    /**
     * 功能描述: 编辑用户信息方法
     * 〈〉
     * @Param: [user, session]
     * @Return: edu.jluzh.test_layuimini.pojo.UserResult
     * @Author: icecool
     * @Date: 2021/5/22 15:22
     */
    @PostMapping("/editUser")
    public UserResult updateUser(User user, HttpSession session){
        System.out.println(user);
        //获取用户id值
        Integer id =(Integer)session.getAttribute("userId");
        user.setUserId(id);
        userService.updateUser(user);
        UserResult result = new UserResult();
        result.setStatus("ok");
        result.setMessage("正常");
        return result;
    }


}
