package com.amaresh.p1;

import org.testng.annotations.Test;

import com.amaresh.Search;

public class SortsTest1 {

    @Test
    public void bubbleTest() {
        int[] input = new int[] {9, 5, 2, 1, 8, 3, 4, 7};
        System.out.println("Unsorted Array: " );
        Search.printArray(input);
        quickSort(input, 0, input.length - 1);
        System.out.println("Sorted Array: ");
        Search.printArray(input);
    }

    public void quickSort(int[] input, int start, int end) {
        if(start < end) {
            int pivot = partition(input, start, end);
            quickSort(input, 0, pivot-1);
            quickSort(input, pivot+1, end);
        }
        
    }
    public int partition(int[] input, int start, int end) {
        int pivot = end;
        int i = start;
        for(int j = start; j < end; j++) {
            if(input[j] <= input[pivot]) {
                swap(input, i, j);
                i++;
            }
        }
        swap(input, i, pivot);
        return i;
    }
    public void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    
    public void mergeSort(int[] input, int start, int end) {
        if(start == end) return;
        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid+1, end);
        merge(input, start, mid, end);
    }
    
    public void merge(int[] input, int start, int mid, int end) {
        if(start == end) return;
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];
        for(int i = 0; i < left.length; i++) left[i] = input[start + i];
        for(int i = 0; i < right.length; i++) right[i] = input[mid + 1 + i];
        int mergedSize = end - start + 1;
        int i = 0, j = 0;
        for(int k = 0; k < mergedSize; k++) {
            if(i > (left.length-1) || (j < right.length && right[j] < left[i]) ) {
                input[start+k] = right[j];
                j++;
            } else {
                input[start+k] = left[i];
                i++;
            }
        }
            
        
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
