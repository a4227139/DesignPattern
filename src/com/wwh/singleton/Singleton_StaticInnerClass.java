package com.wwh.singleton;


/*用静态内部类实现懒汉单例模式*/
public class Singleton_StaticInnerClass {
    private Singleton_StaticInnerClass (){}    
    public static final Singleton_StaticInnerClass getInstance() {    
       return LazyHolder.INSTANCE;    
    }
    private static class LazyHolder {
	   private static final Singleton_StaticInnerClass INSTANCE = new Singleton_StaticInnerClass();    
	}   
}
