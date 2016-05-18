package com.ray.java.basic.simple_socket;

/**
 * Created by dangdang on 5/18/16.
 */
public class Message {

    private String userMac;
    private String messageContent;
    private long date;

    public String getUserMac() {
        return userMac;
    }

    public void setUserMac(String userMac) {
        this.userMac = userMac;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
