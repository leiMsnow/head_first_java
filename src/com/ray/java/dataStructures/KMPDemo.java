package com.ray.java.dataStructures;

/**
 * Created by dangdang on 2017/7/7.
 */
public class KMPDemo {

    private void getNext(String T, int[] next) {
        int i = 1;
        int j = 0;
        next[1] = 0;
        while (i < T.length()) {
            if (j == 0 || T.charAt(i) == T.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

    private int indexKMP(String S, String T, int pos) {
        int i = pos;
        int j = 1;
        int next[] = new int[255];
        getNext(T, next);
        while (i <= S.length() && j <= T.length()) {
            if (j == 0 || S.charAt(i) == T.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        if (j > T.length()) {
            return i - T.length();
        } else {
            return 0;
        }
    }
}
