package com.assignment4.test;

import com.assignment4.main.FindRangeToFillForm;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * class to test the printFormFillRange function of FindRangeToFillForm class
 */
public class FindRangeToFillFormTest {

    //test case when range can be found but is less than 30 days
    @Test
    public void printFormFillRangeTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput ="16-06-2017 27-06-2017\n";
        FindRangeToFillForm.printFormFillRange("16-07-1998","27-06-2017");
        Assert.assertEquals(expectedOutput,outContent.toString());
    }

    //test case when the sign-up date is after current date
    @Test
    public void printFormFillRangeNoRangeTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput ="No Range\n";
        FindRangeToFillForm.printFormFillRange("04-05-2017","04-04-2017");
        Assert.assertEquals(expectedOutput,outContent.toString());
    }

    //test case for normal range
    @Test
    public void printFormFillRangeNormalTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput ="14-01-2017 15-03-2017\n";
        FindRangeToFillForm.printFormFillRange("13-02-1998","27-06-2017");
        Assert.assertEquals(expectedOutput,outContent.toString());
    }

    //test case for 1st anniversary
    @Test
    public void printFormFillRangeCloseToEndTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput ="05-03-2016 15-03-2016\n";
        FindRangeToFillForm.printFormFillRange("04-04-2015","15-03-2016");
        Assert.assertEquals(expectedOutput,outContent.toString());
    }

    //test case when current date is in the sign up year so NO RANGE as not an anniversary
    @Test
    public  void printFormFillRangeSameYearTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput ="No Range\n";
        FindRangeToFillForm.printFormFillRange("04-02-2017","04-04-2017");
        Assert.assertEquals(expectedOutput,outContent.toString());
    }
}
