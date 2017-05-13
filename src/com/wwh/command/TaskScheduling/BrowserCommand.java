package com.wwh.command.TaskScheduling;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

public class BrowserCommand implements Command {

	String url,path;
	Writer writer;
	public BrowserCommand(String url,String path) {
		super();
		this.url = url;
		this.path = path;
		try {
			writer=new FileWriter(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void execute() {
		HttpURLConnection conn = null;
        try {
            URL realUrl = new URL(url);
            conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setUseCaches(false);
            conn.setReadTimeout(8000);
            conn.setConnectTimeout(8000);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0");
            int code = conn.getResponseCode();
            if (code == 200) {
            	System.out.println("get response");
                InputStream is = conn.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(is, "GBK"));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = in.readLine()) != null){
                    buffer.append(line);
                }
                writer.write(buffer.toString());
                writer.flush();
                System.out.println("write successfully");
            }
        }catch (Exception e){
        	e.printStackTrace();
        }
	}

}
