package com.ray.java.basic.simple_socket.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ray.java.basic.simple_socket.model.MessageBody;
import com.ray.java.basic.simple_socket.model.MessageInfo;
import com.ray.java.basic.simple_socket.model.SocketClient;
import com.ray.java.basic.simple_socket.model.UserInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dangdang on 5/17/16.
 */
public class SimpleChatServer {

    HashMap<String, SocketClient> socketClients;
    boolean isRunning = true;

    public class ClientHandler implements Runnable {

        BufferedReader reader;
        Socket socket;

        public ClientHandler(Socket clientSocket) {

            System.out.print("add clients to collections: ");
            try {
                this.socket = clientSocket;
                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isReader);
                String message = reader.readLine();
                if (message.contains("[userMac]")) {
                    String userMac = message.replace("[userMac]", "");
                    socketClients.put(userMac, new SocketClient(userMac, this.socket));
                    System.out.println("userMac: " + userMac);
                    sendConnectionMessage();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    parseMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new SimpleChatServer().go();
    }

    public void go() {
        socketClients = new HashMap<>();
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            System.out.println("server is running! ");
            while (isRunning) {
                Socket clientSocket = serverSocket.accept();
                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendConnectionMessage() {

        MessageBody messageBody = new MessageBody();

        ArrayList<UserInfo> users = new ArrayList<>();
        for (Object o : socketClients.entrySet()) {
            Map.Entry element = (Map.Entry) o;
            String userMac = element.getKey().toString();
            users.add(new UserInfo(userMac));
        }
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessageContent(new Gson().toJson(users));
        messageInfo.setDate(System.currentTimeMillis());
        messageBody.setBodyType(MessageBody.USER_INFO);
        messageBody.setMessage(messageInfo);

        for (Object o : socketClients.values()) {
            SocketClient client = (SocketClient) o;
            client.getWriter().println(new Gson().toJson(messageBody));
            client.getWriter().flush();
        }
    }

    private void parseMessage(String message) {

        MessageBody messageBody = new Gson().fromJson(message,
                new TypeToken<MessageBody>() {
                }.getType());

        System.out.println("parseMessage: " + message);
        MessageInfo messageInfo = messageBody.getMessage();
        for (Object o : socketClients.values()) {
            SocketClient client = (SocketClient) o;
            if (messageInfo.getReceiveUserMac().equals(client.getClientMac())) {
                client.getWriter().println(message);
                client.getWriter().flush();

                System.out.println("send message success: " + message);
                break;
            }

            System.out.println("not find receive user ");
        }
    }

}
