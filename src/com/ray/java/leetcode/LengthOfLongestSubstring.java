package com.ray.java.leetcode;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * 5. Longest Palindromic Substring
 * Created by dangdang on 2017/8/9.
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcaaa";
        finLengthOfLongestSubstring(s);
    }

    private static void finLengthOfLongestSubstring(String s) {

        HashSet<Character> hashSet = new HashSet<>();
        int i = 0 ,j = 0, max = 0;

        while (j < s.length()) {
            if (!hashSet.contains(s.charAt(j))) {
                hashSet.add(s.charAt(j++));
                max = Math.max(max, hashSet.size());
            } else {
                hashSet.remove(s.charAt(i++));
            }
        }

        System.out.println("max: " + max);
    }
}
