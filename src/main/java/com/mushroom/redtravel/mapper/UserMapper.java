package com.mushroom.redtravel.mapper;

import com.mushroom.redtravel.pojo.Commentary;
import com.mushroom.redtravel.pojo.Interactive;
import com.mushroom.redtravel.pojo.User;
import com.mushroom.redtravel.vo.UserVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-02-07 15:43
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{username} and password=#{password} and role=#{role}")
     User userLogin(@Param("username") String username, @Param("password") String password, @Param("role") int role);

    @Select("select count(1) from user where username=#{username}")
    Integer getUserCountByUsername(String username);

    @Insert("insert into user(username,password,role) values(#{username},#{password},#{role})")
     Integer userRegiestOwn(@Param("username") String username, @Param("password") String password, @Param("role") int role);

    @Insert("insert into user(username,password,role,imageBase,imageName) values(#{username},#{password},#{role},#{imageBase},#{imageName})")
    Integer userRegiestOrg(@Param("username") String username, @Param("password") String password, @Param("role") int role,@Param("imageBase") String imageBase,@Param("imageName") String imageName);

    @Update("update user set uname=#{name},address=#{address},sex=#{sex},signature=#{signature},tal=#{tal},email=#{email},birthday=#{birthday} where uid=#{id}")
    Integer updateUserMag(UserVo userVo);
    @Select("select uname from user where uid=#{id}")
    String getUserNameForId(int id);

    @Select("select pid from collect where uid=#{uid} order by createTime desc limit #{index},5")
    List<Integer> getCollect(@Param("index") int index,@Param("uid") int uid);

    @Select("select * from interactive where toUid=#{uid} order by createTime desc limit #{index},5")
    List<Interactive> getInteractive(@Param("index") int index, @Param("uid") int uid);

    @Select("select * from commentary where uid=#{uid} order by createTime desc limit #{index},5")
    List<Commentary> getCommentForUser(@Param("index") int index, @Param("uid") int uid);

    @Update("update user set password=#{newPassword}  where password=#{oldPassword} and uid=#{uid}")
    Integer updatePassword(@Param("oldPassword") String oldPassword,@Param("newPassword") String  newPassword,@Param("uid") int uid);
}
