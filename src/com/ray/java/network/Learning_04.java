package com.ray.java.network;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by dangdang on 30/12/2016.
 */
public class Learning_04 {

    private static final String BLACKHOLE = "baidu.com";

    public static void main(String[] args) {
//        geAddressName();
        webLog(args);
    }


    private static void geAddressName() {
        try {
            InetAddress[] addresses = InetAddress.getAllByName("baidu.com");
            for (InetAddress address : addresses) {
                System.out.println("address-IP: " + address);
                isSpammer(address.getHostAddress());
            }
//            InetAddress me = InetAddress.getLocalHost();
//            System.out.println("me: " + me);
        } catch (UnknownHostException e) {
            System.out.println("could not find baidu.com");
        }

    }

    private static void isSpammer(String arg) {
        try {
            InetAddress address = InetAddress.getByName("baidu.com");
            byte[] quad = address.getAddress();
            String query = BLACKHOLE;
            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }
            InetAddress.getByName(query);
            System.out.println("arg = [" + arg + "], is known spammer.");
        } catch (UnknownHostException e) {
            System.out.println("arg = [" + arg + "], appears legitimate.");
        }
    }

    private static void webLog(String[] arg) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(arg[0])))) {
            for (String entry = reader.readLine(); entry != null; entry = reader.readLine()) {
                int index = entry.indexOf(' ');
                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);

                InetAddress address = InetAddress.getByName(ip);
                System.out.println(address.getHostName() + theRest);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
