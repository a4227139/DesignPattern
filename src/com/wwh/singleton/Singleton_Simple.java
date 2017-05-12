package com.wwh.singleton;

/*
 * 单例模式最简单的实现，私有化构造器，静态持有，提供全局访问接口
 * 饿汉模式
 */
public class Singleton_Simple{
	private static Singleton_Simple instance=new Singleton_Simple();
	private Singleton_Simple(){}
	public static Singleton_Simple getInstance(){
		return instance;
	}
}
