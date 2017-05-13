package com.wwh.command.TaskScheduling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

public class LogCommand implements Command{

	String path;
	Writer writer;
	public LogCommand(String path) {
		super();
		this.path = path;
		try {
			writer = new FileWriter(path, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void execute() {
		try {
			writer.write(Thread.currentThread()+" add log "+new Date()+"\r\n");
			System.out.println(Thread.currentThread()+" add log "+new Date());
			Thread.sleep(100);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
