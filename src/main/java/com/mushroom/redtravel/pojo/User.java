package com.mushroom.redtravel.pojo;

/**
 * 用户实体类
 * @author Mushroom
 * @date 2020-02-07 15:48
 */
public class User {
    private int uid;
    private String username;
    private String password;
    private String uname;
    private int role;
    private String signature;
    private String sex;
    private String birthday;
    private String tal;
    private String address;
    private String email;
    private String imageName;
    private String imageBase;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTal() {
        return tal;
    }

    public void setTal(String tal) {
        this.tal = tal;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageBase() {
        return imageBase;
    }

    public void setImageBase(String imageBase) {
        this.imageBase = imageBase;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uname='" + uname + '\'' +
                ", role=" + role +
                ", signature='" + signature + '\'' +
                ", sex=" + sex +
                ", birthday='" + birthday + '\'' +
                ", tal='" + tal + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", imageName='" + imageName + '\'' +
                ", imageBase='" + imageBase + '\'' +
                '}';
    }
}
