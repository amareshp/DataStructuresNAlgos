package com.amaresh;

import java.util.Arrays;

public class MultiStack {
    private int[] stackArray;
    private int[] top;
    private int[] next;
    private int maxNoOfElements;
    private int stacks;
    private int nextFreeIndex;

    public MultiStack(int maxNoOfElements, int stacks) {
        this.maxNoOfElements = maxNoOfElements;
        this.stacks = stacks;
        this.stackArray = new int[maxNoOfElements];
        this.next = new int[maxNoOfElements];
        for(int i = 0; i < (maxNoOfElements - 1); i++) {
            this.next[i] = i+1;
        }
        this.nextFreeIndex = 0;
        this.next[maxNoOfElements - 1] = -1;
        this.top = new int[stacks];
        for(int i = 0; i < stacks; i++) {
            this.top[i] = -1;
        }
    }
    
    public boolean isFull() {
        return (this.nextFreeIndex == -1);
    }
    
    public boolean isEmpty(int stackNo) {
        return (this.top[stackNo] == -1);
    }
    
    public void push(int element, int stackNo) {
        if( isFull() ) {
            throw new StackOverflowError("Stack is full.");
        }
        System.out.println("push: " + element + " in stack: " + stackNo);
        System.out.println("Stack array before push: " + Arrays.toString(stackArray));
        System.out.println("Next array before push: " + Arrays.toString(next));
        System.out.println("Top array before push: " + Arrays.toString(top));
        System.out.println("Inserting " + element + " in stackArray at position: " + nextFreeIndex);
        stackArray[nextFreeIndex] = element;
        int i = nextFreeIndex;
        nextFreeIndex = next[i];
        System.out.println("Next free index: " + nextFreeIndex);
        System.out.println("Inserting previous top for stack no " + stackNo + " in next array at position: " + i);
        next[i] = top[stackNo];  //store the index of previous top in next
        System.out.println("Index of top for stack no " + stackNo + ": " + i);
        top[stackNo] = i;
        System.out.println("Stack array after push: " + Arrays.toString(stackArray));
        System.out.println("Next array after push: " + Arrays.toString(next));
        System.out.println("Top array after push: " + Arrays.toString(top));
    }
    
    public int pop(int stackNo) {
        if( isEmpty(stackNo) ) {
            System.out.println("Stack empty.");
            return -9999;
        }
        System.out.println("Stack array before pop: " + Arrays.toString(stackArray));
        System.out.println("Next array before pop: " + Arrays.toString(next));
        System.out.println("Top array before pop: " + Arrays.toString(top));
        int i = top[stackNo];
        System.out.println("Index of top element for stack no " + stackNo + ": " + i);
        top[stackNo] = next[i];
        System.out.println("Index of next top element for stack no " + stackNo + ": " + i);
        next[i] = nextFreeIndex;
        nextFreeIndex = i;
        System.out.println("Stack array after pop: " + Arrays.toString(stackArray));
        System.out.println("Next array after pop: " + Arrays.toString(next));
        System.out.println("Top array after pop: " + Arrays.toString(top));
        return stackArray[i];
    }
}
