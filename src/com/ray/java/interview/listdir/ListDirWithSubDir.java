package com.ray.java.interview.listdir;

import java.io.File;

/**
 * 列出给出路径下所有的目录，包括子目录
 * Created by dangdang on 5/25/16.
 */
public class ListDirWithSubDir {

    public static void main(String[] args) {

        String fileName = "/Users/dangdang/Documents/Ray/电科院";
        printListDir(fileName);

    }

    private static void printListDir(String fileName) {
        File file = new File(fileName);
        if (file.isDirectory()) {
            File[] fileChildren = file.listFiles();
            if (fileChildren != null) {
                for (File aFileChildren : fileChildren) {
                    printListDir(aFileChildren.getAbsolutePath());
                }
            }
        } else {
            System.out.println("file: " + file.getAbsolutePath());
        }
    }

}
