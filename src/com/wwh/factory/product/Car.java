package com.wwh.factory.product;

public abstract class Car {

	String type;
	Engine engine;
	AirConditioner airConditioner;
	abstract public void drive();
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public AirConditioner getAirConditioner() {
		return airConditioner;
	}
	public void setAirConditioner(AirConditioner airConditioner) {
		this.airConditioner = airConditioner;
	}
	
}
