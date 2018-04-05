package tests;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import excepciones.ArgumentoNoValido;
import ofertas.*;
import usuarios.Demandante;

public class DemandanteTest {
	
	List<Oferta> ofertas = new ArrayList<Oferta>();
	Demandante deman;
	LocalDate ini;
	Oferta ofer;
	
	@Before
	public void before() {
		deman = new Demandante("12345");
		ini = LocalDate.of(2018, 1, 1);
		ofer = new OfertaResidencial(10, ini, 10);
		ofer.setDisp(Disponibilidad.RESERVADA);
	}


	@Test(expected = ArgumentoNoValido.class)
	public void testSetOfertas() throws ArgumentoNoValido {
		deman.setOfertas(null);
	}


	@Test(expected = ArgumentoNoValido.class)
	public void testAddOferta() throws ArgumentoNoValido {
		deman.addOferta(null);
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testDelOferta() throws ArgumentoNoValido{
		Oferta o = new OfertaResidencial(1, ini, 1);
		deman.delOferta(o);
	}
	


}