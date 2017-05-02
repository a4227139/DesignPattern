package com.wwh.decoration;

public class Main {

	public static void main(String[] args) {
		Character character=new Clothes(new Sword(new Warrior(100)));
		System.out.println(character.showCombatEffectiveness());
	}
}
