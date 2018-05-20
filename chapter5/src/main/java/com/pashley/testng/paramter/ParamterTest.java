package com.pashley.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ParamterTest {

    @Test
    @Parameters({"name","age"})
    public void paraTest1(String name,int age){
        System.out.println("name="+name+";age="+age);
    }

    @Test(dataProvider = "dataProvider")
    public void paraTest2(String name,int age){
        System.out.println("name ="+name+"; age="+age);
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider(){
        Object[][] o = new Object[][]{
                {"ZHANGSAN",10},
                {"LISI",20}
        };
        return o;
    }


    @Test(dataProvider = "methodData")
    public void paraTest3(String name,int age){
        System.out.println("name ="+name+"; age="+age);
    }
    @Test(dataProvider = "methodData")
    public void paraTest4(String name,int age){
        System.out.println("name ="+name+"; age="+age);
    }

    @DataProvider(name = "methodData")
    public Object[][] dataProvider(Method method){
        Object[][] objects=null;
        if (method.getName().equals("paraTest3")){
            objects = new Object[][]{
                    {"WANGWU",30},
                    {"MAZI",40}
            };
        }else if (method.getName().equals("paraTest4")){
            objects = new Object[][]{
                    {"LILI",50},
                    {"AA",60}
            };
        }
        return objects;
    }
}
