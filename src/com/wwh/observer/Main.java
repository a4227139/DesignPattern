package com.wwh.observer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		NewspaperOffice newspaperOffice=new NewspaperOffice();
		Weibo weibo=new Weibo();
		new Subcriber("subcriber1",newspaperOffice);
		new Subcriber("subcriber2",weibo);
		new Subcriber("subcriber3",newspaperOffice, weibo);
		Runnable runnable = new Runnable() {  
            @SuppressWarnings({ "rawtypes", "unchecked" })
			public void run() {
            	Map newspaperData=new HashMap();
            	newspaperData.put("newspaperName", "人民日报");
            	newspaperData.put("newspaperContent", "党和国家领导人XXX于XX日会见外国元首XXX");
            	newspaperData.put("updateTime", new Date());
            	newspaperOffice.Publish(newspaperData);
            	
            	Map weiboData=new HashMap();
            	weiboData.put("hotspotName", "著名女星被曝光出轨");
            	weiboData.put("hotspotContent", "前日，著名女星被曝光出轨小鲜肉，老公发表声明");
            	weiboData.put("updateTime", new Date());
            	weibo.Publish(weiboData);
            }  
        };  
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();  
        service.scheduleAtFixedRate(runnable, 0, 2, TimeUnit.SECONDS); 
	}
}
