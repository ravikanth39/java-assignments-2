package com.assignment3.test;

import com.assignment3.main.TimeTakenToPing;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Class to test the getTimeTakenToPing() function of TimeTakenToPing class
 */

public class TimeTakenToPingTest {

    //test case for local host should output a positive time
    @Test
    public void getTimeTakenToPingLocalTest(){
        try {
            Assert.assertEquals(true,TimeTakenToPing.getTimeTakenToPing("127.0.0.1")>0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //test case when host is unrechable
    @Test
    public void getTimeTakenToPingUnreachableHostTest(){

        try {
            Assert.assertEquals(-1,TimeTakenToPing.getTimeTakenToPing("1.1.1.1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //test case when host address is invalid
    @Test(expected = IOException.class)
    public void getTimeTakenToPingThrowsException() throws IOException {
        TimeTakenToPing.getTimeTakenToPing("..");
    }
}
