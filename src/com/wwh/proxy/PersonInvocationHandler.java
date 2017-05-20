package com.wwh.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonInvocationHandler implements InvocationHandler{

	Person person;
	
	public PersonInvocationHandler(Person person) {
		super();
		this.person = person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().equals("walk")){
			method.invoke(person, args);
			System.out.println("run by proxy");
		}else if(method.getName().equals("hire")){
			if(person.getClass().getName().endsWith("Manager")){
				method.invoke(person, args);
				System.out.println("Hire successfully");
			}else {
				System.out.println("You have no permissions");
			}
		}
		return null;
	}

}
