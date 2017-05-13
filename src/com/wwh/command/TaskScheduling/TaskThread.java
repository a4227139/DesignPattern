package com.wwh.command.TaskScheduling;

public class TaskThread extends Thread{

	Command command;
	int index;
	public TaskThread(Command command,int index) {
		super();
		this.command = command;
		this.index=index;
	}


	public void setCommand(Command command) {
		this.command = command;
	}


	@Override
	public void run() {
		while(true){
			if(command!=null){
				TaskPool.isRuning[index]=true;
				command.execute();
				command=null;
				TaskPool.isRuning[index]=false;
				try {
					synchronized (TaskPool.isRuning[index]) {
						TaskPool.isRuning[index].wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
