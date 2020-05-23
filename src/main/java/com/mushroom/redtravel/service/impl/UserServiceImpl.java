package com.mushroom.redtravel.service.impl;

import com.mushroom.redtravel.mapper.PostMapper;
import com.mushroom.redtravel.mapper.UserMapper;
import com.mushroom.redtravel.pojo.Commentary;
import com.mushroom.redtravel.pojo.Interactive;
import com.mushroom.redtravel.pojo.Post;
import com.mushroom.redtravel.pojo.User;
import com.mushroom.redtravel.result.CodeMsg;
import com.mushroom.redtravel.result.Result;
import com.mushroom.redtravel.service.UserService;
import com.mushroom.redtravel.util.JedisUtil;
import com.mushroom.redtravel.vo.CommentVo;
import com.mushroom.redtravel.vo.InteractiveVo;
import com.mushroom.redtravel.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2020-02-07 16:04
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PostMapper postMapper;

    //用户或组织登录
    public User userLogin(String username, String password, int role) {
        return userMapper.userLogin(username, password, role);

    }

    //用户注册
    public Result<String> userRegiest(String username, String password, int role) {
        Integer userCount = userMapper.getUserCountByUsername(username);
        if (userCount>0){//用户已存在
            return Result.error(new CodeMsg(0, "注册失败"));
        }
        int resultCount = userMapper.userRegiestOwn(username, password, role);
        if (resultCount<=0){
            return Result.error(new CodeMsg(0, "注册失败"));
        }
        return Result.success("注册成功");
    }

    //    组织注册
    public Result<String> userRegiest(String username, String password, int role, String imageBase, String imageName) {
        Integer userCount = userMapper.getUserCountByUsername(username);
        if (userCount>0){
            return Result.error(new CodeMsg(0, "注册失败"));
        }
        int resultCount = userMapper.userRegiestOrg(username, password, role,imageBase,imageName);
        if (resultCount<=0){
            return Result.error(new CodeMsg(0, "注册失败"));
        }
        return Result.success("注册成功");
    }
//修改用户信息
    public Result<String> updateUserMag(UserVo userVo){
        Integer resultCount = userMapper.updateUserMag(userVo);
        if (resultCount<=0)
            return Result.error(new CodeMsg(0,"修改失败"));
        return Result.success("修改成功");
    }


    public Result<String> getUserNameForId(int id){
        String userName = userMapper.getUserNameForId(id);
        if (userName==null||userName=="")
            return Result.error(new CodeMsg(0,"获取失败"));
        return Result.success(userName);
    }

    public Result<List<Post>> getCollect(int index,int uid){
        List<Integer> postIdList = userMapper.getCollect(index,uid);
        if(postIdList.size()<=0)
            return Result.error(new CodeMsg(0,"该用户没有收藏任何帖子！"));
        List<Post> postList=new ArrayList<>();
        for(int postId:postIdList ){
            postList.add(  postMapper.getPostForId(postId));

        }
        return Result.success(postList);
    }

    public Result<List<InteractiveVo>> getInteractive(int index, int uid){
        List<Interactive> interactiveList = userMapper.getInteractive(index, uid);
        if(interactiveList.size()<=0)
            return Result.error(new CodeMsg(0,"该用户没有任何动态！"));
        List<InteractiveVo> interactiveVoList=new ArrayList<>();
        for (Interactive i:interactiveList){
            InteractiveVo interactiveVo=new InteractiveVo();
            interactiveVo.setCreateTime(i.getCreateTime());
            interactiveVo.setPid(i.getPid());
            interactiveVo.setType(i.getType());
            interactiveVo.setUid(i.getFromUid());
            interactiveVo.setName(userMapper.getUserNameForId(i.getFromUid()));
            interactiveVo.setTitle(postMapper.getPostForId(i.getPid()).getTitle());
            interactiveVoList.add(interactiveVo);
        }
        return Result.success(interactiveVoList);

    }


    public Result<List<CommentVo>> getCommentForUser(int index, int uid){
        List<Commentary> commentaryList = userMapper.getCommentForUser(index, uid);
        if(commentaryList.size()<=0)
            return Result.error(new CodeMsg(0,"该用户没有任何评论！"));
        List<CommentVo> commentVoList=new ArrayList<>();
        for (Commentary c:commentaryList){
            CommentVo commentVo=new CommentVo();
           commentVo.setCreateTime(c.getCreateTime());
           commentVo.setPid(c.getPid());
           commentVo.setText(c.getTitle());
           commentVo.setTitle(postMapper.getPostForId(c.getPid()).getTitle());
            commentVoList.add(commentVo);
        }
        return Result.success(commentVoList);

    }

    public Result<String> addPub(int uid,int pid){
        String key=uid+"";
        String value=pid+"";
        try {
            Jedis jedis = JedisUtil.getConnect();
            //todo 1.使用lrem删除uid（key）中旧的pid（value）
            jedis.lrem(key,0,value);
            //todo 2.使用lpush往uid（key）中放入最新的pid（value）
            jedis.lpush(key,value);
            //todo 3.使用lTrim将uid（key）里100条后的数据清空
            jedis.ltrim(key,0,99);
            //todo 4.使用expire设置uid（key）的存活时间
            jedis.expire(key,60*60*24*30);
            JedisUtil.closeConnect();
        } catch (Exception e) {
            System.out.println( e);
            return Result.error(new CodeMsg(0,"添加失败"));
        }
        //todo 5.返回成功与否
        return Result.success("添加成功");
    }

    public Result<List<Post>> getPub(int uid,int index){
        List<Post> postList= null;
        List<String> result = null;
        try {
            String key=uid+"";
            postList = new ArrayList<>();
            Jedis jedis = JedisUtil.getConnect();
            //todo 1.使用lrange uid index index+4;获得从index开始的5条数据
            result = jedis.lrange(key, index, index + 4);
            JedisUtil.closeConnect();
        } catch (Exception e) {
            System.out.println( e);
            return Result.error(new CodeMsg(0,"您还没有任何浏览足迹"));
        }
        //todo 2.拼装返回
        for(String s:result)
            postList.add(postMapper.getPostForId(Integer.parseInt(s)));
        if(postList.size()<=0)
            return Result.error(new CodeMsg(0,"您还没有任何浏览足迹"));
        return Result.success(postList);
    }

   public Result<String> updatePassword(String oldPassword, String newPassword,int uid){
       Integer resultCount = userMapper.updatePassword(oldPassword,newPassword,uid);
       if (resultCount<=0)
           return Result.error(new CodeMsg(0,"修改失败"));
       return Result.success("修改成功");
   }

}
