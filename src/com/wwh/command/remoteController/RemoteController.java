package com.wwh.command.remoteController;

import java.util.Stack;

public class RemoteController {

	private Command commands[];
	private Stack<Command> undoStack=new Stack<Command>();
	public RemoteController(){
		commands=new Command[7];
		for(int i=0;i<7;i++){
			commands[i]=new noCommand();
		}
	}
	
	public void setCommand(int slot,Command command){
		commands[slot]=command;
	}
	
	public void onButtonWasPushed(int slot){
		commands[slot].execute();
		undoStack.push(commands[slot]);
	}
	
	public void undoButtonWasPushed(){
		if(undoStack.size()!=0){
			undoStack.pop().undo();;
		}else{
			System.out.println("Can not undo anymore!");
		}
	}
	
}
