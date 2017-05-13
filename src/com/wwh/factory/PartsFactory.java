package com.wwh.factory;

import com.wwh.factory.product.AirConditioner;
import com.wwh.factory.product.Engine;
/*
 * ���󹤳�ģʽʹ���˹������������ڴ���������Ʒ���壬��������ģʽ���ڴ���������Ʒ��
 * ���󹤳�ģʽʹ����ϣ���������ģʽʹ�ü̳С�
 * 
 */
public interface PartsFactory {

	public abstract Engine createEngine();
	public abstract AirConditioner createAirConditioner();
}
