package com.mushroom.redtravel.pojo;

/**
 * @author 互动表的实体类
 * @date 2020-03-05 22:52
 */
public class Interactive {
    private Integer iId;
    private Integer fromUid;
    private Integer toUid;
    private Integer pid;
    private Integer type;
    private String createTime;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public Integer getFromUid() {
        return fromUid;
    }

    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    public Integer getToUid() {
        return toUid;
    }

    public void setToUid(Integer toUid) {
        this.toUid = toUid;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "InteractiveMapper{" +
                "iId=" + iId +
                ", fromUid=" + fromUid +
                ", toUid=" + toUid +
                ", pid=" + pid +
                ", type=" + type +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
