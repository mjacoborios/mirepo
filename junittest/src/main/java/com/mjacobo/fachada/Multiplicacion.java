package com.mjacobo.fachada;

public class Multiplicacion {
	
	private int a;
	private int b;
	
	public Multiplicacion(int a, int b){
		this.a = a;
		this.b = b;
	}

	public int multiplicar(){
		return a * b;
	}
}
