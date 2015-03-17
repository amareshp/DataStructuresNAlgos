package com.amaresh;

import org.testng.annotations.Test;

public class FactorialTest {

    @Test
    public void test() {
        int n = 0;
        int factorial = new Factorial().factorial(n);
        System.out.println("Factorial of " + n + " = " + factorial);
        n = 1;
        factorial = new Factorial().factorial(n);
        System.out.println("Factorial of " + n + " = " + factorial);
        n = 2;
        factorial = new Factorial().factorial(n);
        System.out.println("Factorial of " + n + " = " + factorial);
        n = 3;
        factorial = new Factorial().factorial(n);
        System.out.println("Factorial of " + n + " = " + factorial);
        n = 4;
        factorial = new Factorial().factorial(n);
        System.out.println("Factorial of " + n + " = " + factorial);
        n = 5;
        factorial = new Factorial().factorial(n);
        System.out.println("Factorial of " + n + " = " + factorial);
    }
}
