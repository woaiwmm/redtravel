package com.mushroom.redtravel.mapper;

import com.mushroom.redtravel.pojo.Scenic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-02-07 21:09
 */
@Mapper
public interface ScenicMapper {

    @Select("select * from scenic where sid=#{id}")
    Scenic getScenicMsgById(int id);

    @Select("select * from scenic where sname like concat('%',#{name},'%')")
    List<Scenic> searchScenicByName(String name);
    @Select("select * from scenic where province like concat('%',#{city},'%') and sname like concat('%',#{name},'%')")
    List<Scenic> searchScenicByNameAndCity(@Param("city") String city, @Param("name") String name);
}
