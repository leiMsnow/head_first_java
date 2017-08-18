package com.ray.java.dataStructures;

/**
 * Created by dangdang on 2017/6/22.
 */
public class MyList {

    private int length = 0;
    private final int MAX_LENGTH = 30;
    private int arrays[] = new int[MAX_LENGTH];

    public int getElement(int index) {
        if (index < 0 || index >= MAX_LENGTH) {
            return -1;
        }
        return arrays[index];
    }

    public int add(int data) {
        return add(length, data);
    }

    public int add(int index, int data) {
        if (index < 0 || index > MAX_LENGTH) {
            return -1;
        }

        for (int i = length - 1; i >= index; i--) {
            arrays[i + 1] = arrays[i];
        }
        arrays[index] = data;
        length++;
        return index;
    }

    public int delete(int index) {
        if (index < 0 || index > MAX_LENGTH) {
            return -1;
        }

        for (int i = index; i < length; i++) {
            arrays[i] = arrays[i+1];
        }
        length--;
        return index;
    }

    public int size() {
        return length;
    }


    public static void main(String[] args) {
        MyList list = new MyList();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(1, 2);
        list.delete(2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("current: " + list.getElement(i));
        }
    }

}
