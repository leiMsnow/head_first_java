package com.ray.java.algorithmAnalysis;

import java.util.Arrays;

/**
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，
 * 如此循环到倒数第二个数和最后一个数比较为止。
 * Created by dangdang on 2017/8/2.
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] array = {12, 34, 1, 2, 421, 2, 34};
        selectSort(array);
        System.out.println("array:" + Arrays.toString(array));

    }

    private static void selectSort(int[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            int k = i;
            for (int j = size - 1; j > i; j--) {
                if (array[j] < array[k]) {
                    k = j;
                }
            }
            int temp = array[i];
            array[i] = array[k];
            array[k] = temp;
        }
    }
}
