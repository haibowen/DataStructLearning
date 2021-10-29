package com.example.datastructlearning.data;

public class Singleton {

    private volatile static Singleton instance;
    //私有化构造器
    private Singleton(){

    }
    public static Singleton getInstance(){
        if (instance==null){
            synchronized (Singleton.class){
                if (instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}
