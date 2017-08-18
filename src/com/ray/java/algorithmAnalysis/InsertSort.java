package com.ray.java.algorithmAnalysis;

import java.util.Arrays;

/**
 * 每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止。
 * Created by dangdang on 2017/8/2.
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] arrays = {123, 24, 234, 123, 345};
        insertSort(arrays);
        System.out.println("arrays:" + Arrays.toString(arrays));
    }

    /**
     * 插入排序
     * <p>
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 将新元素插入到该位置中
     * 重复步骤2
     *
     * @param arrays
     */
    public static void insertSort(int[] arrays) {
        int size = arrays.length;
        int j = 0;
        for (int i = 0; i < size; i++) {
            int temp = arrays[i];
            for (j = i; j > 0 && temp < arrays[j - 1]; j--) {
                arrays[j] = arrays[j - 1];
            }
            arrays[j] = temp;
        }
    }

}
