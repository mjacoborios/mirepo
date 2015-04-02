package fachadatests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mjacobo.fachada.Multiplicacion;

public class MultiplicacionTest {

	@Test  
    public void testMultiplicar() {  
        Multiplicacion multiplicacion = new Multiplicacion(3, 5);  
        int resultado = multiplicacion.multiplicar();  
        assertTrue(resultado == 15);  
    } 

}
