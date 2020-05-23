package com.mushroom.redtravel.service.impl;

import com.mushroom.redtravel.mapper.InteractiveMapper;
import com.mushroom.redtravel.mapper.PostMapper;
import com.mushroom.redtravel.pojo.Commentary;
import com.mushroom.redtravel.pojo.Interactive;
import com.mushroom.redtravel.pojo.Post;
import com.mushroom.redtravel.result.CodeMsg;
import com.mushroom.redtravel.result.Result;
import com.mushroom.redtravel.service.PostService;
import com.mushroom.redtravel.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Administrator
 * @date 2020-03-01 19:41
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private InteractiveMapper interactiveMapper;


    public Result<Integer> getPostCount() {
        int postCount = postMapper.getPostCount();
        if (postCount <= 0)
            return Result.error(new CodeMsg(0, "没有结果"));
        return Result.success(postCount);
    }

    public Result<List<Post>> getPost(int index, int end) {
        List<Post> postList = postMapper.getPost(index, end);
        if (postList == null || postList.size() == 0)
            return Result.error(new CodeMsg(0, "没有结果"));
        return Result.success(postList);
    }

    public Result<List<Post>> getPath(String type) {
        List<Post> path = postMapper.getPath(type);
        if (path == null || path.size() == 0) {
            return Result.error(new CodeMsg(0, "没有结果"));
        }
        return Result.success(path);
    }

    public Result<Integer> sendPost(PostVo postVo) {
        Integer countResult = postMapper.sendPost(postVo.getUserId(), postVo.getType(), postVo.getTitle(), postVo.getMainText(), postVo.getIntroduction());
        if (countResult < 1) {
            return Result.error(new CodeMsg(0, "失败"));
        }
        return getPostCount();
    }

    public Result<Post> getPostForId(int id) {
        Post post = postMapper.getPostForId(id);
        if (post == null)
            return Result.error(new CodeMsg(0, "查询失败"));
        return Result.success(post);
    }

    public Result<List<Commentary>> getCommentary(int id) {
        List<Commentary> commentary = postMapper.getCommentary(id);
        if (commentary == null || commentary.size() == 0)
            return Result.error(new CodeMsg(0, "查询失败"));
        return Result.success(commentary);
    }

    public Result<String> sendCommentary(Commentary commentary) {
        Integer uid = commentary.getUid();
        Integer pid = commentary.getPid();
        String title = commentary.getTitle();
        if (uid == null || pid == null || StringUtils.isEmpty(title))
            return Result.error(new CodeMsg(0, "评论失败"));
        Integer resultCount = postMapper.sendCommentary(uid, pid, title);
        if (resultCount <= 0)
            return Result.error(new CodeMsg(0, "评论失败"));
        addCommForPost(pid);//对应帖子的评论数+1
        insertInteractive(uid,pid,1);//插入动态表
        return Result.success("评论成功");
    }

    //发帖成功后，将对应帖子的评论数+1
    public void addCommForPost(int pid) {
        try {
            postMapper.addCommForPost(pid);
        } catch (Exception e) {
            //todo 此处应该将失败信息打入日志
            System.out.println("----对应帖子的评论数+1----出错"+e.getMessage());
        }
    }

    //发帖成功后，把评论信息插入动态表
    public void insertInteractive(Integer fromUid,Integer pid,Integer type) {
        try {
            Post post = postMapper.getPostForId(pid);
            int toUid=post.getUid();
            //根据pid得到用户的id
            interactiveMapper.insertInteractive(fromUid, toUid, pid, type);
        } catch (Exception e) {
            //todo 此处应该将失败信息打入日志
            System.out.println("----评论信息插入动态表----出错"+e.getMessage());
        }
    }

    public Result<String> checkGoodStatus(int uid,int pid) {
        Integer resultCount = interactiveMapper.checkGoodStatus(uid, pid);
        if(resultCount<=0)
            return Result.error(new CodeMsg(0,"未点赞"));
        return Result.success("已点赞");
    }

    public Result<String> wantGood(int uid,int pid) {
        //后端再次校验是否已经点过赞，防止用户直接通过请求重复点赞
        Result<String> result = checkGoodStatus(uid, pid);
        if(result.getCode()==1){
            return Result.error(new CodeMsg(0,"操作失败"));
        }
        //点赞
        Post post = postMapper.getPostForId(pid);
        Integer toUid = post.getUid();
        Integer resultCount = interactiveMapper.insertInteractive(uid, toUid, pid, 0);
        if (resultCount<=0)
            return Result.error(new CodeMsg(0,"操作失败"));
        addGoodForPost(pid);//对应帖子的点赞数+1
        return Result.success("操作成功");
    }


    //点赞成功后，将对应帖子的点赞数+1
    public void addGoodForPost(int pid) {
        try {
            postMapper.addGoodForPost(pid);
        } catch (Exception e) {
            //todo 此处应该将失败信息打入日志
            System.out.println("----对应帖子的点赞数+1----出错"+e.getMessage());
        }
    }

    public Result<List<Post>> serchPost(String markWord){
        List<Post> postList = postMapper.serchPost("%"+markWord+"%");
        if (postList.size()<=0)
            return Result.error(new CodeMsg(0,"没有结果"));
        return Result.success(postList);
    }

}
