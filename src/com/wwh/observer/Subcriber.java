package com.wwh.observer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class Subcriber implements Observer{
	
	String name;
	Observable observable1;
	Observable observable2;
	SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");	
	public Subcriber(String name,Observable observable1, Observable observable2) {
		super();
		this.name=name;
		this.observable1 = observable1;
		this.observable2 = observable2;
		observable1.addObserver(this);
		observable2.addObserver(this);
	}

	public Subcriber(String name, Observable observable1) {
		super();
		this.name = name;
		this.observable1 = observable1;
		observable1.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if(o instanceof NewspaperOffice){
			System.out.println(name+" is recieving data from newspaperOffice by pull:");
			System.out.println(((NewspaperOffice) o).getNewspaperName());
			System.out.println(((NewspaperOffice) o).getNewspaperContent());
			System.out.println(format.format(((NewspaperOffice) o).getUpdateTime()));
		}
		
		if(o instanceof Weibo){
			System.out.println(name+" is recieving data from Weibo by push:");
			@SuppressWarnings("unchecked")
			Map<String,Object> map=(HashMap<String,Object>) arg;
			for(Map.Entry<String,Object> entry : map.entrySet()){
				if(entry.getValue() instanceof Date){
					entry.setValue(format.format(entry.getValue()));
				}
				System.out.println(entry.getKey()+" : "+entry.getValue());
			}
		}
	}	

}
