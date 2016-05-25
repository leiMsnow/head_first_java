package com.ray.java.interview.io;

import java.io.*;

/**
 * Created by dangdang on 5/25/16.
 */
public class CopyFile {

    public static void main(String[] args) {

        CopyFile copyFile = new CopyFile();
        System.out.println("simple-start: " + System.currentTimeMillis());
//        copyFile.copyBySimple("hello.txt", "hello2.txt");
        copyFile.copyBuffered("hello.txt", "hello2.txt");
        System.out.println("simple-end: " + System.currentTimeMillis());

    }


    private void copyBySimple(String src, String copySrc) {

        FileInputStream reader = null;
        FileOutputStream writer = null;
        File readerFile = new File(src);
        File writeFile = new File(copySrc);

        try {

            reader = new FileInputStream(readerFile);
            writer = new FileOutputStream(writeFile);
            byte[] bytes = new byte[(int) readerFile.length()];
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) reader.read();
            }
            writer.write(bytes);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void copyBuffered(String src, String copySrc) {
        File readerFile = new File(src);
        File writerFile = new File(copySrc);

        BufferedInputStream reader = null;
        BufferedOutputStream writer = null;


        try {

            reader = new BufferedInputStream(new FileInputStream(readerFile));
            writer = new BufferedOutputStream(new FileOutputStream(writerFile));

            byte[] bytes = new byte[(int) readerFile.length()];
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) reader.read();
            }

            writer.write(bytes);
            writer.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
