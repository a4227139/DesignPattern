package com.wwh.strategy;

import com.wwh.strategy.impl.KnifeBehavior;
import com.wwh.strategy.impl.WandBehavior;
import com.wwh.strategy.interfaces.WeaponBehavior;
import com.wwh.strategy.model.Assassin;
import com.wwh.strategy.model.Wizard;

public class Main {
	/*策略模式，定义算法族(行为)，分别封装起来，让它们之间可以相互替换，此模式让算法(行为)的变化独立于使用它们的用户。
	 * 该模式将可变部分抽取出来进行封装(该例的可变部分是武器的行为)，使可变部分与不可变部分解耦，当然众多设计模式都以此为目的。
	 * */
	
	public static void main(String[] args) {
		Assassin assassin=new Assassin();
		WeaponBehavior weaponBehavior=new KnifeBehavior();
		assassin.setWeaponBehavior(weaponBehavior);//面向接口，运行时动态决定行为
		assassin.useWeapon();
		Wizard wizard=new Wizard();
		weaponBehavior=new WandBehavior();
		wizard.setWeaponBehavior(weaponBehavior);
		wizard.useWeapon();
	}
}
