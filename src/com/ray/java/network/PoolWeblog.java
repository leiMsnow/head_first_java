package com.ray.java.network;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by dangdang on 04/01/2017.
 */
public class PoolWeblog {

    private final static int NUM_THREADS = 4;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        Queue<LogEntry> results = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "utf-8"))) {
            for (String entry = reader.readLine(); entry != null; entry = reader.readLine()) {
                LookupTask task = new LookupTask(entry);
                Future<String> future = executorService.submit(task);
                LogEntry result = new LogEntry(entry, future);
                results.add(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (LogEntry result : results) {
            try {
                System.out.println(result.future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }

    private static class LogEntry {
        String original;
        Future<String> future;

        public LogEntry(String original, Future<String> future) {
            this.original = original;
            this.future = future;
        }
    }
}
