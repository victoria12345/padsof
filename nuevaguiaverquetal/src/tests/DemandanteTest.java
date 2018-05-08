package tests;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.telecard.FailedInternetConnectionException;
import es.uam.eps.padsof.telecard.InvalidCardNumberException;
import es.uam.eps.padsof.telecard.OrderRejectedException;
import excepciones.ArgumentoNoValido;
import excepciones.DemasiadasOfertasReservadas;
import excepciones.OfertaNoDisponible;
import excepciones.UsuarioBloqueado;
import ofertas.*;
import usuarios.Demandante;

public class DemandanteTest {
	
	List<Oferta> ofertas = new ArrayList<Oferta>();
	Demandante deman;
	LocalDate ini;
	Oferta ofer;
	
	@Before
	public void before() {
		deman = new Demandante("1234567891234567");
		ini = LocalDate.of(2018, 1, 1);
		ofer = new OfertaResidencial(10, ini, 10);
		ofer.setDisp(Disponibilidad.RESERVADA);
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
	
	@Test
	public void testPagarOferta1() throws UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas, InvalidCardNumberException, FailedInternetConnectionException, OrderRejectedException, ArgumentoNoValido {
		OfertaResidencial ores = new OfertaResidencial(1, ini, 1);
		ores.setEstado(Estado.ACEPTADA);
		ores.reservar(deman, ini);
		deman.pagarOferta(ores, "concepto");
		assertNull(deman.getResidencial());
	}
	
	@Test
	public void testPagarOferta2() throws UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas, InvalidCardNumberException, FailedInternetConnectionException, OrderRejectedException, ArgumentoNoValido {
		LocalDate fin = LocalDate.of(2019, 1, 1);
		OfertaVacacional ovac = new OfertaVacacional(1, ini, fin, 1);
		ovac.setEstado(Estado.ACEPTADA);
		ovac.reservar(deman, ini);
		deman.pagarOferta(ovac, "concepto");
		assertNull(deman.getVacacional());
	}
	

}