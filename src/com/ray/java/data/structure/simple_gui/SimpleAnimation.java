package com.ray.java.data.structure.simple_gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dangdang on 5/13/16.
 */
public class SimpleAnimation {

    JFrame frame;
    int x = 70;
    int y = 70;

    public static void main(String[] args) {
        SimpleAnimation simpleGui1 = new SimpleAnimation();
        simpleGui1.go();
    }

    public void go() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        NewMyDrawPanel drawPanel = new NewMyDrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);

        for (int i = 0; i < 100; i++) {
            x++;
            y++;
            drawPanel.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    class NewMyDrawPanel extends JPanel {

        public void paintComponent(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;

            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            Color startColor = new Color(red, green, blue);

            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            Color endColor = new Color(red, green, blue);

            GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
            g2d.setPaint(gradient);
            g2d.fillOval(x, y, 50, 50);

        }


    }
}
