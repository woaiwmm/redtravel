package com.mushroom.redtravel.service;

import com.mushroom.redtravel.pojo.Post;
import com.mushroom.redtravel.pojo.User;
import com.mushroom.redtravel.result.Result;
import com.mushroom.redtravel.vo.CommentVo;
import com.mushroom.redtravel.vo.InteractiveVo;
import com.mushroom.redtravel.vo.UserVo;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-02-07 16:04
 */
public interface UserService {
    User userLogin(String username, String password, int role);
     Result<String> userRegiest(String username, String password, int role, String imageBase, String imageName);
     Result<String> userRegiest(String username, String password, int role);
    Result<String> updateUserMag(UserVo userVo);
    Result<String> getUserNameForId(int id);
    Result<List<Post>> getCollect(int index,int uid);
    Result<List<InteractiveVo>> getInteractive(int index, int uid);
    Result<List<CommentVo>> getCommentForUser(int index, int uid);
    Result<String> addPub(int uid,int pid);
    Result<List<Post>> getPub(int uid,int index);
    Result<String> updatePassword(String oldPassword, String  newPassword,int uid);
}
