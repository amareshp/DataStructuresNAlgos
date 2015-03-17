package com.amaresh;

import org.testng.annotations.Test;

public class TowerOfHanoiTest {

    @Test
    public void moveTest() {
        new TowerOfHanoi().moveDiscs(3, "A", "C", "B");
    }
}
