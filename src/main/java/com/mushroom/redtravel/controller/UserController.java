package com.mushroom.redtravel.controller;

import com.mushroom.redtravel.pojo.Post;
import com.mushroom.redtravel.pojo.User;
import com.mushroom.redtravel.result.CodeMsg;
import com.mushroom.redtravel.result.Result;
import com.mushroom.redtravel.service.UserService;
import com.mushroom.redtravel.vo.CommentVo;
import com.mushroom.redtravel.vo.InteractiveVo;
import com.mushroom.redtravel.vo.UserVo;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.util.Password;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户相关
 * @author Mushroom
 * @date 2020-02-06 16:32
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录功能
     *
     * @param username
     * @param password
     * @param role
     * @return
     */
    @RequestMapping(value = "/user/login")
    @ResponseBody
    public Result<User> login(String username, String password, int role, HttpSession session) {
        //todo 改进：使用validation进行后端登录参数的合法性二次校验  https://blog.csdn.net/github_38592071/article/details/105985641
        User userSession = (User) session.getAttribute("user");
        if (userSession != null) {
            return Result.success(userSession);
        }
        User user = userService.userLogin(username, password, role);
        if (user == null) {
            return Result.error(new CodeMsg(0, "登录失败"));
        }
        session.setAttribute("user", user);
        return Result.success(user);
    }


    /**
     * 注册功能
     *
     * @param username
     * @param password
     * @param role
     * @param imageBase
     * @param imageName
     * @return
     */
    @RequestMapping(value = "/user/regiest")
    @ResponseBody
    public Result<String> regiest(String username, String password, int role, String imageBase, String imageName) {
//        if (role==0){//个人用户注册
//            return userService.userRegiest(username,password,role);
//        }
//            return userService.userRegiest(username, password, role, imageBase, imageName);
        return role == 0 ? userService.userRegiest(username, password, role) : userService.userRegiest(username, password, role, imageBase, imageName);
    }

    /**
     * 检查用户是否已登录
     * @param session
     * @return
     */
    @RequestMapping(value = "/user/checkUserstatus")
    @ResponseBody
    public Result<User> checkUserstatus(HttpSession session) {
        User userSession = (User) session.getAttribute("user");
//        if (userSession!=null){
//            return Result.success(userSession);
//        }
//        return Result.error(new CodeMsg(0,"用户未登录"));

        return userSession == null ? Result.error(new CodeMsg(0, "用户未登录")) : Result.success(userSession);
    }


    /**
     * 退出用户
     *
     * @param session
     */
    @RequestMapping(value = "/user/loginOut")
    @ResponseBody
    public void loginOut(HttpSession session) {
        session.removeAttribute("user");
    }


    /**
     * 修改用户资料
     * @param userVo
     * @return
     */
    @RequestMapping(value = "/user/updateUserMag")
    @ResponseBody
    public Result<String> updateUserMag(UserVo userVo,HttpSession session){
        //todo 改进：使用validation进行后端用户资料参数合法性的二次校验
        User user = (User)session.getAttribute("user");
        userVo.setId(user.getUid());
        Result<String> result = userService.updateUserMag(userVo);
        if (result.getCode()==1){//修改成功,更新session
            user.setUname(userVo.getName());
            user.setSignature(userVo.getSignature());
            user.setSex(userVo.getSex());
            user.setBirthday(userVo.getBirthday());
            user.setTal(userVo.getTal());
            user.setAddress(userVo.getAddress());
            user.setEmail(userVo.getEmail());
            session.setAttribute("user",user);
        }
        return result;
    }

    /**
     * 得到用户昵称
     *
     * @param id
     */
    @RequestMapping(value = "/user/getUserNameForId")
    @ResponseBody
    public Result<String> getUserNameForId(int id) {
        return userService.getUserNameForId(id);
    }

    /**
     * 用户收藏页
     *
     * @param session
     */
    @RequestMapping(value = "/user/getCollect")
    @ResponseBody
    public Result<List<Post>> getCollect(int index, HttpSession session) {
        User user =(User) session.getAttribute("user");
        if (user==null){
            return Result.error(new CodeMsg(0,"未登录"));
        }
        int uid = user.getUid();
        return userService.getCollect(index,uid);
    }

    /**
     * 用户动态页
     * @param session
     */
    @RequestMapping(value = "/user/getInteractive")
    @ResponseBody
    public Result<List<InteractiveVo>> getInteractive(int index, HttpSession session) {
        User user =(User) session.getAttribute("user");
        if (user==null){
            return Result.error(new CodeMsg(0,"未登录"));
        }
        int uid = user.getUid();
        return userService.getInteractive(index,uid);
    }


    /**
     * 用户评论页
     * @param session
     */
    @RequestMapping(value = "/user/getCommentForUser")
    @ResponseBody
    public Result<List<CommentVo>> getCommentForUser(int index, HttpSession session) {
        User user =(User) session.getAttribute("user");
        if (user==null){
            return Result.error(new CodeMsg(0,"未登录"));
        }
        int uid = user.getUid();
        return userService.getCommentForUser(index,uid);
    }

    /**
     * 添加浏览足迹
     * @param session
     */
    @RequestMapping(value = "/user/addPug")
    @ResponseBody
    public Result<String> addPug(int pid, HttpSession session) {
        User user =(User) session.getAttribute("user");
        if (user==null){
            return Result.error(new CodeMsg(0,"未登录"));
        }
        int uid = user.getUid();
        return userService.addPub(uid,pid);
    }
    /**
     * 展示浏览足迹
     * @param session
     */
    @RequestMapping(value = "/user/getPug")
    @ResponseBody
    public Result<List<Post>> getPub(int index, HttpSession session) {
        User user =(User) session.getAttribute("user");
        if (user==null){
            return Result.error(new CodeMsg(0,"未登录"));
        }
        int uid = user.getUid();
        return userService.getPub(uid,index);
    }

    /**
     * 修改密码
     * @param session
     */
    @RequestMapping(value = "/user/updatePassword")
    @ResponseBody
    public Result<String> updatePassword(String oldPassword, String  newPassword, HttpSession session) {
        //todo 改进：使用validation进行后端新旧密码参数合法性的二次校验
        User user =(User) session.getAttribute("user");
        if (user==null){
            return Result.error(new CodeMsg(0,"未登录"));
        }
        int uid = user.getUid();
        return userService.updatePassword(oldPassword, newPassword,uid);
    }
}
