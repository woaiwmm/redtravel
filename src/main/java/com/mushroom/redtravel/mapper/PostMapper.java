package com.mushroom.redtravel.mapper;

import com.mushroom.redtravel.pojo.Commentary;
import com.mushroom.redtravel.pojo.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-03-01 19:38
 */
@Mapper
public interface PostMapper {

    @Select("select count(pid) from post ")
    int getPostCount();

    @Select("select * from post where pid>=#{index} and pid<=#{end}")
    List<Post> getPost(@Param("index")int index, @Param("end")int end);

    @Select("select * from post where type=#{type} order by goodNumbers DESC  limit 5")
    List<Post> getPath(String type);


    @Insert("insert into post(uid,title,mainText,createTime,type,introduction) values(#{userId},#{title},#{mainText},now(),#{type},#{introduction})")
    Integer sendPost(@Param("userId") int userId, @Param("type") String type, @Param("title") String title,@Param("mainText") String mainText,@Param("introduction") String introduction);


    @Select("select * from post where pid=#{id} ")
    Post getPostForId(int id);

    @Select("select * from commentary where pid=#{id} ")
    List<Commentary> getCommentary(int id);

    @Insert("insert into commentary(pid,uid,title,createTime) values(#{pid},#{uid},#{title},now())")
    Integer sendCommentary(@Param("uid") int uid, @Param("pid") int pid, @Param("title") String title);

    @Update("update post set commentsNumbers=commentsNumbers+1 where pid=#{pid}")
    Integer addCommForPost(int pid);

    @Update("update post set goodNumbers=goodNumbers+1 where pid=#{pid}")
    Integer addGoodForPost(int pid);

    @Select("select * from post where title like #{markWord}")
    List<Post> serchPost(String markWord);
}
