package com.amaresh;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest {
    
    //@Test
    public void binarySearch() {
        int[] input = {3, 7, 8, 10, 13, 17, 19, 22, 26, 29, 33, 38, 42};
        boolean found = new Search().binarySearch(input, 3);
        Assert.assertTrue(found);
        found = new Search().binarySearch(input, 42);
        Assert.assertTrue(found);
        found = new Search().binarySearch(input, 43);
        Assert.assertFalse(found);
    }

    @Test
    public void positionSearch() {
        int[] input = {3, 7, 8, 10, 13, 17, 19, 22, 26, 29, 33, 38, 42};
        int position = new Search().findPosition(input, 5);
        System.out.println("Correct index position for 5 is: " + position);
        position = new Search().findPosition(input, 44);
        System.out.println("Correct index position for 44 is: " + position);
        position = new Search().findPosition(input, 19);
        System.out.println("Correct index position for 19 is: " + position);
    }
    
}
