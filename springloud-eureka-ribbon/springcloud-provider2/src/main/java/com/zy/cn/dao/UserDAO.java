package com.zy.cn.dao;

import com.zy.cn.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDAO extends BaseDAO<User> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //按照名字模糊查询并支持分页查询
    List<User> query(Map map);

    List<User> fuzzy(User user);


}