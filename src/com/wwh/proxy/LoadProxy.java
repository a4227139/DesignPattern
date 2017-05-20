package com.wwh.proxy;

import java.util.Timer;
import java.util.TimerTask;

public class LoadProxy {

	LoadFile loadFile;
	boolean isCreated=false;
	public LoadProxy(LoadFile loadFile) {
		super();
		this.loadFile = loadFile;
	}

	public void load(String path){
		Timer timer=new Timer();
		TimerTask task=new TimerTask(){
			@SuppressWarnings("unused")
			@Override
			public void run() {
				if(loadFile.isLoadComplete){
					System.out.println("SuccessFully");
					timer.cancel();
				}else{
					System.out.println("Loading");
					if(!isCreated){
						isCreated=true;
						Thread thread=new Thread(new Runnable() {
							@Override
							public void run() {
								loadFile.load(path);
							}
						});
						thread.start();
					}
					
				}
			}
		};
		timer.schedule(task, 0,500);
	}
	
}
