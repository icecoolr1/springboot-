package edu.jluzh.test_layuimini.mapper;

import edu.jluzh.test_layuimini.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @description: 用户管理模块 mapper
 * @author: icecool
 * @date: Created in 2021/5/20 20:26
 * @version:
 * @modified By:
 */
//mybatis 持久层注解为@mapper
@Mapper
public interface IUserMapper {
    //查询所有用户
    public List<User> findAllUser();
    //通过id删除用户
    public void deleteUserById(int userId);
    //更新用户信息
    public void updateUser(User user);
    //通过用户名查询用户信息
    public List<User> searchUserByInfo(String username);
    int findUserTotal();
    //按id查询用户
    User findUserByid(int id);
    public void addUser(User user);
    public User validateUser(@Param("username") String username,@Param("password") String password);
    void userBorrow(int userId);
    void userBack(int userId);
}
