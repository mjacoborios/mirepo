package fachadatests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mjacobo.fachada.Suma;

public class SumaTest {

	public Suma suma;
	
	@Before
	public void antesDelTest(){
		this.suma = new Suma(3,5);
	}
	
	@After  
    public void despuesDelTest() {  
        /** 
         * La etiqueta @After es la antítesis de @Before. 
         * Simplemente este metodo se ejecutara despues de 
         * ejecutar todos los tests de esta clase. 
         */  
        // en este caso no hago nada, solo esta de ejemplo  
    }
	
	@Test  
    public void testSuma() {  
        /** 
         * Marcais el metodo con la etiqueta @Test y es 
         * importante que el nombre del metodo comience 
         * siempre por test. 
         */  
        int resultado = this.suma.suma();  
        // con esto verificamos que el resultado es el esperado  
        assertTrue(resultado == 8);  
    }  
  
    @Test  
    public void testResta() {  
        int resultado = this.suma.resta();  
        assertTrue(resultado == -2);  
    }  
	
	

}
