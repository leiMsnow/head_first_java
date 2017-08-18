package com.ray.java.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dangdang on 2017/7/7.
 */
public class Leetcode {


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 7, 11, 15};
//        int target = 9;
//        int[] result = twoSum(nums, target);
//        System.out.println("twoSum = [" + Arrays.toString(result) + "]");

        System.out.println("reverse = [" + reverse(123) + "]");
    }
}
