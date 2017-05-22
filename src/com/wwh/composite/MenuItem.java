package com.wwh.composite;

import java.util.Iterator;
/*
 * ���ģʽ������������νṹ������'����/����'�Ĳ�νṹ�����ÿͻ���һ�µķ�ʽ�������Ͷ������ϣ�
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
