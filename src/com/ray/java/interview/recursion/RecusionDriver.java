package com.ray.java.interview.recursion;

/**
 * Created by dangdang on 7/28/16.
 */
public class RecusionDriver {

    public static void main(String[] args) {

        System.out.println(getAge(5));
    }


    public static int getAge(int num) {
        if (num == 1) {
            return 10;
        }
        return 2 + getAge(num - 1);
    }
}
