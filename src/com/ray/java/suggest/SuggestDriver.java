package com.ray.java.suggest;

import java.util.Random;

/**
 * Created by dangdang on 7/7/16.
 */
public class SuggestDriver {

    public static void main(String[] args) {

//        incrementTrap();
        random();
    }


    // 自增的困扰
    private static void incrementTrap() {

        int result = 0;
        for (int i = 0; i < 100; i++) {
            result = result++;
        }
        System.out.println("result is " + result);
    }

    private static void random() {

        Random random = new Random(100);
        for (int i = 0; i < 3; i++) {
            System.out.println(i + " is " + random.nextInt());
        }

    }


}
