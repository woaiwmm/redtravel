package com.mushroom.redtravel.pojo;

/**
 * 红色人物实体类
 * @author Mushroom
 * @date 2020-02-07 19:48
 */
public class People {
    private int pid;
    private String pname;
    private String birthday;
    private String address;
    private String position;
    private String experience;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "People{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                ", experience='" + experience + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
