package com.ray.java.basic.simple_socket.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by dangdang on 5/18/16.
 */
public class SocketClient {

    private UserInfo clientMac;
    private Socket socket;
    private boolean isAlive;
    private long firstTime;
    private long lastTime;
    private PrintWriter writer;

    public SocketClient(UserInfo clientMac, Socket socket) {
        this.clientMac = clientMac;
        this.socket = socket;
        this.isAlive = true;
        this.firstTime = System.currentTimeMillis();
        this.lastTime = System.currentTimeMillis();
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    public UserInfo getClientMac() {
        return clientMac;
    }

    public void setClientMac(UserInfo clientMac) {
        this.clientMac = clientMac;
    }

    //    public String getClientMac() {
//        return clientMac;
//    }
//
//    public void setClientMac(String clientMac) {
//        this.clientMac = clientMac;
//    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public long getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(long firstTime) {
        this.firstTime = firstTime;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public PrintWriter getWriter() {
        if (writer == null) {
            try {
                this.writer = new PrintWriter(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return writer;
    }
}
