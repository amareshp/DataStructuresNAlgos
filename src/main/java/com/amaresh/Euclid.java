package com.amaresh;


public class Euclid {

    public int gcd(int x, int y) {
        if(x == 0 && y == 0) {
            return -1;
        }
        System.out.println("Finding gcd of: " + x + ", " + y);
        if(y == 0) {
            return x;
        }
        return gcd(y, (x % y));
    }
}
