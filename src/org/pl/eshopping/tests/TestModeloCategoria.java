package org.pl.eshopping.tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.pl.eshopping.dto.Categoria;

@RunWith(Parameterized.class)
public class TestModeloCategoria {
	
	private String n;
	private String d;
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { "Noticias", "Bla" }, { "", ""}, { "Deportes", "" } ,  { "", "Bla" } 
           });
    }
    
    public TestModeloCategoria(String na, String da) {
        n=na;
        d=da;
    }
    
    @Test
    public void test() {	
        Categoria cat = new Categoria();
        	cat.setNombre(n);
        	cat.setDescripcion(d);            
        	org.junit.Assert.assertFalse("It can't be empty","".equals(cat.getNombre()));
    }

}
