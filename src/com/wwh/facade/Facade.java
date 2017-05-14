package com.wwh.facade;
/*
 * 外观模式的主要目的在于降低系统的复杂程度，封装了子系统内的复杂关系，提供简化的统一接口，但也不完全封装，客户仍可以自行调用子系统。
 */
public class Facade {

	DVD dvd;
	Light light;
	Screen screen;
	public Facade(DVD dvd, Light light, Screen screen) {
		super();
		this.dvd = dvd;
		this.light = light;
		this.screen = screen;
	}
	public void watchMovie(){
		light.off();
		screen.down();
		dvd.on();
		dvd.setVolume(10);
		dvd.setDish("Pirates of the Caribbean");
	}
	
	public void endMovie() {
		light.on();
		dvd.off();
		screen.up();
	}
}
