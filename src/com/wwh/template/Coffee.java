package com.wwh.template;

public class Coffee extends CoffeineBeverage{

	@Override
	void brew() {
		System.out.println("Drinpping coffee through filter");
	}

	@Override
	void addCondiments() {
		System.out.println("Adding sugar and milk");
	}
	
	@Override
	boolean isCustomerWantsCondiments(){
		if(getUserAnswer().toLowerCase().startsWith("y")){
			return true;
		}else {
			return false;
		}
		
	}

}
