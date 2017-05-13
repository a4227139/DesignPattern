package com.wwh.factory;

import com.wwh.factory.product.Car;

public class Main {

	public static void main(String[] args){
		testSimpleFactory();
		testFactoryMethod();
	}
	
	public static void testSimpleFactory(){
		Car car;
		try {
			car = SimpleFactory.createCar("BMW");
			car.drive();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testFactoryMethod() {
		AbstractFactory factory=new BenzFactory();
		Car car=factory.createCar("430");
		car.drive();
		factory.sellCar(car);
	}
	
	public static void testAbstractFactory(){
		BenzFactory factory=new BenzFactory();
		Car car=factory.createCar("430");
		car.setEngine(factory.createEngine());
		car.setAirConditioner(factory.createAirConditioner());
	}
}
