package com.ray.java.effective_java;

/**
 * Created by dangdang on 29/11/2016.
 */
public class Class39 {

    Class39_1 classA;
    Class39_1 classB;

    public Class39(Class39_1 classA, Class39_1 classB) {
        if (classA.getX() >= classB.getX()) {
            throw new IllegalArgumentException("error, classA must < classB");
        }
        this.classA = new Class39_1();
        this.classA.setX(classA.getX());
        this.classB = new Class39_1();
        this.classB.setX(classB.getX());
    }

    public Class39_1 getClassA() {
        return new Class39_1();
    }

    public Class39_1 getClassB() {
        return classB;
    }

    public static void main(String[] args) {
        Class39_1 a = new Class39_1();
        a.setX(4);
        Class39_1 b = new Class39_1();
        b.setX(5);

        Class39 class39 = new Class39(a, b);

        class39.getClassB().setX(1);

        System.out.println(class39.getClassA().getX());
        System.out.println(class39.getClassB().getX());
    }
}
