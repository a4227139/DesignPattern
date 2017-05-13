package com.wwh.command.TaskScheduling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ScanFileCommand implements Command{

	String path;
	Writer writer;
	public ScanFileCommand(String path) {
		super();
		this.path = path;
		try {
			writer = new FileWriter("D:"+File.separator+"FileList.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void execute() {
		scanFile(path);
		System.out.println(path +" write done");
	}
	
	public void scanFile(String path) {
        File file = new File(path);
        StringBuffer buffer=new StringBuffer("");
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files==null||files.length == 0) {
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                    	buffer.append(file2.getAbsolutePath()+"\\"+"\r\n");
                        scanFile(file2.getAbsolutePath());
                    } else {
                    	buffer.append(file2.getAbsolutePath()+"\r\n");
                    }
                }
            }
            try {
				writer.write(buffer.toString());
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
        } else {
            System.out.println("文件不存在!");
        }
    }

}
