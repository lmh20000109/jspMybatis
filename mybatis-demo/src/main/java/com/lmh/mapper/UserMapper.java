package com.lmh.mapper;

import com.lmh.pojo.User;

import java.util.List;

public interface UserMapper {


    List<User> selectAll();

    User selectById(int id);


}
