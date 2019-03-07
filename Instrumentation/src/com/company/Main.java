package com.company;

public class Main {
    //Custom test program that I created for debugging
    /*
    public static void main(String[] args) {
        Instrumentation ins = Instrumentation.Instance();
        ins.activate(true);
        ins.startTiming("main");
        ins.startTiming("loop");
        for (int i = 0; i < 100000; i++){
            int j = i;
        }
        ins.comment("This is an example of a comment!");
        ins.startTiming("loop 2");
        for (int i = 0; i < 100000; i++){
            int j = i;
        }
        ins.stopTiming("loop 2");
        ins.stopTiming("loop");

        ins.startTiming("loop 3");
        for (int i = 0; i < 100000; i++){
            int j = i;
        }
        ins.stopTiming("loop 3");
        ins.comment("This is another example of a comment!");
        ins.stopTiming("main");
        ins.dump("output.log");
        */

    /*
    public static void main(String[] args) {
        Instrumentation ins = Instrumentation.Instance();
        ins.activate(true);
        ins.startTiming("main");
        ins.startTiming("loop");
        for(int i = 0; i < 5; i++){
            doSomeStuff();
        }
        ins.stopTiming("loop");
        ins.comment("this is an example of a comment!");
        ins.stopTiming("main");
        ins.dump("Output.log");
    }

    static void doSomeStuff(){
        Instrumentation ins = Instrumentation.Instance();
        ins.startTiming("doSomeStuff()");
        System.out.println("Hello there!");
        ins.stopTiming("doSomeStuff()");
    }
    */
    public static void main(String[] args) {
        Instrumentation ins = Instrumentation.Instance();
        ins.activate(true);

        //open main
        ins.startTiming("main");

        Test test = new Test();

        // Bubble Sort
        ins.startTiming("Bubble Sort");
        test.BubbleSort(10000);
        ins.stopTiming("Bubble Sort");

        //Quick Sort
        ins.startTiming("Quick Sort");
        test.QuickSort(10000);
        ins.stopTiming("Quick Sort");

        //MergeSort
        ins.startTiming("Merge Sort");
        test.MergeSort(10000);
        ins.stopTiming("Merge Sort");

        //SelectionSort
        ins.startTiming("Selection Sort");
        test.SelectionSort(10000);
        ins.stopTiming("Selection Sort");

        //close main
        ins.stopTiming("main");

        //dump to log
        ins.dump("Output.log");
    }



}