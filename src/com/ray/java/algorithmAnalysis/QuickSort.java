package com.ray.java.algorithmAnalysis;

import java.util.Arrays;
import java.util.Random;

/**
 * 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，则分别对这两部分继续进行排序，直到整个序列有序。
 * Created by dangdang on 2017/8/1.
 */
public class QuickSort {
    public static final int COUNT = 10;
    public static final int ZONE = 20;

    public static void main(String[] args) {
        Random rand = new Random();
        Integer[] array = new Integer[COUNT];
        for (int i = 0; i < COUNT; i++) {
            array[i] = rand.nextInt(ZONE);
        }

        long startTime = System.currentTimeMillis();
        System.out.println("排序前：" + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        long endTime = System.currentTimeMillis();
        float time = (endTime - startTime) / 1000;
        System.out.println("排序后：" + Arrays.toString(array));
        System.out.println("用时：" + time);

    }

    /**
     * 1、选择基准值
     * 2、从首段开始，找到一个比基准大的数
     * 3、从尾端开始，找到一个别基准小的数
     * 4、如果i,j不相等，则交换位置
     * 5、相等，则将基准值和i位置数值交换
     * 6、递归左侧和右侧
     *
     * @param array
     * @param left
     * @param right
     */
    private static void quickSort(Integer[] array, int left, int right) {
        if (left > right) return;
        // 1
        int base = array[left];
        int i = left;
        int j = right;

        while (i != j) {
            // 2
            while (i < j && array[j] >= base) {
                j--;
            }
            // 3
            while (i < j && array[i] <= base) {
                i++;
            }
            // 4
            if (i < j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }
        // 5
        array[left] = array[i];
        array[i] = base;
        // 6
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }

}
