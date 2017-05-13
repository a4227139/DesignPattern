package com.wwh.factory;

import com.wwh.factory.product.AirConditioner;
import com.wwh.factory.product.Engine;
/*
 * 抽象工厂模式使用了工厂方法，用于创建整个产品家族，工厂方法模式用于创建单个产品。
 * 抽象工厂模式使用组合，工厂方法模式使用继承。
 * 
 */
public interface PartsFactory {

	public abstract Engine createEngine();
	public abstract AirConditioner createAirConditioner();
}
