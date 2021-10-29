package com.example.datastructlearning.test;

public class SingletonDemo {
    private volatile static SingletonDemo singleton;

    private SingletonDemo(){

    }
    public static SingletonDemo getInstance(){
        if (singleton==null){
            synchronized (SingletonDemo.class){
                if (singleton==null){
                    singleton=new SingletonDemo();
                }
            }
        }
        return singleton;
    }
}
