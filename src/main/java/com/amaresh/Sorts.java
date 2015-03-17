package com.amaresh;

import java.util.Arrays;

public class Sorts {
    /**
     * worst case - 4 * (1 + 2 + 3 + .... + n-1) = 2 * n * (n-1) = 2n^2 - 2n
     * largest bubbles up to the end.
     * @param input
     * @return
     */
    public int[] bubbleSort(int[] input) {
        for (int i = input.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (input[j] > input[j + 1]) {
                    swap(input, j, j + 1);
                }
            }
        }
        return input;
    }

    public int[] selectionSort(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[minIndex] > input[j]) {
                    minIndex = j;
                }
            }
            swap(input, i, minIndex);
        }
        return input;
    }

    public int[] insertionSort(int[] input) {
        System.out.println("input array: " + Arrays.toString(input));
        for (int i = 1; i < input.length; i++) {
            int current = input[i];
            int j = i - 1;
            while ((j >= 0) && (input[j] > current)) {
                input[j + 1] = input[j];
                System.out.println("i=" + i + ", j=" + j + ", array: " + Arrays.toString(input));
                j--;
            }
            input[j + 1] = current;
            System.out.println("i=" + i + ", j=" + j + ", array: " + Arrays.toString(input));
        }
        return input;
    }

    /**
     * Search for an element in an ordered array
     */
    public int findElement(int[] input, int x, int startIndex, int endIndex) {
        if(startIndex == endIndex) {
            if(input[startIndex] == x) {
                return startIndex;
            } else {
                System.out.println("Element not found. Closest index: " + startIndex + " value: " + input[startIndex]);
                return -1;
            }
        } else {
            int mid = (startIndex + endIndex) / 2;
            System.out.println("Start index: " + startIndex + " endIndex: " + endIndex + " mid: " + mid + " element at mid: " + input[mid]);
            if(x == input[mid]) {
                return mid;
            } else if (x < input[mid]){
                endIndex = mid;
            } else {
                startIndex = mid + 1;
            }
            System.out.println("Start index: " + startIndex + " endIndex: " + endIndex);
            return findElement(input, x, startIndex, endIndex);
        }
    }
    
    public void mergeSort(int[] input, int startIndex, int endIndex) {
        if( startIndex < endIndex ) {
        int midIndex = (int) Math.floor( (startIndex + endIndex) / 2 );
        System.out.println("Sorting: ");
        Search.printArray(input, startIndex, midIndex);
        mergeSort(input, startIndex, midIndex);
        System.out.println("Sorting: ");
        Search.printArray(input, midIndex+1, endIndex);
        mergeSort(input, midIndex+1, endIndex);
        System.out.println("Merging: ");
        Search.printArray(input, startIndex, endIndex);
        merge(input, startIndex, midIndex, endIndex);
        System.out.println("After Merge: ");
        Search.printArray(input, startIndex, endIndex);
        }
    }
    
    int[] getArrayPart(int[] input, int startIndex, int endIndex) {
        int[] arrayPart = new int[endIndex - startIndex + 1];
        for(int i=0; i<arrayPart.length; i++) {
            arrayPart[i] = input[startIndex + i];
        }
        return arrayPart;
    }
    
    public void merge(int[] input, int startIndex, int midIndex, int endIndex) {
        int[] left = new int[midIndex - startIndex + 1];
        int[] right = new int[endIndex - midIndex];
        for(int i=0; i<left.length; i++) {
            left[i] = input[startIndex + i];
        }
        for(int i=0; i<right.length; i++) {
            right[i] = input[midIndex + 1 + i];
        }
        int j=0, k=0;
        for(int i=startIndex; i<=endIndex; i++) {
            if( (k >= right.length) || ((left[j] < right[k]) && (j < left.length)) ) {
                input[i] = left[j];
                j++;
            } else {
                input[i] = right[k];
                k++;
            }
        }
    }
    
    public void quickSort(int[] input, int startIndex, int endIndex) {
        if(startIndex < endIndex) {
            int pivot = partition(input, startIndex, endIndex);
            quickSort(input, startIndex, pivot-1);
            quickSort(input, pivot+1, endIndex);
        }
    }
    //returns the index of the pivot element - initially the last element.
    public int partition(int[] input, int startIndex, int endIndex) {
        int i = startIndex;
        int pivot = input[endIndex];
        for(int j = startIndex; j < endIndex; j++) {
            if(input[j] <= pivot) {
                swap(input, i, j);
                i++;
            }
        }
        swap(input, i, endIndex);
        return i;
    }
    
    public int[] swap(int[] input, int i, int j) {
        if (i == j) {
            return input;
        }
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
        return input;
    }

}
