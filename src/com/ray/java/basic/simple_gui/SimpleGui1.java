package com.ray.java.basic.simple_gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dangdang on 5/13/16.
 */
public class SimpleGui1 {

    JFrame frame;
    JLabel label;

    public static void main(String[] args) {
        SimpleGui1 simpleGui1 = new SimpleGui1();
        simpleGui1.go();
    }

    public void go() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(e -> frame.repaint());

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(e ->label.setText("Ouch"));

        label = new JLabel("I'm a label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.WEST,label);
        frame.getContentPane().add(BorderLayout.EAST,labelButton);
        frame.setSize(300, 300);
        frame.setVisible(true);



    }
}
