package com.wwh.proxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadFile {

	public boolean isLoadComplete=false;
	public void load(String path) {
		try {
			FileReader reader=new FileReader(new File(path));
			Thread.sleep(2000);
			String s;
			int ch = 0;  
	        while((ch = reader.read()) != -1){  
	            System.out.print((char)ch);  
	        } 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		isLoadComplete=true;
	}
}
