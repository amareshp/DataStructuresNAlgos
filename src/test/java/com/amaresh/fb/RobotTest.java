package com.amaresh.fb;

import org.testng.annotations.Test;

public class RobotTest {
    
    @Test
    public void testRobot() {
        Robot robot = new Robot(6);
        robot.populateNextStep(1, 1);
        Robot.printSteps(robot.graphMatrix);
        
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++\n");
        robot.populateNextStep2(1, 1);
        Robot.printSteps(robot.graphMatrix);
        
        int steps = robot.stepsTo(1, 1, 5, 4, 0);
        System.out.println("steps taken to reach 5,4 = " + steps);
    }

}
