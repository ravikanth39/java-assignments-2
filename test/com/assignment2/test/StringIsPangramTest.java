package com.assignment2.test;

import com.assignment2.main.StringIsPangram;
import org.junit.Assert;
import org.junit.Test;

public class StringIsPangramTest {
   @Test
   public void checkIfPangramFalseCase(){
      Assert.assertEquals(false,StringIsPangram.checkIfPangram("Fail Case"));
   }

   @Test
   public void checkIfPangramTrueCase(){
      Assert.assertEquals(true,StringIsPangram.checkIfPangram("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"));
   }

   @Test
   public void checkIfPangramEmptyStringCase(){
      Assert.assertEquals(false,StringIsPangram.checkIfPangram(""));
   }

   @Test
   public void checkIfPangramNullCase(){
      String testing =null;
      Assert.assertEquals(false,StringIsPangram.checkIfPangram(testing));
   }
}
