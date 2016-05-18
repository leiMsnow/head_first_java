package com.ray.java.basic.simple_socket;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by dangdang on 5/17/16.
 */
public class SimpleChatServer {

    ArrayList<SocketClient> socketClients;
    boolean isRunning = true;

    public class ClientHandler implements Runnable {

        BufferedReader reader;
        Socket socket;

        public ClientHandler(Socket clientSocket) {

            System.out.println("add clients to collections ");
            try {
                this.socket = clientSocket;
                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isReader);
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String message = reader.readLine();
                if (message.contains("[userMac]")) {
                    String userMac = message.replace("[userMac]", "");
                    message = "welcome !";
                    socketClients.add(new SocketClient(userMac, this.socket));
                    System.out.println("userMac: " + userMac);
                    connectionMessage(writer, message);
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
                    transferMessage(message);
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
        socketClients = new ArrayList<>();
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

    private void connectionMessage(PrintWriter printWriter, String message) {
        Gson gson = new Gson();
        ArrayList<ConnectionUser> users = socketClients.stream().map(client ->
                new ConnectionUser(client.getClientMac())).collect(Collectors.toCollection(ArrayList::new));
        printWriter.println(gson.toJson(users));
        printWriter.flush();
    }

    private void transferMessage(String message) {
        Message messageJson = new Gson().fromJson(message, Message.class);
        socketClients.stream().filter(client -> !messageJson.getUserMac().equals(client.getClientMac())).forEach(client -> {
            client.getWriter().println(message);
            client.getWriter().flush();
        });
    }

}
