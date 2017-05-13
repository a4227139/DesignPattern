package com.wwh.factory;

import com.wwh.factory.product.AirConditioner;
import com.wwh.factory.product.AirConditionerA;
import com.wwh.factory.product.BMW;
import com.wwh.factory.product.Car;
import com.wwh.factory.product.Engine;
import com.wwh.factory.product.EngineA;

public class BMWFactory extends AbstractFactory implements PartsFactory{

	@Override
	public Car createCar(String type) {
		return new BMW(type);
	}

	@Override
	public Engine createEngine() {
		return new EngineA();
	}

	@Override
	public AirConditioner createAirConditioner() {
		return new AirConditionerA();
	}

}
