import static org.junit.Assert.*;

import org.junit.Test;

public class OfertanteTest {
	
	@Test
	public void testAddInmueble() {
		Ofertante ofer = new Ofertante(1L);
		Inmueble i = new Inmueble(null, 1, null);
		
		ofer.addInmueble(i);
		
		assertEquals(ofer.getInmuebles().get(0), i);
	}

}
