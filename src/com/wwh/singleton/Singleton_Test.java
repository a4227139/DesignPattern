package com.wwh.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;

/*
 * 如果单例实现了 Serializable，反序列化回来后就会出现新的对象，所以要重写readResolve方法。
 * 为预防放射将其破坏，在构造时添加判断。
 */
public class Singleton_Test implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static Singleton_Test instance=new Singleton_Test();
	private Singleton_Test(){}
	public static Singleton_Test getInstance(){
		// 判断单例对象是否已经存在，用于控制非法反射单例类的构造函数  
        if (instance != null){
        	try {  
                throw new IllegalAccessException("单例对象已经被实例化，请不要非法反射构造函数");  
            } catch (IllegalAccessException e) {  
                e.printStackTrace();  
            }
        }
		return instance;
	}
	private Object readResolve() throws ObjectStreamException {    
        return instance;  
    } 
	
	public static void main(String[] args){
		try {
			testSerializableCase();
			testRefelectCase();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@SuppressWarnings("resource")
	public static void testSerializableCase()  throws FileNotFoundException, IOException, ClassNotFoundException {
		Singleton_Test instance=getInstance();
		ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("instance.out"));
		outputStream.writeObject(instance);
		ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream("instance.out"));
		Singleton_Test instance2=(Singleton_Test) inputStream.readObject();
		System.out.println("instance==instance2 : "+(instance==instance2));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void testRefelectCase(){
		Class c;
		try {
			c = Class.forName("com.wwh.singleton.Singleton_Test");
			Constructor constructor= c.getDeclaredConstructor();
			constructor.setAccessible(true);
			Singleton_Test instance1=getInstance();
			Singleton_Test instance2=(Singleton_Test) constructor.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
