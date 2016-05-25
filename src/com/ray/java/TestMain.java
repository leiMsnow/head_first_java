package com.ray.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by dangdang on 5/9/16.
 */
public class TestMain {

    public static void main(String[] args) {

        short c = 7;
        long t = 42;
//        calcArea(t,20);


//        byte h = calcArea(2,20);

//        main.calcArea(2,2);

        String main = null;

        if ("0".equals(main)) {
            System.out.println("null");
        }

        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add("111");
        arrayList.add("222");


        System.out.println(arrayList.get(0));

        System.out.println(getRandomMacAddress());

        Date today = new Date();
        System.out.println(String.format("%ta,%<tb,%<tD", today));

        int x = 10;
        x = ~x;
        System.out.println("x: " + x);
        int y = 6;
        int a = x | y;
        System.out.println("a: " + a);
        y = 10 >> 2;
        System.out.println("y: " + y);

    }


    private static int calcArea(int height, int width) {
        return height * width;
    }

    private static double calcArea(double height, double width) {
        return height * width;
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
