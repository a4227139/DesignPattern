package com.wwh.decoration;

public class Warrior extends Character{

	public Warrior(int CombatEffectiveness) {
		this.CombatEffectiveness=CombatEffectiveness;
	}
	@Override
	public int showCombatEffectiveness() {
		return CombatEffectiveness;
	}
	
}
