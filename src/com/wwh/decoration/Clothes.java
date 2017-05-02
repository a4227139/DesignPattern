package com.wwh.decoration;

public class Clothes extends Character{

	Character character;
	
	public Clothes(Character character) {
		super();
		this.character = character;
	}


	@Override
	public int showCombatEffectiveness() {
		return 5+character.showCombatEffectiveness();
	}

}
