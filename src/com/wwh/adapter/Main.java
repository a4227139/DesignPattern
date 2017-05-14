package com.wwh.adapter;

public class Main {

	public static void main(String[] args) {
		Turkey turkey=new WildTurkey();
		Duck duck=new TurkeyAdapter(turkey);
		duck.quack();
		duck.fly();
	}
}
