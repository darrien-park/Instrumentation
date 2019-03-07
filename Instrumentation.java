package com.company;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.io.PrintStream;

class Instrumentation {
    //Singleton Design Pattern--------------------------------------------------------------------
    //create object for Instrumentation
    private static Instrumentation instance = new Instrumentation();

    //make constructor private so class cannot be instantiated
    private Instrumentation(){}

    //get only object available
    public static Instrumentation Instance(){
        return instance;
    }


    //Class Description---------------------------------------------------------------------------

    //global variables and resources
    boolean isActivated = false;
    int spacing = 0;
    Stack startTimes = new Stack();

    //Start timing method
    public void startTiming(String comment){

        //check for activation of instrumentation
        if (isActivated) {

            //Print
            String prefix = prefix();
            System.out.println(prefix + "STARTTIMING: " + comment);

            //Determine start time and push to stack
            long startTime = System.currentTimeMillis();
            startTimes.push(startTime);

            //update spacing value for later
            spacing = startTimes.size();
        }
    }

    //Stop timing method
    public void stopTiming(String comment){

        //check for activation of instrumentation
        if (isActivated) {

            //determine stop time and compute execution time of most recently encapsulated activity
            long stopTime = System.currentTimeMillis();
            long totalTime = (stopTime - (long) startTimes.peek());

            //pop so that next calculated execution time can be for outer wrap
            startTimes.pop();

            //update spacing and print
            spacing = startTimes.size();
            String prefix = prefix();
            System.out.println(prefix + "STOPTIMING: " + comment + " " + totalTime + "ms");
        }
    }

    //Comment method
    public void comment(String comment){

        //check for activation of instrumentation
        if (isActivated) {
            String prefix = prefix();
            System.out.println(prefix + "COMMENT: " + comment);
        }
    }

    //Dump method
    public static void dump(String filename){

        try {
            PrintStream log = new PrintStream(new File("/Users/darrienpark/Desktop/" + filename));
            System.setOut(log);
            log.print("hello java");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Activate method
    public void activate(boolean onoff){
        if (onoff == true)
            isActivated = true;
        else
            isActivated = false;
    }

    //Extra utility functions---------------------------------------------------------------------
    public String prefix(){
        String p = "";
        if(spacing != 0){
            p = "| ";
            for (int i = 0; i < spacing - 1; i++)
                p += "| ";
        }
        return p;
    }
}