package com.amaresh.google;

public class ThreadClass1 implements Runnable {
    public void run() {

        while (!ThreadExec1.flag) {
            Thread.yield();
        }

        System.out.println(ThreadExec1.num);

    }

}
