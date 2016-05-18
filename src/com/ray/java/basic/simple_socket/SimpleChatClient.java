package com.ray.java.basic.simple_socket;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

/**
 * Created by dangdang on 5/17/16.
 */
public class SimpleChatClient {

    JTextArea incoming;
    JTextField outgoing;

    BufferedReader reader;
    PrintWriter writer;

    Socket socket;

    String userMac;

    public static void main(String[] args) {
        SimpleChatClient simpleChatClientA = new SimpleChatClient();
        simpleChatClientA.go();
    }

    public void go() {

        userMac = getRandomMacAddress();

        JFrame frame = new JFrame("Simple Chat Client");
        JPanel mainPanel = new JPanel();

        incoming = new JTextArea(15, 50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(incoming);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        outgoing = new JTextField(20);

        JButton sendButton = new JButton("send");
        sendButton.addActionListener(new SendButtonListener());

        mainPanel.add(scrollPane);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 500);
        frame.setVisible(true);

        setUpNetworking();
        Thread readerThread = new Thread(new ReaderThread());
        readerThread.start();
    }

    private void setUpNetworking() {

        try {
            socket = new Socket("127.0.0.1", 5555);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());

            writer.println("[userMac]" + userMac);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Message json = new Message();
                json.setUserMac(userMac);
                json.setMessageContent(outgoing.getText());
                json.setDate(System.currentTimeMillis());
                Gson gson = new Gson();
                writer.println(gson.toJson(json));
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }

    }


    private class ReaderThread implements Runnable {
        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println(message);
                    incoming.setText(incoming.getText() + (message + "\n"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static String getRandomMacAddress() {
        String alphabet = "abcdef1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int random1 = new Random().nextInt(alphabet.length());
            int random2 = new Random().nextInt(alphabet.length());
            if (i > 0) {
                stringBuilder.append(":");
            }
            stringBuilder.append(alphabet.charAt(random1))
                    .append(alphabet.charAt(random2));
        }
        return stringBuilder.toString();
    }
}
