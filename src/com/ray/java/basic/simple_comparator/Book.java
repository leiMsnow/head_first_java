package com.ray.java.basic.simple_comparator;

/**
 * Created by dangdang on 5/23/16.
 */
public class Book implements Comparable<Book>{

    String title;
    String id;

    public Book(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.getTitle());
    }

    @Override
    public String toString() {
        return title;
    }
}
