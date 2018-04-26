package com.assignment4.main;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;

import java.util.Scanner;

/**
 * This class takes 2 dates as strings as Input one sign-up date and another
 * current date and out puts the range of days we can fill the form in the current
 * year
 *
 */
public class FindRangeToFillForm {
   public static  void main(String[] args){
       Scanner scan = new Scanner(System.in);
       String signUpDate,currentDate;

       //getting the dates
       signUpDate = scan.next();
       currentDate =scan.next();

       //passing the dates to support function to calculate range
       printFormFillRange(signUpDate,currentDate);

       scan.close();

   }

    /**
     * This function takes sign-up date and current date and finds the range of days to fill the
     * form in the current year else dispalys No range
     * @param signUpDate the date at which user signed up
     * @param currentDate the current date
     * @throws DateTimeParseException throws this exception when given dates cannot be parsed into LocaleDate objects
     * @throws NullPointerException if the LocalDate objects are null then it throws this exception
     */

   public static void printFormFillRange(String signUpDate,String currentDate) {

       //The given Date format
       DateTimeFormatter givenDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
       LocalDate signUpDateObject=null;
       LocalDate currentDateObject=null;

       //parsing the given dates into Date objects using the  date-time-formater
       try{
           signUpDateObject = LocalDate.parse(signUpDate,givenDateFormat);
           currentDateObject = LocalDate.parse(currentDate,givenDateFormat);
       }catch (DateTimeParseException e){
           e.printStackTrace();
           System.out.println("desired date format is dd-MM-yyyy");
       }

       //extracting respective years from current Date and sign-up Date
       int currentYear=0;
       int signUpYear=0;
       //try catch to check if the LocaleDateObject where no Initialised
       try{
           currentYear= currentDateObject.getYear();
           signUpYear= signUpDateObject.getYear();
       } catch (NullPointerException e){
           e.printStackTrace();
           System.out.println("the Locale Date objects where not initialised");
       }


       //checking if sign-up Date is int he future or if this is the sign-up year if yes then no range
       if(signUpDateObject.isAfter(currentDateObject) || currentYear==signUpYear){
           System.out.println("No Range");
           return;
       }

       //forming the range by adding and substracting to the sign-up date in current year
       LocalDate beforeSignUpDate = signUpDateObject.plusYears(currentYear-signUpYear).minusDays(30);
       LocalDate afterSignUpDate = signUpDateObject.plusYears(currentYear-signUpYear).plusDays(30);

       //checking if the deadline is int he future if yes setting current date as deadline
       if(afterSignUpDate.isAfter(currentDateObject)){
           afterSignUpDate =currentDateObject;
       }
       //printing the range in give date format
       System.out.println(givenDateFormat.format(beforeSignUpDate)+" "+givenDateFormat.format(afterSignUpDate));

   }

}
