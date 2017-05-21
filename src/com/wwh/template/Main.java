package com.wwh.template;

public class Main {

	public static void main(String[] args) {
		CoffeineBeverage coffee=new Coffee();
		coffee.prepareRecipe();
		CoffeineBeverage tea=new Tea();
		tea.prepareRecipe();
	}
}
