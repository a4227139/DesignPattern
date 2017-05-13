package com.wwh.factory.product;

public class BMW extends Car{

	@Override
	public void drive() {
		type=type==null?"":type;
		System.out.println(("driving BWM ")+type);
	}
	
	public BMW(){};
	
	public BMW(String type){
		this.type=type;
	}

	@Override
	public String toString() {
		return "BMW "+ type ;
	}
	
}
