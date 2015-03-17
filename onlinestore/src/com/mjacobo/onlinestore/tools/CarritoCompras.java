package com.mjacobo.onlinestore.tools;

import java.util.LinkedList;
import java.util.List;
import com.mjacobo.onlinestore.model.Compra;
import com.mjacobo.onlinestore.model.Producto;

public class CarritoCompras {

	List<Compra> compras;

	public CarritoCompras(){
		this.compras = new LinkedList<Compra>();
	}	

	/**
	 * Agrega una compra al Carrito de Compras, si ya existe actualiza las pzas
	 * @param productoAComprar
	 * @param pzas
	 */
	public void agregaCompra(Producto productoAComprar, int pzas){
		
		if(!validaCompra(productoAComprar, pzas))
			return;
		
		Compra compra = new Compra(productoAComprar, pzas);
		int index = compras.indexOf(compra);
		if(index > -1){
			Compra compraLista = compras.get(index);
			compras.remove(index);			
			compra.setPzas( compraLista.getPzas() + compra.getPzas() );
			compras.add(compra);
			
		}else{
			compras.add(compra);
		}
	}

	/**
	 * 
	 * @param productoAEliminar
	 * @param pzasAEliminar
	 */
	public void eliminaCompra(Producto productoAEliminar, int pzasAEliminar){
		
		if( !validaCompra(productoAEliminar, pzasAEliminar))
			return;
		
		Compra compraAEliminar = new Compra(productoAEliminar, pzasAEliminar);
		
		int index = compras.indexOf(compraAEliminar);
		if( index > -1 ){
			Compra compra = compras.get(index);
			int piezasCompradas = compra.getPzas();
			
			if( compraAEliminar.getPzas() >= compra.getPzas() ){
				eliminaCompra(productoAEliminar);
			}else{
				piezasCompradas -= pzasAEliminar; 
				actualizaCompra(productoAEliminar, piezasCompradas);
			}
		}
	}

	public void actualizaCompra(Producto productoAActualizar, int pzas){
		
		if(!validaCompra(productoAActualizar, pzas))
			return;
		
		Compra compra =  new Compra(productoAActualizar, pzas);
		
		if(compras.contains(compra)){
			compras.remove(compra);
			compras.add(compra);
		}
	}
	
	private boolean validaCompra(Producto productoAValidar, int pzas){
		if( productoAValidar == null || pzas <= 0)
			return false;
		else
			return true;
	}

	public void eliminaCompra(Producto productoAEliminar){
		Compra compra = new Compra(productoAEliminar, 0);
		if(compras.contains(compra)){
			compras.remove(compra);
		}
	}

	public double obtenTotalCompra(){
		double totalCompras = 0.0;

		for(Compra compra : compras){
			totalCompras += compra.obtenTotalCompra();
		}

		return totalCompras;
	}

	public int obtenTotalProductosComprados(){
		return compras.size();
	}

	public int obtenTotalPzasCompradas(){
		int totalPzasCompradas = 0;

		for(Compra compra : compras){
			totalPzasCompradas += compra.getPzas();
		}

		return totalPzasCompradas;
	}
	
	public List<Compra> obtenCompras(){
		return compras;
	}
	
	public void eliminaTodo(){
		compras.clear();
	}

}
