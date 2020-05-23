package com.mushroom.redtravel.pojo;

/**
 * @author 帖子收藏的实体类
 * @date 2020-03-05 22:50
 */
public class Collect {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private String createTime;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
