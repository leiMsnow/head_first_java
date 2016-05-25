package com.ray.java.algorithmAnalysis;

/**
 * 普通数组
 * Created by dangdang on 5/24/16.
 */
public class GeneralArray {

    private int[] elements;
    // 数组大小
    private int size;
    // 数组有多少项
    private int realElement;

    public GeneralArray(int max) {
        this.elements = new int[max];
        this.size = max <= 0 ? 10 : max;
        this.realElement = 0;
    }

    /**
     * 判断是否存在
     *
     * @param value 要查找的值
     * @return
     */
    public int hasElement(int value) {
        int i;
        for (i = 0; i < realElement; i++) {
            if (elements[i] == value) {
                break;
            }
        }
        if (i == realElement) {
            i = -1;
        }

        return i;
    }

    /**
     * 插入值
     *
     * @param value int类型值
     * @return
     */
    public boolean insert(int value) {
        rangeCheckForAdd(realElement);
        elements[realElement] = value;
        realElement++;
        return true;
    }

    public boolean delete(int value) {
        int i = hasElement(value);
        if (i == -1) {
            return false;
        }

        return false;

    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

}
