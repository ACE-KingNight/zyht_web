package com.tag;

/**
 * function所定义的方法必须需要是静态的,如果不是静态的话jstl是不能识别所定义的方法.
 *
 */
public class MyFunctions {

    public static String formatMyName(String name) {
        return "我的姓名 " + name;
     }

     public static int add(int a, int b) {
        return a+b;
     }
}
