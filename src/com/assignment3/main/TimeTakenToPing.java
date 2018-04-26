package com.assignment3.main;

import java.io.IOException;

import java.util.Scanner;

import java.net.InetAddress;


/**
 * This class takes the host ip address as string and then tries to ping
 * the host and outputs the time taken to ping if host is reachable
 */
public class TimeTakenToPing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //taking host IP address
        System.out.println("enter the host IP address");
        String host = scan.next();
        long timeTakenToPing = 0;

        //trying to ping the host through support function catching
        // any execption thrown by it
        try {
            timeTakenToPing = getTimeTakenToPing(host);
        } catch (IOException e) {
            e.printStackTrace();
            timeTakenToPing =-1;
        }
        if (timeTakenToPing > 0) {
            System.out.println("Time Taken to ping " + timeTakenToPing + " milli seconds");
        } else {
            System.out.println("Unable to reach the Host");
        }
        scan.close();
    }

    /**
     * this function takes an ip address as a stirng as input and tries to ping host using
     * InetAdress methods and calculates the time taken to ping the host
     * @param hostIPAddress IP address of the host in string format
     * @return returns a long which is the time taken to ping host
     * @throws IOException if the host is unknown or  not reachable
     */
    public static long getTimeTakenToPing(String hostIPAddress) throws IOException {
        long timeBeforePing = System.currentTimeMillis();

        //trying to ping host if not reachable returns -1
        if(!InetAddress.getByName(hostIPAddress).isReachable(5000)){
            return -1;
        }
        return System.currentTimeMillis()-timeBeforePing;
    }
}
