package com.wwh.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class testCopyOnWrite {
	
	static CopyOnWriteArrayList<Integer> copyOnWriteArrayList;
	static int count=0;
	public static void main(String[] args) throws InterruptedException {
		List<Integer> list=new ArrayList<>();
		list.add(5);list.add(4);list.add(3);list.add(2);list.add(1);
		/*for(Integer i:list){//fail-fast���ƣ��ڲ��������н��е�������ʱ�����������̶߳�����нṹ�Ե��޸ģ���ʱ�������������֪�������������׳�ConcurrentModificationException�쳣��
			if(i%2==0) list.remove(i);
		}*/
		/*
		 * CopyOnWrite������дʱ���Ƶ�����ͨ�׵�����ǵ���һ���������Ԫ�ص�ʱ�򣬲�ֱ������ǰ������ӣ������Ƚ���ǰ��������Copy�����Ƴ�һ���µ�������Ȼ���µ����������/ɾ��Ԫ�أ�
		 * ���/ɾ����Ԫ��֮���ٽ�ԭ����������ָ���µ�������ÿ���޸Ľṹ��Ҫ���ƣ����Ի���ɺܶ�Ŀռ��˷ѣ���������GC�����Ҹ�����ֻ�ܱ�֤���ݵ�����һ���ԣ����ܱ�֤���ݵ�ʵʱһ���ԡ�
		 * CopyOnWrite������һ�ֶ�д�����˼�룬����д��ͬ���������ô��ǿ��Զ�CopyOnWrite�������в����Ķ���������Ҫ��������Ϊ��ǰ������������κ�Ԫ�ء�
		 * CopyOnWrite���������ڶ�����ԶԶ����д�����ĳ����
		 */
		copyOnWriteArrayList=new CopyOnWriteArrayList<>(list);
		for(Integer i:copyOnWriteArrayList){
			if(i%2==0){
				copyOnWriteArrayList.remove(i);
			}
		}
		showList(copyOnWriteArrayList);
		showList(list);
		Iterator<Integer> it=list.iterator();
		while(it.hasNext()){//��iterator��remove����Ҳ�����ڵ�����ɾ����
			if(it.next()%2==0){
				it.remove();
			}
		}
		showList(list);
		testCopyOnWrite test=new testCopyOnWrite();
		test.testCurrCopyOnWrite();
		Thread.sleep(1000);//����һ��ʱ�䣬�����߳�ִ�����
		showList(copyOnWriteArrayList);
		test.testCurrCopyOnWrite();
		showList(copyOnWriteArrayList);//ÿ��ִ�еõ������һ������Ϊ�������������Ԫ�غ�ĵ�ǰ����
	}
	
	public static void showList(List list){
		System.out.print("\nList : ");
		for(Object o:list){
			System.out.print(o+",");
		}
	}
	/*
	 * �ڶ��߳�дʱCopyOnWrite�������ǻ������,һ���߳�ִ����Ż�ִ����һ��
	 */
	public void testCurrCopyOnWrite(){
		new Thread(new CurrCopyOnWriteThread()).start();
		new Thread(new CurrCopyOnWriteThread()).start();
		new Thread(new CurrCopyOnWriteThread()).start();
	}
		
	class CurrCopyOnWriteThread implements Runnable{
		
		@Override
		public void run() {
			count=0;
			for(Integer i:copyOnWriteArrayList){//����ʱ������δ���Ԫ�صľ��б�
				count++;
				copyOnWriteArrayList.add(count);
			}
		}
		
	}
}
