package com.example.furniture.mapper;

import com.example.furniture.pojo.Administrator;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface AdministratorMapper  extends Mapper<Administrator> {

    @Select("SELECT *FROM `administrator` WHERE `administrator_name` = #{administratorName}")
    Administrator findUserByUserName(String administratorName);

    @Select("SELECT *FROM `administrator` WHERE `administrator_id` = #{administratorId}")
    Administrator findUserById(long administratorId);
}
