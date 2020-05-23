package com.mushroom.redtravel.mapper;

import com.mushroom.redtravel.pojo.People;
import com.mushroom.redtravel.result.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-02-07 20:15
 */
@Mapper
public interface PeopleMapper {

    @Select("select * from people where pid=#{id}")
    People getPeopleMsgById(int id);

    @Select("select * from people where pname like concat('%',#{name},'%')")
    List<People> searchPeopleByName(String name);
    @Select("select * from people where address like concat('%',#{city},'%') and pname like concat('%',#{name},'%')")
    List<People> searchPeopleByNameAndCity(@Param("city") String city, @Param("name") String name);
}
