package com.ray.java.interview.arraycopy;

/**
 * Created by Azure on 2016/5/17.
 */
public class TestCopy {

    public static void main(String[] args) {

        int[] integers = new int[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        };
        System.out.println(printArray(integers));

        int srcPos = 3;
        int[] ints = new int[integers.length - srcPos];
        System.arraycopy(integers, srcPos, ints, 0, integers.length - srcPos);
        System.out.println(printArray(ints));

    }


    static String printArray(int[] ints) {
        StringBuilder builder = new StringBuilder();
        for (int i : ints) {
            builder.append(i);
            builder.append(",");
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        return builder.toString();
    }

}
