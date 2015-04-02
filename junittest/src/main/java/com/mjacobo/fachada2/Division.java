package com.mjacobo.fachada2;

public class Division {
	
	private int a;
	private int b;
	
	public Division(int a, int b){
		this.a = a;
		this.b = b;
	}

	public int divide(){
		return a / b;
	}
}
