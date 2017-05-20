package com.wwh.proxy;

import java.util.List;

public class Manager implements Person {

	@Override
	public void walk() {
		System.out.println("I'm walking...");
		
	}

	@Override
	public void swim() {
		System.out.println("I can't swim");
		
	}

	@Override
	public void hire(List list,Person person) {
		list.add(person);
	}
	
}
