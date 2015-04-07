package com.amaresh.serviceloader;

import java.lang.reflect.Method;
import java.util.ServiceLoader;
import java.util.Set;

import org.reflections.Reflections;
import org.testng.annotations.Test;

public class ServiceLoaderTest {

    @Test
    public void testLoader() {

        Reflections reflections = new Reflections("com.amaresh");

        Set<Class<? extends TestStep>> subTypes = reflections.getSubTypesOf(TestStep.class);
        for (Class clazz : subTypes) {
            System.out.println(clazz.getName());
        }

        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(MyAnnotation.class);
        for (Class clazz : annotated) {
            System.out.println(clazz.getName());
        }
        
        Set<Method> annotatedMethods = reflections.getMethodsAnnotatedWith(MyAnnotation.class);
        for(Method method : annotatedMethods) {
            System.out.println("Class: " + method.getClass() + " Method: " + method.getName());
        }

        final ServiceLoader<TestStep> testStepLoader = ServiceLoader.load(TestStep.class);

        for (TestStep ts : testStepLoader) {
            ts.execute();
        }
    }

}
