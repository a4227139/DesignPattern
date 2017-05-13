package com.wwh.command.TaskScheduling;

import java.io.File;
import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) throws Exception {
		String path="D:"+File.separator+"Log.log";
		Command command1=new LogCommand(path);
		Command command2=new CalculateCommand(new BigDecimal("911"));
		Command command3=new BrowserCommand("https://www.hao123.com/", "D:"+File.separator+"hao123.html");
		Command command4=new BrowserCommand("https://www.google.com/", "D:"+File.separator+"google.html");
		Command command5=new BrowserCommand("https://www.baidu.com/", "D:"+File.separator+"baidu.html");
		Command command6=new ImageCommand("D:"+File.separator+"1.jpg","D:"+File.separator+"2.jpg","D:"+File.separator+"3.jpg");
		Command command7=new BrowserCommand("https://www.taobao.com/", "D:"+File.separator+"taobao.html");
		Command command8=new ScanFileCommand("D:"+File.separator);
		Command command9=new BrowserCommand("https://www.tencent.com/zh-cn/index.html", "D:"+File.separator+"tencent.html");
		Command command10=new ScanFileCommand("E:"+File.separator);
		TaskPool.init(2);
		TaskPool.start();
		TaskPool.addTask(command1);
		TaskPool.addTask(command2);
		TaskPool.addTask(command3);
		TaskPool.addTask(command4);
		TaskPool.addTask(command5);
		TaskPool.addTask(command6);
		TaskPool.addTask(command7);
		TaskPool.addTask(command8);
		TaskPool.addTask(command9);
		TaskPool.addTask(command10);
	}
}
