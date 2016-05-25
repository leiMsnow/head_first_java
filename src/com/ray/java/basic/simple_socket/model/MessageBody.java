package com.ray.java.basic.simple_socket.model;

/**
 * Created by dangdang on 5/18/16.
 */
public class MessageBody<T> {

    public static final int USER_INFO = 0;
    public static final int MESSAGE_INFO = 1;

    private int bodyType;
    private T message;

    public int getBodyType() {
        return bodyType;
    }

    public void setBodyType(int bodyType) {
        this.bodyType = bodyType;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
