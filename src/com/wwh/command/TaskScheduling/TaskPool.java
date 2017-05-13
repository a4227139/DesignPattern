package com.wwh.command.TaskScheduling;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class TaskPool {

	static List<Runnable> pool=new ArrayList<Runnable>();
	static Queue<Command> waitingQueue=new LinkedList<Command>();
	static Boolean[] isRuning;
	static int poolSize;

	public static void addTask(Command command) {
		if(pool.size()<poolSize){
			Thread thread=new TaskThread(command, pool.size());
			pool.add(thread);
			thread.start();
		}else if(waitingQueue.size()<10){
			waitingQueue.add(command);
		}else {
			System.out.println("Can not handle anymore");
		}
	}
	
	public static boolean isFullRuning(){
		for(int i=0;i<poolSize;i++){
			if(isRuning[i]==false)
				return false;
		}
		return true;
	}
	
	public static boolean isWaitingQueueEmpty(){
		if(waitingQueue.size()==0){
			return true;
		}else{
			return false;
		}
	}
	
	public static void init(int poolSize) throws Exception{
		if(poolSize<=0) throw new Exception("poolSize illegal ");
		TaskPool.poolSize = poolSize;
		isRuning=new Boolean[poolSize];
		for(int i=0;i<poolSize;i++){
			isRuning[i]=new Boolean("false");
		}
	}
	
	public static void start(){
		Timer timer = new Timer();
		TimerTask timerTask=new TimerTask() {
			@Override
			public void run() {
				if(!isFullRuning()&&!isWaitingQueueEmpty()){
					for(int i=0;i<poolSize;i++){
						if(isRuning[i]==false){
							((TaskThread) pool.get(i)).setCommand(waitingQueue.poll());
							synchronized (TaskPool.isRuning[i]) {
								isRuning[i].notify();
							}
						}
					}
				}
			}
		};
		timer.schedule(timerTask, 100, 100);
	}
}
