package com.amaresh;

public class QuickSorter {
    
    public void sort(int[] input, int startIndex, int endIndex) {
        int pivotIndex = (startIndex + endIndex) / 2;
        int i = startIndex, j = endIndex;
        Search.printArray(input, startIndex, endIndex);
        while(i <= j) {
            while(input[i] < input[pivotIndex]) {
                i++;
            }
            while(input[j] > input[pivotIndex]) {
                j--;
            }
            if(i <= j) {
                swap(input, i, j);
                i++;
                j--;
            }
            if(startIndex < j) {
                sort(input, startIndex, j);
            }
            if(i < endIndex) {
                sort(input, i, endIndex);
            }
            
        }
    }
    
    public void swap(int[] input, int from, int to) {
        int temp = input[from];
        input[from] = input[to];
        input[to] = temp;
    }

}
