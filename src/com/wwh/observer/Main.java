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
            	newspaperData.put("newspaperName", "�����ձ�");
            	newspaperData.put("newspaperContent", "���͹����쵼��XXX��XX�ջ�����Ԫ��XXX");
            	newspaperData.put("updateTime", new Date());
            	newspaperOffice.Publish(newspaperData);
            	
            	Map weiboData=new HashMap();
            	weiboData.put("hotspotName", "����Ů�Ǳ��ع����");
            	weiboData.put("hotspotContent", "ǰ�գ�����Ů�Ǳ��ع����С���⣬�Ϲ���������");
            	weiboData.put("updateTime", new Date());
            	weibo.Publish(weiboData);
            }  
        };  
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();  
        service.scheduleAtFixedRate(runnable, 0, 2, TimeUnit.SECONDS); 
	}
}
