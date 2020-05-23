package com.mushroom.redtravel.pojo;

/**
 * 评论实体表
 * @author Mushroom
 * @date 2020-03-01 19:34
 */
public class Commentary {
    private Integer cid;
    private Integer pid;
    private Integer uid;
    private String title;
    private String createTime;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Commentary{" +
                "cid=" + cid +
                ", pid=" + pid +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
