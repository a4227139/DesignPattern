package com.wwh.adapter;
/*
 * 如果它走路像一只鸭子，叫起来像一只鸭子，它未必是一只鸭子，可能是一只包装了鸭子适配器的火鸡
 * 此处是对象适配器，实现目标接口，持有被适配者
 * 适配器将对目标接口的请求转换成对被适配者接口的一个或多个调用
 * 与装饰者模式很像，都包装了对象，但装饰者模式实现的是原接口，可以替换被包装对象，添加新行为。而适配器模式是用于实现接口转换，将对目标接口的请求用被包装对象去实现，并不让客户知道。
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
		//火鸡飞行距离短，让它多飞几次
		for(int i=0;i<5;i++){
			turkey.fly();
		}
	}
	
}
