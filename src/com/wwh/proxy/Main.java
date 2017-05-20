package com.wwh.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		testDynamicProxy();
		testVirtualProxy();
	}
	
	public static void testDynamicProxy(){
		Person manager=new Manager();
		Person employee=new Employee();
		List<Person> list=new ArrayList<>();
		PersonInvocationHandler invocationHandlerManage=new PersonInvocationHandler(manager);
		PersonInvocationHandler invocationHandlerEmployee=new PersonInvocationHandler(employee);
		Person managerProxy=(Person) Proxy.newProxyInstance(manager.getClass().getClassLoader(), manager.getClass().getInterfaces(), invocationHandlerManage);
		Person employeeProxy= (Person) Proxy.newProxyInstance(employee.getClass().getClassLoader(), employee.getClass().getInterfaces(), invocationHandlerEmployee);
		managerProxy.walk();
		managerProxy.swim();
		managerProxy.hire(list, employee);
		employeeProxy.hire(list, employee);
	}
	
	
	public static void testVirtualProxy(){
		String path="D://student.txt";
		LoadProxy proxy=new LoadProxy(new LoadFile());
		proxy.load(path);
	}
}
