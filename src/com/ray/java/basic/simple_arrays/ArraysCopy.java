package com.ray.java.basic.simple_arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dangdang on 6/24/16.
 */
public class ArraysCopy {

    public static void main(String[] args) {
//        int[] data = {1, 2, 3, 4, 5};
//        List list = Arrays.asList(data);
//        System.out.println("size:" + list.size());
//
//        System.out.println("type:" + data.equals(list.get(0)));
//
//
//        Integer[] data1 = {1, 2, 3, 4, 5};
//        List list1 = Arrays.asList(data1);
//        System.out.println("size" + list1.size());
//        System.out.println("type:" + data1.equals(list1.get(0)));


        List<String> books = Arrays.asList("java编程思想", "代码重构设计", "Objective-C基础教程");
        books.add("Android核心思想");
        books.forEach(System.out::println);

    }
}
