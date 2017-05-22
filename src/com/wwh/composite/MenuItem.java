package com.wwh.composite;

import java.util.Iterator;
/*
 * 组合模式将对象组成树形结构来表现'整体/部分'的层次结构。能让客户以一致的方式处理对象和对象的组合，
 */
public class MenuItem extends MenuComponent{

	String name;
	String description;
	boolean isVegetarian;
	double price;
	
	
	public MenuItem(String name, String description, boolean isVegetarian, double price) {
		super();
		this.name = name;
		this.description = description;
		this.isVegetarian = isVegetarian;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isVegetarian() {
		return isVegetarian;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void print(){
		System.out.print("   "+getName());
		if(isVegetarian()){
			System.out.print("(v)");
		}
		System.out.print(","+getPrice());
		System.out.println(" --- "+getDescription());
	}
	
	public Iterator createIterator() {
		return new NullIterator();
	}
}
