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
		/*for(Integer i:list){//fail-fast机制，在并发集合中进行迭代操作时，若有其他线程对其进行结构性的修改，这时迭代器会立马感知到，并且立即抛出ConcurrentModificationException异常。
			if(i%2==0) list.remove(i);
		}*/
		/*
		 * CopyOnWrite容器即写时复制的容器通俗的理解是当往一个容器添加元素的时候，不直接往当前容器添加，而是先将当前容器进行Copy，复制出一个新的容器，然后新的容器里添加/删除元素，
		 * 添加/删除完元素之后，再将原容器的引用指向新的容器，每次修改结构都要复制，所以会造成很多的空间浪费，容易引起GC。而且该容器只能保证数据的最终一致性，不能保证数据的实时一致性。
		 * CopyOnWrite容器是一种读写分离的思想，读和写不同的容器，好处是可以对CopyOnWrite容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元素。
		 * CopyOnWrite容器适用于读操作远远大于写操作的场景里。
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
		while(it.hasNext()){//用iterator的remove方法也可以在迭代中删除。
			if(it.next()%2==0){
				it.remove();
			}
		}
		showList(list);
		testCopyOnWrite test=new testCopyOnWrite();
		test.testCurrCopyOnWrite();
		Thread.sleep(1000);//休眠一段时间，等子线程执行完毕
		showList(copyOnWriteArrayList);
		test.testCurrCopyOnWrite();
		showList(copyOnWriteArrayList);//每次执行得到结果不一样，因为读的是正在添加元素后的当前数据
	}
	
	public static void showList(List list){
		System.out.print("\nList : ");
		for(Object o:list){
			System.out.print(o+",");
		}
	}
	/*
	 * 在多线程写时CopyOnWrite容器还是会加锁的,一个线程执行完才会执行下一个
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
			for(Integer i:copyOnWriteArrayList){//迭代时读的是未添加元素的旧列表
				count++;
				copyOnWriteArrayList.add(count);
			}
		}
		
	}
}
