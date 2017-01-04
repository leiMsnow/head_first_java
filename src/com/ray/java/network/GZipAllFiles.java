package com.ray.java.network;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPOutputStream;

/**
 * Created by dangdang on 29/12/2016.
 */
public class GZipAllFiles {


    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        String fileName = "/Users/dangdang/Documents/workspace/JavaWorkspace/head_first_java/src/com/ray/java";
        File f = new File(fileName);
        if (f.exists()) {
            if (f.isDirectory()) {
                File[] files = f.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (!file.isDirectory()) {
                            Runnable task = new GZipRunnable(file);
                            pool.submit(task);
                        }
                    }
                }
            } else {
                Runnable task = new GZipRunnable(f);
                pool.submit(task);
            }
        }
        pool.shutdown();
    }

    static class GZipRunnable implements Runnable {

        private File inFile;

        public GZipRunnable(File file) {
            this.inFile = file;
        }

        @Override
        public void run() {
            if (!inFile.getName().endsWith(".gz")) {
                File outFile = new File(inFile.getParent(), inFile.getName() + ".gz");
                if (!outFile.exists()) {
                    try (
                            InputStream in = new BufferedInputStream(new FileInputStream(inFile));
                            OutputStream out = new BufferedOutputStream(new GZIPOutputStream(
                                    new FileOutputStream(outFile)))
                    ) {
                        int b;
                        while ((b = in.read()) != -1) out.write(b);
                        out.flush();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }
            }
        }
    }
}
