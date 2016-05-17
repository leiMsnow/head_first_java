package com.ray.interview.clone;

/**
 * Created by Azure on 2016/5/15.
 */
public class ShallowClone implements Cloneable {

    private int inter;
    private String strings;
    private int[] arrays;


    @Override
    public Object clone() throws CloneNotSupportedException {

        ShallowClone newObj ;

        newObj = (ShallowClone) super.clone();

        return newObj;
    }

    public int getInter() {
        return inter;
    }

    public void setInter(int inter) {
        this.inter = inter;
    }

    public int[] getArrays() {
        return arrays;
    }

    public void setArrays(int[] arrays) {
        this.arrays = arrays;
    }

    public String getStrings() {
        return strings;
    }

    public void setStrings(String strings) {
        this.strings = strings;
    }

//    @Override
//    public String toString() {
//        return "ShallowClone{" +
//                "arrays=" + Arrays.toString(arrays) +
//                ", inter=" + inter +
//                ", strings='" + strings + '\'' +
//                '}';
//    }
}
