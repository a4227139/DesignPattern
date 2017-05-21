package com.wwh.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 模板方法定义了方法的步骤，把这些步骤的具体实现推迟到了子类。
 * 模板方法模式和策略模式都是封装算法，但前者靠继承，后者靠组合。并且策略模式封装的是整个算法，模板方法模式封装的只是算法中的某些具体步骤。
 */
public abstract class CoffeineBeverage {

	final void prepareRecipe(){//防止子类修改算法步骤
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
	
	void hook(){}//默认不做事的钩子方法，子类可选择要不要覆盖它
	
	boolean isCustomerWantsCondiments(){//这个也是钩子方法，它通常用来让子类实现算法中可选的部分，并且改变算法的运行步骤
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
