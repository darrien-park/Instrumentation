package com.company;
import java.util.*;

public class Test {
    Instrumentation ins = Instrumentation.Instance();

    public void BubbleSort(int size){
        int[] bArray = populateArray(size);
        BubbleSort2Algorithm bSort = new BubbleSort2Algorithm();
        bSort.sort(bArray);
    }

    public void QuickSort(int size){
        int[] qArray = populateArray(size);
        NaiveQuickSortAlgorithm qSort = new NaiveQuickSortAlgorithm();
        qSort.sort(qArray);
    }

    public void MergeSort(int size){
        int[] mArray = populateArray(size);
        ExtraStorageMergeSortAlgorithm mSort = new ExtraStorageMergeSortAlgorithm();
        mSort.sort(mArray);

    }

    public void SelectionSort(int size){
        int[] sArray = populateArray(size);
        SelectionSortAlgorithm sSort = new SelectionSortAlgorithm();
        sSort.sort(sArray);
    }

    public int[] populateArray(int size) {
        ins.startTiming("populateArray()");
        int[] array = new int[size];

        Random random = new Random();
        int low = 1;
        int high = 99999;

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(high - low +1) + low;
        }

        ins.stopTiming("populateArray()");
        return array;
    }

    //Standard print method for an array
    public void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }

        //line break
        System.out.println("");
    }
}
