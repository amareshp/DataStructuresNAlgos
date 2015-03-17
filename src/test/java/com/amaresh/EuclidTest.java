package com.amaresh;

import org.testng.annotations.Test;

public class EuclidTest {

    @Test
    public void gcdTest() {
        int gcd = new Euclid().gcd(20, 25);
        System.out.println("gcd of 20, 25 = " + gcd);
        gcd = new Euclid().gcd(25, 20);
        System.out.println("gcd of 25, 20 = " + gcd);
        gcd = new Euclid().gcd(0, 0);
        System.out.println("gcd of 0, 0 = " + gcd);
        gcd = new Euclid().gcd(77, 66);
        System.out.println("gcd of 77, 66 = " + gcd);
    }
}
