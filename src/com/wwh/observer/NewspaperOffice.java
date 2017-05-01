package com.wwh.observer;

import java.util.Date;
import java.util.Map;
import java.util.Observable;

public class NewspaperOffice extends Observable{

	String newspaperName;
	String newspaperContent;
	Date updateTime;
	
	public String getNewspaperName() {
		return newspaperName;
	}
	public String getNewspaperContent() {
		return newspaperContent;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void Publish(Map data){
		this.newspaperName=(String) data.get("newspaperName");
		this.newspaperContent=(String) data.get("newspaperContent");
		this.updateTime=(Date) data.get("updateTime");
		setChanged();
		notifyObservers();
	}
}
