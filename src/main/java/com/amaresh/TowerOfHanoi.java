package com.amaresh;

public class TowerOfHanoi {

    public void moveDiscs(int n, String A, String C, String B) {
        if(n == 0) {
            return;
        } else {
            //move top from A to B.
            moveDiscs(n-1, A, B, C);
            System.out.println("disc " + n + " from " + A + " to " + C );
            
            //move next from B to C.
            moveDiscs(n-1, B, C, A);
        }
        
    }
}
