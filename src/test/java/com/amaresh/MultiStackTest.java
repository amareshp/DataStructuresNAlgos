package com.amaresh;

import java.util.Arrays;

import org.testng.annotations.Test;

public class MultiStackTest {

    @Test
    public void stackTest() {
        MultiStack stack = new MultiStack(10, 3);
        stack.push(11, 0);
        stack.push(12, 0);
        stack.push(13, 0);
        stack.push(21, 1);
        stack.push(22, 1);
        stack.push(23, 1);
        stack.push(31, 2);
        stack.push(32, 2);
        stack.push(33, 2);
        System.out.println("pop from stack 1: " + stack.pop(0));
        System.out.println("pop from stack 2: " + stack.pop(1));
        System.out.println("pop from stack 1: " + stack.pop(0));
        System.out.println("pop from stack 3: " + stack.pop(2));
        System.out.println("pop from stack 3: " + stack.pop(2));
        System.out.println("pop from stack 1: " + stack.pop(0));
        System.out.println("pop from stack 2: " + stack.pop(1));
        System.out.println("pop from stack 2: " + stack.pop(1));
        System.out.println("pop from stack 3: " + stack.pop(2));
    }
    
}
