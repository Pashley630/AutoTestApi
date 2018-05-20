package com.pashley.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMEethod {
    @Test(groups = "client")
    public void test3(){
        System.out.println("client组测试方法3。。。。");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("client组测试方法4。。。。");
    }

    @Test(groups = "server")
    public void test1(){
        System.out.println("服务的组测试方法1。。。。");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("服务的组测试方法2。。。。");
    }

    @BeforeGroups("client")
    public void beforeGroupsClient(){
        System.out.println("这是client组beforeGroupsClient。。。。");
    }

    @AfterGroups("client")
    public void afterGroupsClient(){
        System.out.println("这是client组afterGroupsClient。。。。");
    }

    @BeforeGroups("server")
    public void beforeGroupsSercer(){
        System.out.println("这是服务组beforeGroupsSercer。。。。");
    }

    @AfterGroups("server")
    public void afterGroupsSercer(){
        System.out.println("这是服务组afterGroupsSercer。。。。");
    }
}
