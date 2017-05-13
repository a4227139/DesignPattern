package com.wwh.command.remoteController.devices;

public class DVD {

	int volume;
	String dish;
	public void setVolume(int volume){
		this.volume=volume;
		System.out.println("volunm is "+volume);
	}

	public void setDish(String dish) {
		this.dish = dish;
		System.out.println("DVD is playing "+dish);
	}

	public void on(){
		System.out.println("DVD on");
	}
	
	public void off(){
		System.out.println("DVD off");
	}
}
