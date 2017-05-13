package com.wwh.factory;

import com.wwh.factory.product.AirConditioner;
import com.wwh.factory.product.AirConditionerB;
import com.wwh.factory.product.Benz;
import com.wwh.factory.product.Car;
import com.wwh.factory.product.Engine;
import com.wwh.factory.product.EngineB;

public class BenzFactory extends AbstractFactory implements PartsFactory{

	@Override
	public Car createCar(String type) {
		return new Benz(type);
	}

	@Override
	public Engine createEngine() {
		return new EngineB();
	}

	@Override
	public AirConditioner createAirConditioner() {
		return new AirConditionerB();
	}

}
