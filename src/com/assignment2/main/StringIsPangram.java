package com.assignment2.main;


import java.util.Scanner;

/**
 * This class takes a string and check if the string contains all the letters
 * in the alphabets and displays the results accordingly
 */
public class StringIsPangram {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        //getting the Input string
        System.out.println("Input the given String");
        String givenString = scan.nextLine();

        //passing the string to function
        if(checkIfPangram(givenString)){
            System.out.println("The given String contains all 26 alphabets");
        }else{
            System.out.println("The given String does not contain all alphabets");
        }
        scan.close();
    }

    /**
     * this function takes an string as argument and checks if it contains all
     * alphabets by string.replaceall and regular expression
     * @param givenString is the string to check if it is pangram
     * @return returns true if it is pangram else false
     */
    public static boolean checkIfPangram(String givenString){

        //replacing all non alphabetical characters with empty characters using the regex
        try{
            givenString = givenString.replaceAll("[^a-zA-Z]","");
        } catch (NullPointerException ex){
            ex.printStackTrace();
            return false;
        }


        givenString = givenString.toLowerCase();

        //replacing all duplicated alphabets with empty characters using regex
        givenString = givenString.replaceAll("(.)(?=.*\\1)", "");

        //checking if the string contains all 26 characters
        return (givenString.length()==26);

    }
}
