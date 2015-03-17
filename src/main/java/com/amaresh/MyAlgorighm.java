package com.amaresh;

import java.util.Arrays;

public class MyAlgorighm {

    public void mergeSort(int[] input, int startIndex, int endIndex) {
        if(startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            mergeSort(input, startIndex, mid);
            mergeSort(input, mid+1, endIndex);
            merge(input, startIndex, mid, endIndex);
        }
    }
    
    public void merge(int[] input, int startIndex, int mid, int endIndex) {
        int[] left = Arrays.copyOfRange(input, startIndex, mid+1);
        int[] right = Arrays.copyOfRange(input, mid+1, endIndex+1);
        int j=0, k=0;
        for(int i=startIndex; i<=endIndex; i++) {
            if(k >= right.length || (j < left.length && left[j] < right[k]) ) {
                input[i] = left[j];
                j++;
            } else {
                input[i] = right[k];
                k++;
            }
        }
    }
}
