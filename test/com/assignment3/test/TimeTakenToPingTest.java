package com.assignment3.test;

import com.assignment3.main.TimeTakenToPing;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TimeTakenToPingTest {
    @Test
    public void getTimeTakenToPingLocalTest(){
        try {
            Assert.assertEquals(true,TimeTakenToPing.getTimeTakenToPing("127.0.0.1")>0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTimeTakenToPingUnreachableHostTest(){

        try {
            Assert.assertEquals(-1,TimeTakenToPing.getTimeTakenToPing("1.1.1.1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IOException.class)
    public void getTimeTakenToPingThrowsException() throws IOException {
        TimeTakenToPing.getTimeTakenToPing("..");
    }
}
