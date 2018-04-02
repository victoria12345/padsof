import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
	
	@Test
	public void testSetClave() {
		campo.setClave("clave");
		
		campo.setClave(null);
		
		assertNotNull(campo.getClave());
	}
	
	@Test
	public void testSetValor() {
		campo.setValor("valor");
		
		campo.setValor(null);
		
		assertNotNull(campo.getValor());
	}

}
