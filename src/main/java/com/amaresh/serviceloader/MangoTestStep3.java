package com.amaresh.serviceloader;

@MyAnnotation
public class MangoTestStep3 implements TestStep {
    
    public void execute() {
        System.out.println("Executing Mango test step 3...");
    }
    
    
    public void step3() {
        System.out.println("in step 3...");
    }

}
