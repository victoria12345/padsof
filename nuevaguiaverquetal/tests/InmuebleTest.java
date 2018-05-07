package tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import excepciones.ArgumentoNoValido;
import inmuebles.*;
import ofertas.*;

import java.util.*;

public class InmuebleTest {
	
	Inmueble inmu;
	Inmueble i;
	List<CampoAbierto> ca = new ArrayList<CampoAbierto>();
	List<Oferta> ofer = new ArrayList<Oferta>();
	
	
	@Before
	public void before() throws ArgumentoNoValido {
		inmu = new Inmueble(null, 28040, null);
		i = new Inmueble("loc", 28040, "desc");
	}

	@Test
	public void testInmueble1() {
		assertEquals(inmu.getLocalizacion(), "No especificado");
	}
	
	public void testInmueble2() {
		assertEquals(inmu.getDescripcion(), "No especificado");
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testSetLocalizacion() throws ArgumentoNoValido {
		i.setLocalizacion(null);
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testSetDescripcion() throws ArgumentoNoValido {
		i.setDescripcion(null);
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testAddCampo() throws ArgumentoNoValido {
		i.addCampo(null);
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testAsociarOferta() throws ArgumentoNoValido {
		i.asociarOferta(null);
	}

}
