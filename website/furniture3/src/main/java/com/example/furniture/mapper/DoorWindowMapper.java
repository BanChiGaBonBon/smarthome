package com.example.furniture.mapper;

import com.example.furniture.pojo.DoorWindow;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;

@Repository
public interface DoorWindowMapper extends Mapper<DoorWindow> {
    @Select("SELECT *FROM `door&window` WHERE `equipment_id` = #{id}")
    DoorWindow findById(Long id);

    @Insert("INSERT INTO `door&window` VALUES(#{id},#{time},#{type},#{ifopen},#{existed})")
    int insertDW(@Param("id") Long id,
                 @Param("time") Date time,
                 @Param("type") String type,
                 @Param("ifopen") Long ifopen,
                 @Param("existed") Long existed);

    @Delete("DELETE FROM  `door&window` WHERE `equipment_id` = #{id}")
    int deleteDW(@Param("id") Long id);

    @Update("UPDATE `door&window` SET `measure_time`=#{time},`equipment_type`= #{type},`Ifopen` = #{ifopen},`existed` = #{existed} WHERE `equipment_id`=#{id}")
    int updateDW(@Param("id") Long id,
                 @Param("time") Date time,
                 @Param("type") String type,
                 @Param("ifopen") Long ifopen,
                 @Param("existed") Long existed);
}
