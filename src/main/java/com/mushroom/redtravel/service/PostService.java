package com.mushroom.redtravel.service;

import com.mushroom.redtravel.pojo.Commentary;
import com.mushroom.redtravel.pojo.Interactive;
import com.mushroom.redtravel.pojo.Post;
import com.mushroom.redtravel.result.Result;
import com.mushroom.redtravel.vo.PostVo;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-03-01 19:41
 */
public interface PostService {
    Result<Integer> getPostCount();
    Result<List<Post>> getPost(int index, int end);
    Result<List<Post>> getPath(String type);
     Result<Integer> sendPost(PostVo postVo);
    Result<Post> getPostForId(int id);
    Result<List<Commentary>> getCommentary(int id);
    Result<String> sendCommentary(Commentary commentary);
    Result<String> checkGoodStatus(int uid,int pid);
    Result<String> wantGood(int uid,int pid);
    Result<List<Post>> serchPost(String markWord);
}
