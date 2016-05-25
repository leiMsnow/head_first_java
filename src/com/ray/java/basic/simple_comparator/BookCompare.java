package com.ray.java.basic.simple_comparator;

import java.util.Comparator;

/**
 * Created by dangdang on 5/23/16.
 */
public class BookCompare implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
