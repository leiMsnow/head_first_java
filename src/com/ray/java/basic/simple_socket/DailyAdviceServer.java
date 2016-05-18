package com.ray.java.basic.simple_socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dangdang on 5/17/16.
 */
public class DailyAdviceServer {

    String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they do NOT make you look fat.",
            "One word: inappropriate", "Just for today, be honest. Tell your boss what you *really* tink",
            "You might want to rethink that haircut."};

    public void go() {

        try {

            ServerSocket serverSocket = new ServerSocket(4242);
            while (true) {
                Socket socket = serverSocket.accept();

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();

                System.out.println(advice);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        DailyAdviceServer dailyAdviceServer = new DailyAdviceServer();
        dailyAdviceServer.go();
    }

    public String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }
}
