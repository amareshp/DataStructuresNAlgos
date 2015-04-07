package com.amaresh.fb;

import org.testng.annotations.Test;

import com.amaresh.Search;

public class MyTest {

    @Test
    public void bubbleTest() {
        int[] input = new int[] {9, 5, 2, 1, 8, 3, 4, 7};
        System.out.println("Unsorted Array: " );
        Search.printArray(input);
        insertionSort(input);
        System.out.println("Sorted Array: ");
        Search.printArray(input);
    }

    public void insertionSort(int[] input) {
        for(int i = 1; i < (input.length); i++) {
            int current = input[i];
            for(int j = i - 1; j >= 0; j--) {
                if(current < input[j]) {
                    input[j+1] = input[j];
                    input[j] = current;
                } else {
                    break;
                }
            }
        }
    }
    
}
