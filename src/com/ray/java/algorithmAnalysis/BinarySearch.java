package com.ray.java.algorithmAnalysis;

/**
 * Created by dangdang on 2017/8/1.
 */
public class BinarySearch {

    static int count = 0;

    public static void main(String[] args) {

        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("searchRecursive = [" + searchRecursive(arrays, 0, arrays.length - 1, 6) + "]");
        System.out.println("count = [" + count + "]");
        count = 0;
        System.out.println("searchLoop = [" + searchLoop(arrays, 6) + "]");
        System.out.println("count = [" + count + "]");
    }

    /**
     * 递归方式
     *
     * @param array
     * @param start
     * @param end
     * @param findValue
     * @return
     */
    private static int searchRecursive(int[] array, int start, int end, int findValue) {
        if (array == null) {
            return -1;
        }

        count++;

        if (start <= end) {
            int mid = (start + end) / 2;
            int midVal = array[mid];
            if (midVal == findValue) {
                return mid;
            } else if (midVal < findValue) {
                return searchRecursive(array, mid + 1, end, findValue);
            } else {
                return searchRecursive(array, start, mid - 1, findValue);
            }
        } else {
            return -1;
        }
    }

    private static int searchLoop(int[] array, int findValue) {
        if (array == null) {
            return -1;
        }


        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            count++;
            int middle = (start + end) / 2;
            int middleValue = array[middle];
            if (middleValue == findValue) {
                return middle;
            } else if (middleValue < findValue) {
                start = middle + 1;
            } else if (middleValue > findValue) {
                end = middle - 1;
            }
        }

        return -1;
    }
}
