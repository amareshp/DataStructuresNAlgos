package com.amaresh.fb;

import java.util.EmptyStackException;
import java.util.Stack;

public class StringFunctions {

    String input = null;
    public StringFunctions(String str) {
        input = str;
    }
    
    public int findDepth() {
        Stack<Character> stack = new Stack<Character>();
        int depth = 0;
        int startIndex = input.indexOf("{");
        if(startIndex < 0) return -1;
        stack.push( input.charAt(startIndex) );
        int index = startIndex + 1;
        
        while( index < input.length() ) {
            Character c = input.charAt(index); 
            if( c == '{' ) {
                stack.push(c);
            }
            if(c == '}') {
                try {
                    stack.pop();
                } catch(EmptyStackException ex) {
                    System.out.println("curly braces not terminated properly.");
                    return -1;
                }
            }
            depth = (stack.size() > depth) ? stack.size() : depth;
            index++;
        }
        if( stack.isEmpty() ) {
            return depth;
        } else {
            System.out.println("curly braces not terminated properly.");
            return -1;
        }
    }
}
