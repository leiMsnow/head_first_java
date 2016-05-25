package com.ray.java.interview.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 从外部读入一个文件
 * Created by dangdang on 5/25/16.
 */
public class InputStreamDemo {

    public static void main(String[] args) {
        InputStreamDemo id = new InputStreamDemo();
        String src = "/Users/dangdang/Documents/workspace/JavaWorkspace/head_first_java/game.txt";
        id.readFile(src);
    }

    private void readFile(String src) {

        File file = new File(src);
        try {
            FileInputStream reader = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) reader.read();
            }

            System.out.println("message:" + new String(bytes));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
