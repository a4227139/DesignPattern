package strategy.model;

public class Wizard extends Character{

	@Override
	public void useWeapon() {
		//do something special
		System.out.println("I'm a Wizard.");
		weaponBehavior.useWeapon();
	}

}
