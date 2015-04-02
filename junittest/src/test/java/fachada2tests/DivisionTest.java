package fachada2tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mjacobo.fachada2.Division;

public class DivisionTest {

	@Test  
    public void testDivide() {  
        Division division = new Division(4, 2);  
        int resultado = division.divide();  
        assertTrue(resultado == 2);  
    } 

}
