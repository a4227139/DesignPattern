package com.wwh.decoration;

public class Sword extends Character{//与被修饰类型共同的接口或父类，以便替换

	Character character;//被修饰对象
	
	public Sword(Character character) {
		super();
		this.character = character;
	}

	@Override
	public int showCombatEffectiveness() {//重写的方法
		return 10+character.showCombatEffectiveness();
	}
	
}
