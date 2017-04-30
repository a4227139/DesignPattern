package strategy.model;

public class Assassin extends Character{

	@Override
	public void useWeapon() {
		//do something special
		System.out.println("I'm an Assassin.");
		weaponBehavior.useWeapon();
	}
}
