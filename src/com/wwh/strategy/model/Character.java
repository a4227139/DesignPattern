package com.wwh.strategy.model;

import com.wwh.strategy.interfaces.WeaponBehavior;

public abstract class Character {

	protected WeaponBehavior weaponBehavior;

	public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
		this.weaponBehavior = weaponBehavior;
	}

	abstract void useWeapon();
}
