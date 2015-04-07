package com.amaresh.fb;

import org.testng.annotations.Test;

public class StringFunctionsTest {

    @Test
    public void testDepth() {
        String input = "abc{d{ad{db{a{ed{ji}x{}ab{a}ab}e}ab}ab}ed}{}";
        StringFunctions sf = new StringFunctions(input);
        System.out.println(sf.input);
        System.out.println("Depth: " + sf.findDepth());
    }
}
