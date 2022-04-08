package com.example.furniture.mapper;

import com.example.furniture.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {
    @Select("SELECT *FROM `user` WHERE `user_name` = #{userName}")
    User findUserByUserName(String userName);
    @Select("SELECT *FROM `user` WHERE `user_id` = #{userId}")
    User findUserById(long userId);
}
