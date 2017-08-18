package com.ray.java.dataStructures;

import java.util.LinkedList;

/**
 * Created by dangdang on 2017/6/22.
 */
public class MyLinkedList<E> {

    


    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

}
