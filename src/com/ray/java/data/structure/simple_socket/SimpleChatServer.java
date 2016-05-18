package com.ray.java.data.structure.simple_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by dangdang on 5/17/16.
 */
public class SimpleChatServer {

    ArrayList<PrintWriter> clientOutPutStreams;
    boolean isRunning = true;

    public class ClientHandler implements Runnable {

        BufferedReader reader;
        Socket socket;

        public ClientHandler(Socket clientSocket) {
            try {
                this.socket = clientSocket;
                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                    tellEveryone(message);
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
        clientOutPutStreams = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            while (isRunning) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutPutStreams.add(writer);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println(" got a new client connection");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void tellEveryone(String message) {
        for (Object clientOutPutStream : clientOutPutStreams) {
            PrintWriter writer = (PrintWriter) clientOutPutStream;
            writer.println(message);
            writer.flush();
        }
    }


}
