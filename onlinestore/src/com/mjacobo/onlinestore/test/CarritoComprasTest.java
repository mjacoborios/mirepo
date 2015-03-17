package com.mjacobo.onlinestore.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mjacobo.onlinestore.model.Compra;
import com.mjacobo.onlinestore.model.Producto;
import com.mjacobo.onlinestore.tools.CarritoCompras;

public class CarritoComprasTest {

	CarritoCompras carritoCompras;
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		
		CarritoComprasTest test = new CarritoComprasTest();
		test.run(ctx);
		ctx.close();
	}
	
	public void run(AbstractApplicationContext ctx){
		
		carritoCompras = (CarritoCompras) ctx.getBean("carritoCompras");
		
		Producto p1 = new Producto();
		p1.setId("0000001");
		p1.setPrecio(10);
		
		Producto p2 = new Producto();
		p2.setId("0000002");
		p2.setPrecio(10);
		
		Producto p3 = new Producto();
		p3.setId("0000003");
		p3.setPrecio(10);
		
		Producto p4 = new Producto();
		p4.setId("0000004");
		p4.setPrecio(5);
		
		carritoCompras.agregaCompra(p1, 1);
		carritoCompras.agregaCompra(p2, 2);
		carritoCompras.agregaCompra(p3, 1);
		carritoCompras.agregaCompra(p1, 1);
		carritoCompras.agregaCompra(p2, 2);
		carritoCompras.agregaCompra(p3, 1);
		carritoCompras.agregaCompra(p4, 8);
		carritoCompras.agregaCompra(p4, 5);		
		
		imprimeCompras();		
		
		System.out.println("\n*******************  Eliminando del carrito a Producto : " + p4 + "  ****************");
		carritoCompras.eliminaCompra(p4);		
		imprimeCompras();
		
		System.out.println("\n*******************  Limpiando Carrito **********************");
		carritoCompras.eliminaTodo();
		imprimeCompras();
	
	}
	
	public void imprimeCompras(){
		System.out.println("\n------------------------DETALLE DE COMPRAS -------------------------");
		for( Compra compra : carritoCompras.obtenCompras()){
			System.out.println("PRODUCTO: " + compra.getProducto().getId() 
					+ " -- PZAS: (" + compra.getPzas() + " x $" + compra.getProducto().getPrecio() + ")"
					+ " -- MONTO: $" + compra.obtenTotalCompra());
		}
		System.out.println("--------------------------------------------------------------------");
		System.out.println( "TOTALES: " + carritoCompras.obtenTotalProductosComprados() 
				+ " PRODUCTOS  --- " + carritoCompras.obtenTotalPzasCompradas() 
				+ " PZAS  --- $" + carritoCompras.obtenTotalCompra() );
	}

}
