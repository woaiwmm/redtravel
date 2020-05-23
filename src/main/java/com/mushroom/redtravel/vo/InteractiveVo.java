package com.mushroom.redtravel.vo;

/**
 * @author Administrator
 * @date 2020-03-06 19:41
 */
public class InteractiveVo {
    private Integer uid;
    private String name;
    private Integer pid;
    private Integer type;
    private String title;
    private String createTime;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        return "InteractiveVo{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
