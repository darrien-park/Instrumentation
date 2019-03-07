package com.company;
import java.io.*;
import java.util.*;

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
    ArrayList<String> output = new ArrayList<String>();

    //Start timing method
    public void startTiming(String comment){

        //check for activation of instrumentation
        if (isActivated) {

            //formatting
            String prefix = prefix();
            String line = prefix + "STARTTIMING: " + comment;

            //add to output stream
            output.add(line);

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

            //update spacing and formatting
            spacing = startTimes.size();
            String prefix = prefix();
            String line = prefix + "STOPTIMING: " + comment + " " + totalTime + "ms";

            //add to output stream
            output.add(line);
        }
    }

    //Comment method
    public void comment(String comment){

        //check for activation of instrumentation
        if (isActivated) {

            //determine correct formatting
            String prefix = prefix();
            String line = prefix + "COMMENT: " + comment;

            //add to output stream
            output.add(line);
        }
    }

    //Dump method
    public void dump(String filename){

        try {

            //print to output stream (i.e. log file) -- change path for each unique machine
            PrintStream log = new PrintStream(new FileOutputStream(filename));
            System.setOut(log);
            for (int i = 0; i < output.size(); i++) {
                log.println(output.get(i));
            }
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
