package com.mjacobo.onlinestore.model;

public class Compra {
	
	private Producto producto;
	private int pzas;	
	
	public Compra(Producto producto, int pzas) {
		super();
		this.producto = producto;
		this.pzas = pzas;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getPzas() {
		return pzas;
	}
	public void setPzas(int pzas) {
		this.pzas = pzas;
	}
	
	public double obtenTotalCompra(){
		return pzas * producto.getPrecio();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((producto == null) ? 0 : producto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}
	
	
}
