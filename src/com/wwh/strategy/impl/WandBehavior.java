package com.wwh.strategy.impl;

import com.wwh.strategy.interfaces.WeaponBehavior;

public class WandBehavior implements WeaponBehavior {

	@Override
	public void useWeapon() {
		System.out.println("Defeat monsters with wands.");
	}

}
