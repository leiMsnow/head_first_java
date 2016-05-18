package com.ray.java.basic.simple_socket.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ray.java.basic.simple_socket.model.MessageBody;
import com.ray.java.basic.simple_socket.model.MessageInfo;
import com.ray.java.basic.simple_socket.model.UserInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by dangdang on 5/17/16.
 */
public class SimpleChatClient {

    JTextArea incoming;
    JTextField outgoing;
    JList<String> jList;

    BufferedReader reader;
    PrintWriter writer;

    Socket socket;

    String userMac;

    String selectUser;

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

        jList = new JList<>();

        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList src;
                if (e.getClickCount() == 1) {
                    src = (JList<?>) e.getSource();
                    selectUser = src.getSelectedValue().toString();
                    System.out.println("selected: " + selectUser);
                }
            }
        });

        outgoing = new JTextField(20);
        JButton sendButton = new JButton("send");
        sendButton.addActionListener(new SendButtonListener());

        mainPanel.add(jList);
        mainPanel.add(scrollPane);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(650, 350);
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

                if (selectUser != null) {
                    MessageInfo messageInfo = new MessageInfo();
                    messageInfo.setSendUserMac(userMac);
                    messageInfo.setReceiveUserMac(selectUser);
                    messageInfo.setMessageContent(outgoing.getText());
                    messageInfo.setDate(System.currentTimeMillis());

                    MessageBody messageBody = new MessageBody();
                    messageBody.setBodyType(MessageBody.MESSAGE_INFO);
                    messageBody.setMessage(messageInfo);

                    writer.println(new Gson().toJson(messageBody));
                    writer.flush();
                }
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
                    MessageBody messageBody = new Gson().fromJson(message,
                            MessageBody.class);
                    MessageInfo messageInfo = messageBody.getMessage();
                    if (messageBody.getBodyType() == MessageBody.USER_INFO) {
                        ArrayList<UserInfo> users = new Gson().fromJson(messageInfo.getMessageContent(),
                                new TypeToken<ArrayList<UserInfo>>() {
                                }.getType());
                        String[] userMacs = new String[users.size() - 1];
                        int index = 0;
                        Iterator it = users.iterator();
                        while (it.hasNext()) {
                            UserInfo userInfo = ((UserInfo) it.next());
                            if (!userInfo.getUserMac().equals(userMac)) {
                                userMacs[index] = userInfo.getUserMac();
                                index++;
                            }
                        }
                        jList.setListData(userMacs);
                    } else {
                        incoming.setText(incoming.getText() + (
                                messageInfo.getSendUserMac() + " said: " + messageInfo.getMessageContent() + "\n"));
                    }
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
