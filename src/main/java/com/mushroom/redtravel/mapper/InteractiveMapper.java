package com.mushroom.redtravel.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Administrator
 * @date 2020-03-06 15:21
 */
@Mapper
public interface InteractiveMapper {

    @Select("select count(iId) from interactive where fromUid=#{uid} and pid=#{pid}")
    Integer checkGoodStatus(@Param("uid")int uid,@Param("pid") int pid);


    @Insert("insert into interactive(fromUid,toUid,pid,type,createTime) values(#{fromUid},#{toUid},#{pid},#{type},now())")
    Integer insertInteractive(@Param("fromUid") Integer fromUid, @Param("toUid") Integer toUid, @Param("pid") Integer pid,@Param("type")Integer type);

}
