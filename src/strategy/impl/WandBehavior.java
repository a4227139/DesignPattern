package strategy.impl;

import strategy.interfaces.WeaponBehavior;

public class WandBehavior implements WeaponBehavior {

	@Override
	public void useWeapon() {
		System.out.println("Defeat monsters with wands.");
	}

}
