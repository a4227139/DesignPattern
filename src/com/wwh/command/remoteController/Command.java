package com.wwh.command.remoteController;
/*
 * 命令模式通过将请求封装成对象，将发出请求的对象和接收并执行请求的对象解耦合
 * 命令对象持有接收者，并在接收者上绑定一组特定的动作
 */
public interface Command {

	public void execute();
	public void undo();
}
