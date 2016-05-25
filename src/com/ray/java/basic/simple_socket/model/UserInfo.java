package com.ray.java.basic.simple_socket.model;

/**
 * Created by dangdang on 5/18/16.
 */
public class UserInfo {

    private String userMac;
    private String name;
    private String photo;

    public UserInfo(String userMac, String name, String photo) {
        this.userMac = userMac;
        this.name = name;
        this.photo = photo;
    }

    public String getUserMac() {
        return userMac;
    }

    public void setUserMac(String userMac) {
        this.userMac = userMac;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object obj) {
        UserInfo userInfo = (UserInfo) obj;

        return this.getUserMac().equals(userInfo.getUserMac());
    }

//    @Override
//    public int hashCode() {
//        return userMac.hashCode();
//    }
}
