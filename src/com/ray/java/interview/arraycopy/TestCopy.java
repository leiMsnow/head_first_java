package com.ray.java.interview.arraycopy;

/**
 * Created by Azure on 2016/5/17.
 */
public class TestCopy {

    public static void main(String[] args) {

        int[] integers = new int[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        };
        System.out.println(printIntArray(integers));

        int srcPos = 3;
        int[] ints = new int[integers.length + 4];
        System.arraycopy(integers, srcPos, ints, 0, integers.length - srcPos);
        System.out.println(printIntArray(ints));

//        Integer[] ints1 = new Integer[integers.length + 1];
//        System.arraycopy(integers, 0, ints1, 0, integers.length);
//        System.out.println(printArray(ints1));

        //*********************string array***************************
        String[] strSrc = new String[]{
                "1", "2", "3", "4", "5"
        };
        System.out.println(printArray(strSrc));

        String[] strDest = new String[strSrc.length + 1];
        System.arraycopy(strSrc, 0, strDest, 0, strSrc.length);
        System.out.println(printArray(strDest));

       int round =  Math.round(Float.parseFloat("1"));

        System.out.println(round);
    }


    static String printArray(Object[] ints) {
        StringBuilder builder = new StringBuilder();
        for (Object i : ints) {
            builder.append(i);
            builder.append(",");
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        return builder.toString();
    }

    static String printIntArray(int[] ints) {
        StringBuilder builder = new StringBuilder();
        for (int i : ints) {
            builder.append(i);
            builder.append(",");
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        return builder.toString();
    }

}
