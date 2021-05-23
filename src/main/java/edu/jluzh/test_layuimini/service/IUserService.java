package edu.jluzh.test_layuimini.service;

import com.github.pagehelper.PageInfo;
import edu.jluzh.test_layuimini.bean.User;

/**
 * @description: service层接口类
 * @author: icecool
 * @date: Created in 2021/5/20 20:47
 * @version:
 * @modified By:
 */

public interface IUserService {
     //查找所有用户
     PageInfo<User> findAllUser(int page,int limit);
     //删除用户
     public void deleteUser(int id);
     //更新用户
     public void updateUser(User user);
     //条件查找用户
     PageInfo<User> searchUser(int page, int limit,String userName);

     int findUserTotal();
}
