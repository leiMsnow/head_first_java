package com.ray.java.network;

import java.net.InetAddress;
import java.util.concurrent.Callable;

/**
 * Created by dangdang on 04/01/2017.
 */
public class LookupTask implements Callable<String> {

    String line;

    public LookupTask(String line) {
        this.line = line;
    }

    @Override
    public String call() throws Exception {
        int index = line.indexOf(' ');
        String address = line.substring(0, index);
        String theRest = line.substring(index);
        String hostname = InetAddress.getByName(address).getHostName();
        return hostname + " " + theRest;
    }
}
