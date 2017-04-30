package strategy.impl;

import strategy.interfaces.WeaponBehavior;

public class KnifeBehavior implements WeaponBehavior{

	@Override
	public void useWeapon() {
		System.out.println("With a knife to kill the high officials and noble lords.");
	}

}
