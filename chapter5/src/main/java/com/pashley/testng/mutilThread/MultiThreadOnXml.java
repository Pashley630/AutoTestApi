package com.pashley.testng.mutilThread;

public class MultiThreadOnXml {

    public void test1(){
        System.out.printf("threadId is : %s%n",Thread.currentThread().getId());
    }

    public void test2(){
        System.out.printf("threadId is : %s%n",Thread.currentThread().getId());
    }

    public void test3(){
        System.out.printf("threadId is : %s%n",Thread.currentThread().getId());
    }

}
