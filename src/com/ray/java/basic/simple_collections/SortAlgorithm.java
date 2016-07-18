package com.ray.java.basic.simple_collections;

import java.util.Arrays;

/**
 * Created by dangdang on 6/24/16.
 */
public class SortAlgorithm {

    public static void main(String[] args) {

        int[] data = new int[]{
                20, 54, 12, 53, 64, 64, 32, 23, 23
        };

        int max = data[0];
        for (int i : data) {
            max = max > i ? max : i;
        }
        System.out.println("max:" + max);

        Arrays.sort(data);

        System.out.println("max:" + data[data.length - 1]);
    }

}
