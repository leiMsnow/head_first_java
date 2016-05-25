package com.ray.java.basic.simple_socket.model;

/**
 * Created by dangdang on 5/18/16.
 */
public class MessageInfo {

    private UserInfo sendUserMac;
    private UserInfo receiveUserMac;
    private String messageContent;
    private long date;

    public MessageInfo() {
    }

    public UserInfo getSendUserMac() {
        return sendUserMac;
    }

    public void setSendUserMac(UserInfo sendUserMac) {
        this.sendUserMac = sendUserMac;
    }

    public UserInfo getReceiveUserMac() {
        return receiveUserMac;
    }

    public void setReceiveUserMac(UserInfo receiveUserMac) {
        this.receiveUserMac = receiveUserMac;
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
