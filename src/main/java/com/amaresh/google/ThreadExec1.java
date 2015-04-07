package com.amaresh.google;

public class ThreadExec1 {
    public static int num = 1;
    public static boolean flag = false;

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadClass1());
        t.start();
        ThreadExec1.flag = true;
        ThreadExec1.num = 10;
    }

}
