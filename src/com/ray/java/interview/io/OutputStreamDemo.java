package com.ray.java.interview.io;

import java.io.*;

/**
 * Created by dangdang on 5/25/16.
 */
public class OutputStreamDemo {

    public static void main(String[] args) {
        OutputStreamDemo os = new OutputStreamDemo();
        os.writerFile("hello.txt");
    }


    private void writerFile(String src) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(src);
            writer.write("hello,new file!");
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
