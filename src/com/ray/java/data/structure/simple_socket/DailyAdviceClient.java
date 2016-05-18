package com.ray.java.data.structure.simple_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by dangdang on 5/17/16.
 */
public class DailyAdviceClient {


    public static void main(String args[]){

        DailyAdviceClient adviceClient = new DailyAdviceClient();
        adviceClient.go();
        
    }

    private void go() {

        try {
            Socket s = new Socket("127.0.0.1", 4242);

            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader bis = new BufferedReader(isr);
            String advice = bis.readLine();

            System.out.println(advice);

            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
