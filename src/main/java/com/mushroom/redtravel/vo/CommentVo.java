package com.mushroom.redtravel.vo;

import com.mushroom.redtravel.pojo.Interactive;

/**
 * @author 用户评论页实体
 * @date 2020-03-06 21:00
 */
public class CommentVo {
    private Integer pid;
    private String title;
    private String text;
    private  String createTime;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "CommentVo{" +
                "pid=" + pid +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
