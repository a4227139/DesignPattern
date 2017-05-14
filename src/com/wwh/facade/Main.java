package com.wwh.facade;

public class Main {

	public static void main(String[] args) {
		Light light=new Light();
		DVD dvd=new DVD();
		Screen screen=new Screen();
		Facade facade=new Facade(dvd, light, screen);
		facade.watchMovie();
		facade.endMovie();
	}
}
