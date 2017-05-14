package com.wwh.adapter;
/*
 * �������·��һֻѼ�ӣ���������һֻѼ�ӣ���δ����һֻѼ�ӣ�������һֻ��װ��Ѽ���������Ļ�
 * �˴��Ƕ�����������ʵ��Ŀ��ӿڣ����б�������
 * ����������Ŀ��ӿڵ�����ת���ɶԱ������߽ӿڵ�һ����������
 * ��װ����ģʽ���񣬶���װ�˶��󣬵�װ����ģʽʵ�ֵ���ԭ�ӿڣ������滻����װ�����������Ϊ����������ģʽ������ʵ�ֽӿ�ת��������Ŀ��ӿڵ������ñ���װ����ȥʵ�֣������ÿͻ�֪����
 */
public class TurkeyAdapter implements Duck{

	Turkey turkey;

	public TurkeyAdapter(Turkey turkey) {
		super();
		this.turkey = turkey;
	}

	@Override
	public void quack() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		//�𼦷��о���̣�������ɼ���
		for(int i=0;i<5;i++){
			turkey.fly();
		}
	}
	
}
