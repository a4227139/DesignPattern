package com.wwh.observer;

import java.util.Date;
import java.util.Map;
import java.util.Observable;

public class Weibo extends Observable{

	String hotspotNmae;
	String hotspotContent;
	Date updateTime;
	
	public void Publish(Map data){
		setChanged();
		notifyObservers(data);
	}
}
