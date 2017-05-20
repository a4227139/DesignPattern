package com.wwh.proxy;

import java.util.List;

public class Employee implements Person{

	@Override
	public void walk() {
		System.out.println("I'm walking...");
		
	}

	@Override
	public void swim() {
		System.out.println("I'am swiming...");
		
	}

	@Override
	public void hire(List list, Person person) {
		System.out.println("I can'nt hire someone");
	}

}
