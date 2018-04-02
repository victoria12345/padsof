import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DemandanteTest {
	
	List<Oferta> ofertas = new ArrayList<Oferta>();
	Demandante deman;
	LocalDate ini;
	Oferta o;
	Oferta ofer;
	
	@Before
	public void before() {
		deman = new Demandante(1L);
		ini = LocalDate.of(2018, 1, 1);
		o = null;
		ofer = new OfertaResidencial(1, 10, ini, 10);
		ofer.setDisp(Disponibilidad.RESERVADA);
	}
	@Test
	public void testSetReservas() {
		deman.setReservas(ofertas);
		
		deman.setReservas(null);
		
		assertEquals(deman.getReservas(), ofertas);
	}

	@Test
	public void testSetOfertas() {
		deman.setOfertas(ofertas);
		
		deman.setOfertas(null);
		
		assertEquals(deman.getOfertas(), ofertas);
	}

	@Test
	public void testAddReserva1() {
		deman.addReserva(ofer);
		assertFalse(deman.getReservas().contains(ofer));
	}
	
	@Test
	public void testAddReserva2() {
		deman.addReserva(o);
		assertFalse(deman.getReservas().contains(o));
	}

	@Test
	public void testAddOferta1() {
		deman.addOferta(ofer);
		assertFalse(deman.getOfertas().contains(ofer));
	
	}
	
	@Test
	public void testAddOferta2() {
		deman.addOferta(o);
		assertFalse(deman.getReservas().contains(o));
	}


}
