package com.ray.java.network;

import java.io.*;
import java.util.concurrent.*;
import java.util.zip.GZIPOutputStream;

/**
 * Created by dangdang on 28/12/2016.
 */
public class Learning_03 {


    public static void main(String[] args) {
        int[] data = new int[]{
                1, 5, 123, 53, 123, 5, 1, 53, 1, 2, 4, 34, 232, 523, 567, 356, 2, 34
        };
        try {
            int max = MultithreadedMaxFiner.max(data);
            System.out.println("max = [" + max + "]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    static class FindMaxTask implements Callable<Integer> {

        private int[] data;
        private int start;
        private int end;

        public FindMaxTask(int[] data, int start, int end) {
            this.data = data;
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() throws Exception {
            int max = data[start];
            for (int i = start; i < end; i++) {
                if (data[i] > max)
                    max = data[i];
            }
            return max;
        }
    }

    static class MultithreadedMaxFiner {

        public static int max(int[] data) throws InterruptedException, ExecutionException {
            if (data.length == 1) {
                return data[0];
            } else if (data.length == 0) {
                throw new IllegalArgumentException();
            }

            FindMaxTask task1 = new FindMaxTask(data, 0, data.length / 2);
            FindMaxTask task2 = new FindMaxTask(data, data.length / 2, data.length);

            ExecutorService service = Executors.newFixedThreadPool(2);

            Future<Integer> future1 = service.submit(task1);
            Future<Integer> future2 = service.submit(task2);

            return Math.max(future1.get(), future2.get());

        }

    }


}
