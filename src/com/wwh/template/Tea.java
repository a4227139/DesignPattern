package com.wwh.template;

public class Tea extends CoffeineBeverage{

	@Override
	void brew() {
		System.out.println("Steeping the tea");
	}

	@Override
	void addCondiments() {
		System.out.println("Adding lemon");
	}

}
