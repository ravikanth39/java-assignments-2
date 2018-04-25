package com.assignment1.test;


import com.assignment1.main.SearchDirectoryForRegEx;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class SearchDirectoryForRegExTest {
    @Test
    public  void printMatchingTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput ="ravi   /home/zemoso/assignments/ravi\n" +
                "raju   /home/zemoso/assignments/raju\n" +
                "registry   /home/zemoso/assignments/registry\n" +
                "registry   /home/zemoso/assignments/registry\n" +
                "registry   /home/zemoso/assignments/registry\n" +
                "registry   /home/zemoso/assignments/registry\n" +
                "ru   /home/zemoso/assignments/ru\n" +
                "ro   /home/zemoso/assignments/ro\n" +
                "ru   /home/zemoso/assignments/ru\n" +
                "ro   /home/zemoso/assignments/ro\n" +
                "ru   /home/zemoso/assignments/ru\n" +
                "ro   /home/zemoso/assignments/ro\n" +
                "ru   /home/zemoso/assignments/ru\n" +
                "ro   /home/zemoso/assignments/ro\n" +
                "ru   /home/zemoso/assignments/ru\n" +
                "ro   /home/zemoso/assignments/ro\n" +
                "ru   /home/zemoso/assignments/ru\n" +
                "ro   /home/zemoso/assignments/ro\n" +
                "ru   /home/zemoso/assignments/ru\n" +
                "ro   /home/zemoso/assignments/ro\n" +
                "ru   /home/zemoso/assignments/ru\n" +
                "ro   /home/zemoso/assignments/ro\n" +
                "ru   /home/zemoso/assignments/ru\n" +
                "ro   /home/zemoso/assignments/ro\n" +
                "ru   /home/zemoso/assignments/ru\n" +
                "refs   /home/zemoso/assignments/refs\n" +
                "refs   /home/zemoso/assignments/refs\n" +
                "remotes   /home/zemoso/assignments/remotes\n" +
                "remotes   /home/zemoso/assignments/remotes\n" +
                "ravi   /home/zemoso/assignments/ravi\n" +
                "registry   /home/zemoso/assignments/registry\n" +
                "rootfiles   /home/zemoso/assignments/rootfiles\n" +
                "rootfiles   /home/zemoso/assignments/rootfiles\n" +
                "rootfiles   /home/zemoso/assignments/rootfiles\n" +
                "refs   /home/zemoso/assignments/refs\n" +
                "refs   /home/zemoso/assignments/refs\n" +
                "remotes   /home/zemoso/assignments/remotes\n" +
                "remotes   /home/zemoso/assignments/remotes\n" +
                "resource_folder_cache   /home/zemoso/assignments/resource_folder_cache\n" +
                "registered   /home/zemoso/assignments/registered\n" +
                "relaxsymbolindex   /home/zemoso/assignments/relaxsymbolindex\n" +
                "refqueueindex   /home/zemoso/assignments/refqueueindex\n" +
                "readme   /home/zemoso/assignments/readme\n" +
                "rootpage   /home/zemoso/assignments/rootpage\n" +
                "rootpage   /home/zemoso/assignments/rootpage\n" +
                "rootpage   /home/zemoso/assignments/rootpage\n" +
                "root   /home/zemoso/assignments/root\n" +
                "recommenders   /home/zemoso/assignments/recommenders\n" +
                "rcp   /home/zemoso/assignments/rcp\n" +
                "rcp   /home/zemoso/assignments/rcp\n" +
                "readme   /home/zemoso/assignments/readme\n" +
                "rootfiles   /home/zemoso/assignments/rootfiles\n" +
                "repository   /home/zemoso/assignments/repository\n" +
                "root   /home/zemoso/assignments/root\n" +
                "repository   /home/zemoso/assignments/repository\n" +
                "recommenders   /home/zemoso/assignments/recommenders\n";
        String regularExpression = "r\\w+";
        SearchDirectoryForRegEx.printMatching(new File("/home/zemoso"),Pattern.compile(regularExpression));
        Assert.assertEquals(expectedOutput,outContent.toString());
    }

    @Test(expected = NullPointerException.class)
    public void printMatchingNullExceptionTest(){
        String regularExpression = null;
        SearchDirectoryForRegEx.printMatching(new File("/home/zemoso"),Pattern.compile(regularExpression));
    }

}
