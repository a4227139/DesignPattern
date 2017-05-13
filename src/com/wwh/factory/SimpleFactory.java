package com.wwh.factory;

import com.wwh.factory.product.BMW;
import com.wwh.factory.product.Benz;
import com.wwh.factory.product.Car;
/*
 * �򵥹��������Ͽ���ԭ�������Ҫ����һ�ֳ������ͱ����޸�ԭ��������ӡ�
 * ���Ҳ�Ʒ���Ϳ��ֻܺܶ࣬��һ�������ᵼ������Ӵ�
 */
public class SimpleFactory {

	public static Car createCar(String brand) throws Exception{
		if(brand.equals("BMW")){
			return new BMW();
		}else if (brand.equals("Benz")) {
			return new Benz();
		}else {
			throw new Exception("No Such Brand!");
		}
	}
}
