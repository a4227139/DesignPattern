package com.wwh.composite;

public class Main {

	public static void main(String[] args) {
		Menu menu=new Menu("Menu", "This is highest");
		MenuItem item1=new MenuItem("pig meat", "pig's meat", false, 18);
		MenuItem item2=new MenuItem("chicken meat", "chicken's meat", false, 10);
		MenuItem item3=new MenuItem("egg", "chicken's egg", false, 0.5);
		MenuItem item4=new MenuItem("pepper", "green pepper", true, 2.5);
		menu.add(item1);menu.add(item2);menu.add(item3);menu.add(item4);
		Menu drinkMenu =new Menu("drinkMenu", "This is drinkMenu");
		MenuItem item5=new MenuItem("coffee", "hot coffee", false, 18);
		MenuItem item6=new MenuItem("tea", "green tea", false, 10);
		drinkMenu.add(item5);drinkMenu.add(item6);
		menu.add(drinkMenu);
		menu.print();
	}
}
