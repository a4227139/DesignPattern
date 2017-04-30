package strategy.model;

import strategy.interfaces.WeaponBehavior;

public abstract class Character {

	protected WeaponBehavior weaponBehavior;

	public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
		this.weaponBehavior = weaponBehavior;
	}

	abstract void useWeapon();
}
