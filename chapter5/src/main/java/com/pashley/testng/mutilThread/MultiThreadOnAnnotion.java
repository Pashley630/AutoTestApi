package com.pashley.testng.mutilThread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotion {

    //执行10次
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println("1");
        System.out.printf("threadId is : %s%n",Thread.currentThread().getId());
    }
}
