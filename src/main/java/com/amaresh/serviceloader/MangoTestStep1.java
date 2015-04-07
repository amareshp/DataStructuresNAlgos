package com.amaresh.serviceloader;

public class MangoTestStep1 implements TestStep {

    public void execute() {
        System.out.println("Executing Mango test step 1...");
    }
    
    @MyAnnotation
    public void step1() {
        System.out.println("In step 1...method annotated");
    }

}
