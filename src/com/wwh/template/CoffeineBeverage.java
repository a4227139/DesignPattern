package com.wwh.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ģ�巽�������˷����Ĳ��裬����Щ����ľ���ʵ���Ƴٵ������ࡣ
 * ģ�巽��ģʽ�Ͳ���ģʽ���Ƿ�װ�㷨����ǰ�߿��̳У����߿���ϡ����Ҳ���ģʽ��װ���������㷨��ģ�巽��ģʽ��װ��ֻ���㷨�е�ĳЩ���岽�衣
 */
public abstract class CoffeineBeverage {

	final void prepareRecipe(){//��ֹ�����޸��㷨����
		boilWater();
		brew();
		pourInCup();
		if(isCustomerWantsCondiments()){
			addCondiments();
		}
	}
	
	abstract void brew();
	abstract void addCondiments();
	void boilWater(){
		System.out.println("Boiling water...");
	}
	void pourInCup(){
		System.out.println("Pouring into cup...");
	}
	
	void hook(){}//Ĭ�ϲ����µĹ��ӷ����������ѡ��Ҫ��Ҫ������
	
	boolean isCustomerWantsCondiments(){//���Ҳ�ǹ��ӷ�������ͨ������������ʵ���㷨�п�ѡ�Ĳ��֣����Ҹı��㷨�����в���
		return true;
	}
	
	String getUserAnswer(){
		String answer = null;
		System.out.println("Do you want some Condiments?(y/n)");
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		try {
			answer=reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return answer;
	}
}
