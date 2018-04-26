package com.assignment2.test;

import com.assignment2.main.StringIsPangram;

import org.junit.Assert;
import org.junit.Test;

/**
 * class to test the checkIfPanagram function of StringIsPangram class
 */
public class StringIsPangramTest {

   //test case where string does not contain all alphabets
   @Test
   public void checkIfPangramFalseCase(){
      Assert.assertEquals(false,StringIsPangram.checkIfPangram("Fail Case"));
   }

   //test case where string contains all alphabets
   @Test
   public void checkIfPangramTrueCase(){
      Assert.assertEquals(true,StringIsPangram.checkIfPangram("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"));
   }

   //test case where string is empty
   @Test
   public void checkIfPangramEmptyStringCase(){
      Assert.assertEquals(false,StringIsPangram.checkIfPangram(""));
   }

   //test case where string is null it prints the stack trace and returns false
   @Test
   public void checkIfPangramNullCase(){
      String testing =null;
      Assert.assertEquals(false,StringIsPangram.checkIfPangram(testing));
   }
}
