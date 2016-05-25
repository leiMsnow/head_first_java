package com.ray.java.basic.simple_comparator;

import java.util.TreeSet;

/**
 * Created by dangdang on 5/23/16.
 */
public class TestComparator {

    public static void main(String[]a){
        TestComparator comparator = new TestComparator();
        comparator.go();

    }

    public void go(){

        Book b1 = new Book("Java编程思想","1");
        Book b2 = new Book("Android内核设计思想","2");
        Book b3 = new Book("Hadoop权威指南","3");

        BookCompare compare = new BookCompare();
        TreeSet<Book> books = new TreeSet<>(compare);
        books.add(b1);
        books.add(b2);
        books.add(b3);
        System.out.println(books);

    }



}
