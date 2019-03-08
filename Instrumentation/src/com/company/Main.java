package com.company;

public class Main {

    public static void main(String[] args) {
        Instrumentation ins = Instrumentation.Instance();
        ins.activate(true);

        //open main
        ins.startTiming("main");

        Test test = new Test();

        ins.startTiming("overhead");
        ins.stopTiming("overhead");

        // Bubble Sort
        //ins.startTiming("Bubble Sort"); - instrumentation enabled in bubble sort class to reduce overhead
        test.BubbleSort(10000);
        //ins.stopTiming("Bubble Sort");

        //Quick Sort
        //ins.startTiming("Quick Sort");
        test.QuickSort(10000);
        //ins.stopTiming("Quick Sort");

        //MergeSort
        //ins.startTiming("Merge Sort");
        test.MergeSort(10000);
        //ins.stopTiming("Merge Sort");

        //SelectionSort
        //ins.startTiming("Selection Sort");
        test.SelectionSort(10000);
        //ins.stopTiming("Selection Sort");

        //close main
        ins.stopTiming("main");

        //dump to log
        ins.dump("Question6.log");
    }



}
