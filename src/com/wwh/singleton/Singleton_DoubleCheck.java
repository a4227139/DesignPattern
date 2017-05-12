package com.wwh.singleton;

public class Singleton_DoubleCheck {

		//延迟加载，双重检查
		/*假设没有关键字volatile的情况下，两个线程A、B，都是第一次调用该单例方法，线程A先执行instance = new Instance()，该构造方法是一个非原子操作（请求空间，初始化，赋值）
		 * 由于JAVA的指令重排序，可能会先执行instance的赋值操作，该操作实际只是在内存中开辟一片存储对象的区域后直接返回内存的引用，之后instance便不为空了，
		 * 但是实际的初始化操作却还没有执行，如果就在此时线程B进入，就会看到一个不为空的但是不完整（没有完成初始化）的Instance对象，然后返回了该不完整的对象
		 */
		private volatile static Singleton_DoubleCheck instance;
		public Singleton_DoubleCheck getResource() {  
			  if (instance == null) {   
			    synchronized(this){   
			      if (instance==null) {  
			    	  instance = new Singleton_DoubleCheck();    
			      }     
			    }    
			  }  
			  return instance;  
		}  
		
		/*public synchronized Singleton_DoubleCheck getResource(){  //这种方式每次获取对象都要同步，效率低（因为只有第一次才可能出现线程冲突）
			  if (instance == null){   
			        instance = new Singleton_DoubleCheck();    
			  }  
			  return instance;  
		} */
}
