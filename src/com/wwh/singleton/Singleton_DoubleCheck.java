package com.wwh.singleton;

public class Singleton_DoubleCheck {

		//�ӳټ��أ�˫�ؼ��
		/*����û�йؼ���volatile������£������߳�A��B�����ǵ�һ�ε��øõ����������߳�A��ִ��instance = new Instance()���ù��췽����һ����ԭ�Ӳ���������ռ䣬��ʼ������ֵ��
		 * ����JAVA��ָ�������򣬿��ܻ���ִ��instance�ĸ�ֵ�������ò���ʵ��ֻ�����ڴ��п���һƬ�洢����������ֱ�ӷ����ڴ�����ã�֮��instance�㲻Ϊ���ˣ�
		 * ����ʵ�ʵĳ�ʼ������ȴ��û��ִ�У�������ڴ�ʱ�߳�B���룬�ͻῴ��һ����Ϊ�յĵ��ǲ�������û����ɳ�ʼ������Instance����Ȼ�󷵻��˸ò������Ķ���
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
		
		/*public synchronized Singleton_DoubleCheck getResource(){  //���ַ�ʽÿ�λ�ȡ����Ҫͬ����Ч�ʵͣ���Ϊֻ�е�һ�βſ��ܳ����̳߳�ͻ��
			  if (instance == null){   
			        instance = new Singleton_DoubleCheck();    
			  }  
			  return instance;  
		} */
}
