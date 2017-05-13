package com.wwh.factory;

import com.wwh.factory.product.Car;
/*
 * ��������ģʽ����������Ĳ�Ʒί�и����࣬����Ʒ��ʵ�ֺ�ʹ������롣
 * �����Ͳ�Ʒ��ƽ���ҽ���ϵġ�
 * ����������²�Ʒ��Ҳֻ�贴���µĹ��������øĶ��ֹ�����
 * ��������ģʽ�ͼ򵥹������񡣵����������������Ƕ��Ǽ̳�ͬһ���࣬���򵥹������ڴ�����һ���ϵ��࣬һ�ж����䴴�졣
 * ���ҹ�������ģʽҲ�൱�ڴ�����һ����ܣ��������������ַ�����ֻ�Ǵ�������ķ��������������ʵ�֣����������ɸ����ṩ��
 */
public abstract class AbstractFactory {

	public abstract Car createCar(String type);
	
	public void sellCar(Car car){
		System.out.println(car+" on sale...");
	}
}
