package com.wwh.singleton;

/*
 * ����ģʽ��򵥵�ʵ�֣�˽�л�����������̬���У��ṩȫ�ַ��ʽӿ�
 * ����ģʽ
 */
public class Singleton_Simple{
	private static Singleton_Simple instance=new Singleton_Simple();
	private Singleton_Simple(){}
	public static Singleton_Simple getInstance(){
		return instance;
	}
}
