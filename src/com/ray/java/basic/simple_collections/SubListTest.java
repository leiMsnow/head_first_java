package com.ray.java.basic.simple_collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dangdang on 6/27/16.
 */
public class SubListTest {

    public static void main(String[] args) {
//        List<SubListTest> list = new ArrayList<>();
//        list.add(new SubListTest("Ray"));
//        list.add(new SubListTest("Ray"));

//        List<SubListTest> subList = list.subList(0, list.size() - 1);
//        System.out.println("Object - equals:" + list.equals(subList));
//        list.add(new SubListTest("Android"));
//        System.out.println(subList.get(0));
//        subList.remove(0);
//        System.out.println("Object - size :" + list.size());

        List<String> listString = new ArrayList<>();
        listString.add(("Ray"));
        listString.add(("Ray"));

        List<String> subListString = listString.subList(0, listString.size() - 1);
        System.out.println("String - equals:" + subListString.equals(listString));
        subListString.add(("Android"));

    }

    private String name;

    public SubListTest(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof SubListTest) {
            return this.name.equals(((SubListTest) obj).name);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode();
    }
}
