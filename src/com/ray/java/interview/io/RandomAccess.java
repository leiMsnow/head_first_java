package com.ray.java.interview.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by dangdang on 5/25/16.
 */
public class RandomAccess {

    public static void main(String[] args) {
        RandomAccess randomA = new RandomAccess();
        randomA.writeToFile();
    }

    private void writeToFile() {

        String fileName = "RandomAccess.txt";
        RandomAccessFile randomAccessFile = null;

        try {

            randomAccessFile = new RandomAccessFile(new File(fileName),"rw");
            randomAccessFile.writeBytes("writeBytes");
            randomAccessFile.writeBoolean(false);
            randomAccessFile.writeChar('A');
            randomAccessFile.writeFloat(1.f);
            randomAccessFile.writeDouble(2.222);
            randomAccessFile.writeInt(1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
