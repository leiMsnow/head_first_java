package com.ray.java.interview.clone;

/**
 * Created by Azure on 2016/5/15.
 */
public class TestClone {

    static public void main(String[] args) {

        ShallowClone sc = new ShallowClone();
        sc.setInter(100);
        sc.setStrings(" it's string ");
        sc.setArrays(new int[]{1, 2, 3});

        System.out.println("浅克隆前-sc：" + sc.getStrings());
        System.out.println("浅克隆前-sc：" + sc.getInter());
        System.out.println("浅克隆前-sc：" + sc.getArrays()[0]);
        System.out.println("------------------------------------------------");

        try {

            ShallowClone clone = (ShallowClone) sc.clone();

            int array1 []= clone.getArrays();
            array1[0] = 5;
            clone.setInter(200);
            clone.setStrings("it's clone string");

            System.out.println("浅克隆后-clone：" + clone.getStrings());
            System.out.println("浅克隆后-clone：" + clone.getInter());
            System.out.println("浅克隆后-clone：" + clone.getArrays()[0]);
            System.out.println("------------------------------------------------");
            System.out.println("浅克隆后-sc：" + sc.getStrings());
            System.out.println("浅克隆后-sc：" + sc.getInter());
            System.out.println("浅克隆后-sc：" + sc.getArrays()[0]);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}
