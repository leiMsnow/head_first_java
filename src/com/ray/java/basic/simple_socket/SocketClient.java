package com.ray.java.basic.simple_socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by dangdang on 5/18/16.
 */
public class SocketClient {

    private String clientMac;
    private Socket socket;
    private PrintWriter writer;

    public SocketClient(String clientMac, Socket socket) {
        this.clientMac = clientMac;
        this.socket = socket;
        try {
            this.writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getClientMac() {
        return clientMac;
    }

    public void setClientMac(String clientMac) {
        this.clientMac = clientMac;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public PrintWriter getWriter() {
        return writer;
    }
}
