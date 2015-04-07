package com.amaresh.serviceloader;


public class MangoTestStep2 implements TestStep {
    
    public void execute() {
        System.out.println("Executing Mango test step 2...");
    }
    
    @MyAnnotation
    public void step2() {
        System.out.println("in step2...");
    }

}
