package com.amaresh;

import java.util.Arrays;

import org.testng.annotations.Test;

public class SortsTest {

    //@Test
    public void bubbleSortTest() {
        int[] input = { 9, 4, 8, 3, 7, 1, 6 };
        int[] output = new Sorts().bubbleSort(input);
        System.out.println(Arrays.toString(output));
    }

    // @Test
    public void insertionSortTest() {
        int[] input = { 9, 4, 8, 3, 7, 1, 6 };
        int[] output = new Sorts().insertionSort(input);
        System.out.println(Arrays.toString(input));
    }

    //@Test
    public void selectionSortTest() {
        int[] input = { 9, 4, 8, 3, 7, 1, 6 };
        int[] output = new Sorts().selectionSort(input);
        System.out.println(Arrays.toString(input));
    }

    //@Test
    public void mergeSortTest() {
        int[] input = { 9, 4, 8, 3, 7, 1, 6 };
        //new Sorts().mergeSort(input, 0, input.length -1);
        new MyAlgorighm().mergeSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }

    @Test
    public void quickSortTest() {
        int[] input = { 9, 4, 8, 3, 7, 1, 6 };
        //new QuickSorter().sort(input, 0, input.length -1);
        new Sorts().quickSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }
    
    //@Test
    public void findElementTest() {
        int[] input = { 1, 3, 7, 10, 15, 19, 25, 32, 39, 45, 50, 54, 59, 67 };
        Search.printArray(input);
        
        int index = new Sorts().findElement(input, 3, 0, input.length-1);
        System.out.println("Index of 3 is: " + index + "\n");

        index = new Sorts().findElement(input, 55, 0, input.length-1);
        System.out.println("Index of 55 is: " + index + "\n");
        
        index = new Sorts().findElement(input, 11, 0, input.length-1);
        System.out.println("Index of 11 is: " + index + "\n");

        index = new Sorts().findElement(input, 0, 0, input.length-1);
        System.out.println("Index of 0 is: " + index + "\n");
        
        index = new Sorts().findElement(input, 100, 0, input.length-1);
        System.out.println("Index of 100 is: " + index + "\n");
        
        index = new Sorts().findElement(input, 54, 0, input.length-1);
        System.out.println("Index of 9 is: " + index + "\n");
        
        index = new Sorts().findElement(input, 1, 0, input.length-1);
        System.out.println("Index of 1 is: " + index + "\n");
        
        index = new Sorts().findElement(input, 7, 0, input.length-1);
        System.out.println("Index of 8 is: " + index + "\n");
    }
    
}
