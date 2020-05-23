package com.mushroom.redtravel.vo;

/**
 * @author Administrator
 * @date 2020-03-02 18:13
 */
public class PostVo {
    private int userId;
    private String type;
    private String title;
    private String mainText;
    private String introduction;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "PostVo{" +
                "userId=" + userId +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", mainText='" + mainText + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
