package com.ray.java.interview.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 从console接受用户输入的字符
 * Created by dangdang on 5/25/16.
 */
public class InputFromConsole {

    public static void main(String[] args) throws IOException {

//        byte[] bytes = new byte[1024];
//        try {
//            System.in.read(bytes);
//            System.out.println("input: " + new String(bytes));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        System.out.println("input: "+input);

    }

}
