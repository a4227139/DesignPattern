package com.wwh.decoration;

public class Sword extends Character{//�뱻�������͹�ͬ�Ľӿڻ��࣬�Ա��滻

	Character character;//�����ζ���
	
	public Sword(Character character) {
		super();
		this.character = character;
	}

	@Override
	public int showCombatEffectiveness() {//��д�ķ���
		return 10+character.showCombatEffectiveness();
	}
	
}
