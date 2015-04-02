package com.mjacobo.fachada;

public class Suma {
	
	private int a;
	private int b;
	
	public Suma(int a, int b){
		this.a = a;
		this.b = b;
	}

	public int suma(){
		return a + b;
	}
	
	public int resta(){
		return a - b;
	}
}
