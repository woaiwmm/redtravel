package com.mushroom.redtravel.controller;

import com.mushroom.redtravel.pojo.Commentary;
import com.mushroom.redtravel.pojo.Interactive;
import com.mushroom.redtravel.pojo.Post;
import com.mushroom.redtravel.result.Result;
import com.mushroom.redtravel.service.CollectService;
import com.mushroom.redtravel.service.PostService;
import com.mushroom.redtravel.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-03-01 19:37
 */
@Controller
public class PostController {
@Autowired
private PostService postService;
@Autowired
private CollectService collectService;


    /**
     * 得到帖子的总数
     * @return
     */
    @RequestMapping(value="/post/getPostCount")
    @ResponseBody
    public Result<Integer> getPostCount(){
        return postService.getPostCount();
    }

    /**
     * 得到指定页数的帖子
     * @return
     */
    @RequestMapping(value="/post/getPost")
    @ResponseBody
    public Result<List<Post>> getPost(int index, int end){
        return postService.getPost(index,end);
    }

    /**
     * 得到热门或经典路线
     * @return
     */
    @RequestMapping(value="/post/getPath")
    @ResponseBody
    public Result<List<Post>> getPath(String type){
        return postService.getPath(type);
    }

    /**
     * 发表帖子,并返回新增帖子的id
     * @return
     */
    @RequestMapping(value="/post/sendPost")
    @ResponseBody
    public Result<Integer> sendPost(PostVo postVo){
        return postService.sendPost(postVo);
    }


    /**
     * 得到指定帖子的评论信息集合
     * @return
     */
    @RequestMapping(value="/post/getCommentary")
    @ResponseBody
    public Result<List<Commentary>> getCommentary(int id){
        return postService.getCommentary(id);
    }

    /**
     * 得到指定id的帖子
     * @return
     */
    @RequestMapping(value="/post/getPostForId")
    @ResponseBody
    public Result<Post> getPostForId(int id){
        return postService.getPostForId(id);
    }

    /**
     * 用户评论
     * @return
     */
    @RequestMapping(value="/post/sendCommentary")
    @ResponseBody
    public Result<String> sendCommentary(Commentary commentary){
        return postService.sendCommentary(commentary);
    }


    /**
     * 检查用户是否收藏该帖子
     * @return
     */
    @RequestMapping(value="/post/isCollectPost")
    @ResponseBody
    public Result<String> isCollectPost(int uid,int pid){
        return collectService.isCollectPost(uid,pid);
    }

    /**
     * 修改用户对该帖子的收藏状态
     * @return
     */
    @RequestMapping(value="/post/updateCollectStatus")
    @ResponseBody
    public Result<String> updateCollectStatus(int uid,int pid,int flag){
        return collectService.updateCollectStatus(uid, pid, flag);
    }

    /**
     * 检查用户是否点赞该帖子
     * @return
     */
    @RequestMapping(value="/post/checkGoodStatus")
    @ResponseBody
    public Result<String> checkGoodStatus(int uid,int pid){
        return postService.checkGoodStatus(uid, pid);
    }

    /**
     * 用户点赞该帖子
     * @return
     */
    @RequestMapping(value="/post/wantGood")
    @ResponseBody
    public Result<String> wantGood(int uid,int pid){
        return postService.wantGood(uid,pid);
    }

    /**
     * 用户搜索帖子
     * @return
     */
    @RequestMapping(value="/post/serchPost")
    @ResponseBody
    public Result<List<Post>> serchPost(String markWord){
        return postService.serchPost(markWord);
    }



}
