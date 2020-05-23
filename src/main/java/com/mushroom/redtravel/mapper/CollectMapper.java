package com.mushroom.redtravel.mapper;

import org.apache.ibatis.annotations.*;

/**
 * @author Administrator
 * @date 2020-03-05 22:54
 */
@Mapper
public interface CollectMapper {

    @Select("select count(*) from collect where uid=#{uid} and pid=#{pid}")
    int isCollectPost(@Param("uid") int uid,@Param("pid")  int pid);


    @Insert("insert into collect(uid,pid,createTime) values(#{uid},#{pid},now())")
    Integer addCollect(@Param("uid") int uid,@Param("pid")  int pid);

    @Delete("delete  from collect  where uid=#{uid} and pid=#{pid}")
    Integer deleteCollect(@Param("uid") int uid,@Param("pid")  int pid);
}
