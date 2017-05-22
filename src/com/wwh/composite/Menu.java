package com.wwh.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent{

	List<MenuComponent> list=new ArrayList<>();
	String name;
	String description;
	public Menu(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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
	
	public void add(MenuComponent menuComponent){
		list.add(menuComponent);
	}
	
	public void remove(MenuComponent menuComponent){
		list.remove(menuComponent);
	}
	
	public MenuComponent getChild(int i){
		return list.get(i);
	}
	
	public void print() {
		System.out.print("\n"+getName());
		System.out.println(","+getDescription());
		System.out.println("----------------");
		
		Iterator iterator=list.iterator();
		while (iterator.hasNext()) {
			MenuComponent menuComponent=(MenuComponent) iterator.next();
			menuComponent.print();
		}
	}
	
	public Iterator createIterator() {
		return new CompositeIterator(list.iterator());
	}
}
