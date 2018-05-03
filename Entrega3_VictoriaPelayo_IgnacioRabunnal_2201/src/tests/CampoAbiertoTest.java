package tests;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import excepciones.ArgumentoNoValido;
import inmuebles.CampoAbierto;

public class CampoAbiertoTest {
	
	CampoAbierto campo;
	
	@Before
	public void before() {
		campo = new CampoAbierto(null, null);
	}
	
	@Test
	public void testNewCampoAbierto() {			
		assertEquals(campo.getClave(), "NO CLAVE");
	}
	
	@Test
	public void test2NewCampoAbierto() {	
		assertEquals(campo.getValor(), "NO VALOR");
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testSetClave() throws ArgumentoNoValido {
		campo.setClave(null);
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testSetValor() throws ArgumentoNoValido{
		campo.setValor(null);
	}

}