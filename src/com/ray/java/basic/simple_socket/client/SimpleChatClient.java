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

    UserInfo userInfo;
    ArrayList<UserInfo> users;
    UserInfo selectUser;

    public static void main(String[] args) {
        SimpleChatClient simpleChatClientA = new SimpleChatClient();
        simpleChatClientA.go();
    }

    public void go() {

        userInfo = new UserInfo("b3:53:f8:68:ad:a7", "张雷雷的电脑",
                "http://img.woyaogexing.com/touxiang/katong/20140319/3be17ad440da08c1!200x200.jpg");
        //getRandomMacAddress();

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
                    if (selectUser == null) {
                        selectUser = users.get(src.getSelectedIndex());
                        incoming.setText(incoming.getText() + ("--------------切换到与" +
                                selectUser.getName() + "的聊天--------------\n"));
                    } else if (!users.get(src.getSelectedIndex()).equals(selectUser)) {
                        selectUser = users.get(src.getSelectedIndex());
                        incoming.setText(incoming.getText() + ("--------------切换到与" +
                                selectUser.getName() + "的聊天--------------\n"));
                    }
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

        connection();

    }

    private void connection() {

        try {
            socket = new Socket("127.0.0.1", 5555);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());

            String loginInfo = new Gson().toJson(userInfo);
            writer.println("[userMac]" + loginInfo);
            writer.flush();

            Thread readerThread = new Thread(new ReaderThread());
            readerThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                MessageInfo messageInfo = new MessageInfo();
                messageInfo.setSendUserMac(userInfo);
                messageInfo.setReceiveUserMac(selectUser);
                messageInfo.setMessageContent(outgoing.getText());
                messageInfo.setDate(System.currentTimeMillis());

                MessageBody<MessageInfo> messageBody = new MessageBody<>();
                messageBody.setBodyType(MessageBody.MESSAGE_INFO);
                messageBody.setMessage(messageInfo);

                String sendMessage = new Gson().toJson(messageBody);
                if (selectUser != null) {
                    writer.println(sendMessage);
                    writer.flush();
                    incoming.setText(incoming.getText() + ("me said: " + messageInfo.getMessageContent() + "\n"));
                } else {
                    System.out.println("not select user ");
                }
                System.out.println("message: " + sendMessage);

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
                    System.out.println("receiveMessage: " + message);

                    MessageBody messageJson = new Gson().fromJson(message,
                            MessageBody.class);

                    if (messageJson.getBodyType() == MessageBody.USER_INFO) {

                        MessageBody<ArrayList<UserInfo>> messageBody = new Gson().fromJson(message,
                                new TypeToken<MessageBody<ArrayList<UserInfo>>>() {
                                }.getType());

                        users = messageBody.getMessage();

                        String[] userMacs = new String[users.size()];
                        int index = 0;
                        for (Object user : users) {
                            UserInfo userInfo = (UserInfo) user;
                            userMacs[index] = userInfo.getName();
                            index++;
                        }
                        jList.setListData(userMacs);
                    } else {
                        MessageBody<MessageInfo> messageBody = new Gson().fromJson(message,
                                new TypeToken<MessageBody<MessageInfo>>() {
                                }.getType());

                        MessageInfo messageInfo = messageBody.getMessage();

                        incoming.setText(incoming.getText() + (
                                messageInfo.getSendUserMac().getName() + " said: " + messageInfo.getMessageContent() + "\n"));
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
