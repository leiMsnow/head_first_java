package com.ray.java.basic.simple_socket;

/**
 * Created by dangdang on 5/18/16.
 */
public class ConnectionUser {

    private String userMac;

    public ConnectionUser(String userMac) {
        this.userMac = userMac;
    }

    public String getUserMac() {
        return userMac;
    }

    public void setUserMac(String userMac) {
        this.userMac = userMac;
    }
}
