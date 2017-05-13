package com.wwh.factory;

import com.wwh.factory.product.BMW;
import com.wwh.factory.product.Benz;
import com.wwh.factory.product.Car;
/*
 * 简单工厂不符合开闭原则，如果想要新增一种车辆，就必须修改原代码来添加。
 * 而且产品类型可能很多，只有一个工厂会导致其很庞大。
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
