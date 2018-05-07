package tests;
import org.junit.Before;
import org.junit.Test;

import excepciones.ArgumentoNoValido;
import inmuebles.Inmueble;
import usuarios.Ofertante;

public class OfertanteTest {
	
	Ofertante ofer;
	Inmueble i;
	
	@Before
	public void before() throws ArgumentoNoValido {
		ofer = new Ofertante("1");
		i = new Inmueble(null, 1, null);
		ofer.addInmueble(i);
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testSetInmuebles() throws ArgumentoNoValido {
		ofer.setInmuebles(null);
	}
	
	
	@Test(expected = ArgumentoNoValido.class)
	public void testAddInmueble() throws ArgumentoNoValido {
		ofer.addInmueble(i);
	}

}
