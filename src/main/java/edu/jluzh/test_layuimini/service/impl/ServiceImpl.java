package edu.jluzh.test_layuimini.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.jluzh.test_layuimini.bean.User;
import edu.jluzh.test_layuimini.mapper.IUserMapper;
import edu.jluzh.test_layuimini.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: service层实现方法
 * @author: icecool
 * @date: Created in 2021/5/20 20:48
 * @version:
 * @modified By:
 */
@Service
public class ServiceImpl implements IUserService {
    @Autowired
    IUserMapper userMapper;

    @Override
    public PageInfo<User> findAllUser(int page, int limit) {
        //开始分页
        PageHelper.startPage(page,limit);
        //获取用户列表
        List<User> userList = userMapper.findAllUser();
        //通过pafeInfo封装userlist
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        return pageInfo;
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public PageInfo<User> searchUser(int page, int limit,String userName) {
        //开始分页
        PageHelper.startPage(page,limit);
        //接受userlist
        List<User> userList =  userMapper.searchUserByInfo(userName);
        //将uerList转为pageInfo
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        return pageInfo;
    }

    @Override
    public int findUserTotal() {
       return userMapper.findUserTotal();
    }

    @Override
    public User findUserByid(int id) {
        return userMapper.findUserByid(id);
    }
}
