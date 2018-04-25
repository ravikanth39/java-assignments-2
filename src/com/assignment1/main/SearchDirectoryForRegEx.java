package com.assignment1.main;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * This class takes a regular expression in string format as input
 * then searches the home directory and all the sub directories for
 * files whose name matches the given RegEx
 */

public class SearchDirectoryForRegEx {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int loopCounter =1;

        //while loop to keep running the application until user stops it
        while (loopCounter==1){
            String givenRegex;
            System.out.println("Enter the regular expression");
            givenRegex = scan.next();
            Pattern compiledRegexPattern = null;

            //trying to compile the given regular expression into an pattern
            try{
                compiledRegexPattern = Pattern.compile(givenRegex);
            }catch (PatternSyntaxException ex){
                System.out.println("Given regular expression is invalid");
                ex.printStackTrace();
            }

            //checking if the home folder path is valid
            try{
                if(new File("/home/zemoso").exists()){
                    printMatching(new File("/home/zemoso"),compiledRegexPattern);
                }else{
                    throw new FileNotFoundException("given path does not Exist");
                }
            } catch (FileNotFoundException ex){
                ex.printStackTrace();
            }

            //Asking user to continue or not
            System.out.println("to continue enter 1 or 0 to stop");
            try{
                loopCounter=scan.nextInt();
                while(loopCounter!=0 && loopCounter!=1){
                    System.out.println("Input should be 1 or 0 please re-enter");
                    loopCounter=scan.nextInt();
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input,input should be either 1 or 0");
                e.printStackTrace();
            }

        }
        scan.close();
    }

    /**
     * function that takes the File object and searches through it by using the defined
     * filters to find the files that match the given pattern
     * @param directory File object of the Folder which should be searched
     * @param compiledRegexPattern compiled pattern of Regular expression given by user
     */
    public static void printMatching(File directory,Pattern compiledRegexPattern) {

        //defining the required filters to identify the file and sub directories in the given directory
        FilenameFilter subDirectoriesFilter = new FilenameFilter() {
            public boolean accept(File dir,String name) {
                return new File(dir,name).isDirectory();
            }
        };

        FilenameFilter regexFilter  = new FilenameFilter(){
            public boolean accept(File dir,String name) {

                return compiledRegexPattern.matcher(name).matches();
            }
        };

        //applying the filters to the given directory and storing the respective results
        File[] subDirectories = directory.listFiles(subDirectoriesFilter);
        String[] files = directory.list(regexFilter);

        //printing the collected files
        if(files!=null)  {
            for(int i=0;i<files.length;i++) {
                String fileName = files[i];
                System.out.println(fileName+"   "+new File(fileName).getAbsolutePath());
            }
        }

        //if any subdirectories are present also searching through them recursively
        if(subDirectories !=null) {
            for(int i=0;i<subDirectories.length;i++) {
                printMatching(subDirectories[i],compiledRegexPattern);
            }
        }
    }

}
