package com.ray.java.network;

import java.io.*;

/**
 * 流
 * Created by dangdang on 27/12/2016.
 */
public class Learning_02 {


    public static void main(String[] args) {
//        tryOutputStream();

        tryInputStream();
    }

    private static void tryOutputStream() {

        try (FileWriter out = new FileWriter("outData.txt")) {
            out.write("hello,out data.");
            out.flush();
        } catch (IOException ex) {
            System.err.print(ex.getMessage());
        }
    }

    private static void tryInputStream() {
        try (InputStream in = new FileInputStream("data.txt")) {
            int bytesRead = 0;
            int bytesToRead = 1024;
            byte[] input = new byte[bytesToRead];
            while (bytesRead < bytesToRead) {
                int result = in.read(input, bytesRead, bytesToRead - bytesRead);
                if (result == -1) break;
                bytesRead += result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
