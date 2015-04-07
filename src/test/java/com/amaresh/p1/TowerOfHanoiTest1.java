package com.amaresh.p1;

import org.testng.annotations.Test;

public class TowerOfHanoiTest1 {

    @Test
    public void moveDiscsTest() {
        moveDiscs(2, "A", "C", "B");
    }
    
    public void moveDiscs(int n, String A, String C, String B){
        if(n == 1) {
            System.out.println("Move disc from " + A + " to " + C);
            return;
        }
        moveDiscs(n-1, A, B, C);
        moveDiscs(1, A, C, B);
        moveDiscs(n-1, B, C, A);
    }
}
