package com.wwh.strategy;

import com.wwh.strategy.impl.KnifeBehavior;
import com.wwh.strategy.impl.WandBehavior;
import com.wwh.strategy.interfaces.WeaponBehavior;
import com.wwh.strategy.model.Assassin;
import com.wwh.strategy.model.Wizard;

public class Main {
	/*����ģʽ�������㷨��(��Ϊ)���ֱ��װ������������֮������໥�滻����ģʽ���㷨(��Ϊ)�ı仯������ʹ�����ǵ��û���
	 * ��ģʽ���ɱ䲿�ֳ�ȡ�������з�װ(�����Ŀɱ䲿������������Ϊ)��ʹ�ɱ䲿���벻�ɱ䲿�ֽ����Ȼ�ڶ����ģʽ���Դ�ΪĿ�ġ�
	 * */
	
	public static void main(String[] args) {
		Assassin assassin=new Assassin();
		WeaponBehavior weaponBehavior=new KnifeBehavior();
		assassin.setWeaponBehavior(weaponBehavior);//����ӿڣ�����ʱ��̬������Ϊ
		assassin.useWeapon();
		Wizard wizard=new Wizard();
		weaponBehavior=new WandBehavior();
		wizard.setWeaponBehavior(weaponBehavior);
		wizard.useWeapon();
	}
}
