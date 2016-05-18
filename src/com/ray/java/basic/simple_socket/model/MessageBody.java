package com.ray.java.basic.simple_socket.model;

/**
 * Created by dangdang on 5/18/16.
 */
public class MessageBody {

    public static final int USER_INFO = 0;
    public static final int MESSAGE_INFO = 1;

    private int bodyType;
    private MessageInfo message;

    public int getBodyType() {
        return bodyType;
    }

    public void setBodyType(int bodyType) {
        this.bodyType = bodyType;
    }

    public MessageInfo getMessage() {
        return message;
    }

    public void setMessage(MessageInfo message) {
        this.message = message;
    }

}
