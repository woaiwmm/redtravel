package com.mushroom.redtravel.pojo;

/**
 * 帖子实体类
 * @author Mushroom
 * @date 2020-03-01 19:31
 */
public class Post {
    private Integer pid;
    private Integer uid;
    private String title;
    private String type;
    private String mainText;
    private String createTime;
    private Integer goodNumbers;
    private Integer commentsNumbers;
    private String introduction;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getGoodNumbers() {
        return goodNumbers;
    }

    public void setGoodNumbers(Integer goodNumbers) {
        this.goodNumbers = goodNumbers;
    }

    public Integer getCommentsNumbers() {
        return commentsNumbers;
    }

    public void setCommentsNumbers(Integer commentsNumbers) {
        this.commentsNumbers = commentsNumbers;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Post{" +
                "pid=" + pid +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", mainText='" + mainText + '\'' +
                ", createTime='" + createTime + '\'' +
                ", goodNumbers=" + goodNumbers +
                ", commentsNumbers=" + commentsNumbers +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}