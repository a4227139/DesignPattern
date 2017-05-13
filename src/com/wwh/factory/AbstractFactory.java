package com.wwh.factory;

import com.wwh.factory.product.Car;
/*
 * 工厂方法模式将创建具体的产品委托给子类，将产品的实现和使用相分离。
 * 工厂和产品是平级且解耦合的。
 * 如果想新增新产品，也只需创建新的工厂而不用改动现工厂。
 * 工厂方法模式和简单工厂很像。但工厂方法的子类们都是继承同一父类，而简单工厂等于创建了一个上帝类，一切都由其创造。
 * 而且工厂方法模式也相当于创建了一个框架，可以有其他各种方法，只是创建对象的方法被具体的子类实现，其他方法由父类提供。
 */
public abstract class AbstractFactory {

	public abstract Car createCar(String type);
	
	public void sellCar(Car car){
		System.out.println(car+" on sale...");
	}
}
