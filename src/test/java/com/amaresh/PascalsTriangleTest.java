package com.amaresh;

import org.testng.annotations.Test;

public class PascalsTriangleTest {
    
    @Test
    public void test() {
        PascalsTriangle triangle = new PascalsTriangle(5);
        
        triangle.print();
    }

}
