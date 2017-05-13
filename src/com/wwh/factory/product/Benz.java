package com.wwh.factory.product;

public class Benz extends Car{

	@Override
	public void drive() {
		type=type==null?"":type;
		System.out.println("driving Benz "+type);
	}

	public Benz(){};
	
	public Benz(String type){
		this.type=type;
	}
	
	@Override
	public String toString() {
		return "Benz "+ type ;
	}
}
