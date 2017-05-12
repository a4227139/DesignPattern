package com.wwh.singleton;

import java.lang.reflect.InvocationTargetException;


/*
 * effective java 建议的方式
 */
public class Singleton_Enum {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Singleton.INSTANCE.read();
		System.out.println(Singleton.class.getConstructors().length);//0
	}
}

enum Singleton {
    INSTANCE {
    	protected void read() {
            System.out.println("read");
        }
    	protected void write() {
            System.out.println("write");
        }
    };
	protected abstract void read();
    protected abstract void write();
}