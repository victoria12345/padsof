import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class InmuebleTest {
	
	Inmueble inmu;
	Inmueble i;
	List<CampoAbierto> ca = new ArrayList<CampoAbierto>();
	List<Oferta> ofer = new ArrayList<Oferta>();
	
	
	@Before
	public void before() {
		inmu = new Inmueble(null, 28040, null);
		i = new Inmueble("loc", 28040, "desc");
		i.setCampos(ca);
		i.setOfertas(ofer);
		
	}

	@Test
	public void testInmueble1() {
		assertEquals(inmu.getLocalizacion(), "No especificado");
	}
	
	public void testInmueble2() {
		assertEquals(inmu.getDescripcion(), "No especificado");
	}

	@Test
	public void testSetLocalizacion() {
		i.setLocalizacion(null);
		assertEquals(i.getLocalizacion(), "loc");
	}

	@Test
	public void testSetDescripcion() {
		i.setDescripcion(null);
		assertEquals(i.getDescripcion(), "desc");
	}

	@Test
	public void testSetCampos() {
		i.setCampos(null);
		assertEquals(i.getCampos(), ca);
	}

	@Test
	public void testSetOfertas() {
		i.setOfertas(null);
		assertEquals(i.getOfertas(), ofer);
	}

	@Test
	public void testAddCampo() {
		CampoAbierto c = null;
		i.addCampo(c);
		assertFalse(i.getCampos().contains(c));
	}

	@Test
	public void testAsociarOferta() {
		OfertaResidencial oferta = null;
		i.asociarOferta(oferta);
		assertFalse(i.getOfertas().contains(oferta));
	}

}
