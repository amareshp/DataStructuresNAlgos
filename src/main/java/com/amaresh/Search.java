package com.amaresh;

import java.util.Arrays;

public class Search {
    
    public boolean binarySearch(int[] input, int searchInt) {
        boolean found = false;
        int startIndex = 0;
        int endIndex = input.length - 1;
        printArray(input);
        while(true) {
            int midIndex = (startIndex + endIndex) / 2;
            if(startIndex == endIndex) {
                if(input[midIndex] == searchInt) {
                    found = true;
                } else {
                    found = false;
                }
                break;
            }
            
            if(input[midIndex] == searchInt) {
                found = true;
                break;
            } else if(input[midIndex] < searchInt) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
            printArray(input, startIndex, endIndex);
        }
        if(found) {
            System.out.println("Found: " + searchInt);
        } else {
            System.out.println("Not found: " + searchInt);
        }
        return found;
    }
    
    public int findPosition(int[] input, int element) {
        int insertAt = -5;
        int startIndex = 0;
        int endIndex = input.length - 1;
        int midIndex = (startIndex + endIndex) / 2;
        printArray(input);
        while(true) {
            midIndex = (startIndex + endIndex) / 2;
            System.out.println("Start index: " + startIndex + " End index: " + endIndex + " Mid index: " + midIndex + " Element at mid: " + input[midIndex]);
            if(startIndex == endIndex) {
                if(input[midIndex] < element) {
                    insertAt = midIndex + 1;
                } else {
                    insertAt = midIndex;
                }
                break;
            }
            
            if(input[midIndex] < element) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
            printArray(input, startIndex, endIndex);
        }
        return insertAt;
    }
    
    public static void printArray(int[] input, int startIndex, int endIndex) {
        for(int i = 0; i < startIndex; i++) {
            System.out.print("..");
            for(int j=0; j<numDigits(input[i]); j++) {
                System.out.print(".");
            }
        }
        System.out.println( Arrays.toString(Arrays.copyOfRange(input, startIndex, endIndex + 1)) );
    }
    public static void printArray(int[] input) {
        System.out.println( Arrays.toString(input) );
    }
    public static int numDigits(int num) {
        if(num == 0) {
            return 1;
        }
        int digits = 0;
        while(num > 0) {
            digits++;
            num = num / 10;
        }
        return digits;
    }

}
