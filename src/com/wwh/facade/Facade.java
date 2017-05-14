package com.wwh.facade;
/*
 * ���ģʽ����ҪĿ�����ڽ���ϵͳ�ĸ��ӳ̶ȣ���װ����ϵͳ�ڵĸ��ӹ�ϵ���ṩ�򻯵�ͳһ�ӿڣ���Ҳ����ȫ��װ���ͻ��Կ������е�����ϵͳ��
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
