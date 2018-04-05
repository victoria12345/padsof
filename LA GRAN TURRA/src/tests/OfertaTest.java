package tests;
import static org.junit.Assert.*;

import java.time.LocalDate;

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
import usuarios.*;

import java.util.*;

public class OfertaTest {
	LocalDate ini, fin;
	OfertaResidencial ores;
	OfertaVacacional ovac;
	List<Comentario> coment = new ArrayList<Comentario>();
	Comentario c;
	Demandante deman;

	
	@Before
	public void before() throws ArgumentoNoValido {
		ini = LocalDate.of(2018, 1, 2);
		fin = LocalDate.of(2018, 1, 8);
		ores = new OfertaResidencial(-10, ini, -1);
	
		ovac = new OfertaVacacional(10, ini, fin, -1);
		ovac.setEstado(Estado.ACEPTADA);
		ores.setValoracion(10);
		ores.setDesc("desc");
		ores.setComentarios(coment);
		ores.setEstado(Estado.ACEPTADA);
		c = new Comentario(null, null, 1);
		coment.add(c);
		deman = new Demandante("12345");
	}
	
	@Test
	public void testOferta1() {
		assertEquals(ores.getPrecio(), 0, 0);
	}
	
	@Test
	public void testOferta2() {
		assertEquals(ores.getNmeses(), 1);
	}
	
	@Test
	public void testOferta3() {
		assertEquals(ovac.getFianza(), 0, 0);
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testSetPrecio() throws ArgumentoNoValido {
		ovac.setPrecio(-1);
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testSetValoracion() throws ArgumentoNoValido {
		ores.setValoracion(-1);
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testSetDesc() throws ArgumentoNoValido {
		ores.setDesc(null);
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testSetComentarios() throws ArgumentoNoValido {
		ores.setComentarios(null);
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testSetBloqueados() throws ArgumentoNoValido {
		ores.setBloqueados(null);
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testAddComentario2() throws ArgumentoNoValido {
		ores.addComentario(null);
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testAddComentario1() throws ArgumentoNoValido {
		ores.addComentario(c);
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testValorar1() throws ArgumentoNoValido {
		ores.valorar(-1);
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testValorar2() throws ArgumentoNoValido {
		ores.valorar(11);
	}
	
	
	@Test(expected = InvalidCardNumberException.class)
	public void testPagar() throws InvalidCardNumberException, FailedInternetConnectionException, OrderRejectedException {
		ores.pagar(deman.getTarjeta(), "prueba");
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testSetNmeses() throws ArgumentoNoValido {
		ores.setNmeses(-1);
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testSetFianza() throws ArgumentoNoValido {
		ovac.setFianza(-1);
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testAddBloqueado2() throws ArgumentoNoValido {
		ores.addBloqueado(null);
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testAddBloueado1() throws ArgumentoNoValido {
		ores.getBloqueados().add(deman);
		ores.addBloqueado(deman);
	}
	
	@Test(expected = UsuarioBloqueado.class)
	public void testReservarVacacional1() throws ArgumentoNoValido, UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas {
		ovac.addBloqueado(deman);
		ovac.reservar(deman, ini);
	}
	
	@Test(expected = OfertaNoDisponible.class)
	public void testReservarVacacional2() throws UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas {
		ovac.setEstado(Estado.RECHAZADA);
		ovac.reservar(deman, ini);
	}
	
	@Test(expected = OfertaNoDisponible.class)
	public void testReservarVacacional3() throws UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas {
		ovac.setDisp(Disponibilidad.RESERVADA);
		ovac.reservar(deman, ini);
	}
	
	@Test(expected = DemasiadasOfertasReservadas.class)
	public void testReservarVacacional4() throws UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas {
		OfertaVacacional reserva = new OfertaVacacional(10, ini, fin, 10);
		reserva.setEstado(Estado.ACEPTADA);
		reserva.reservar(deman, ini);
		ovac.reservar(deman, ini);
	}
	
	@Test
	public void testReservarVacacional5() throws UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas {
		ovac.reservar(deman, ini);
		assertEquals(deman.getVacacional(), ovac);
	}
	
	@Test(expected = UsuarioBloqueado.class)
	public void testReservarResidencial1() throws ArgumentoNoValido, UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas{
		ores.addBloqueado(deman);
		ores.reservar(deman, ini);
	}
	
	@Test(expected = OfertaNoDisponible.class)
	public void testReservarResidencial2() throws ArgumentoNoValido, UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas{
		ores.setEstado(Estado.RECHAZADA);
		ores.reservar(deman, ini);
	}
	
	@Test(expected = OfertaNoDisponible.class)
	public void testReservarResidencial3() throws ArgumentoNoValido, UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas{
		ores.setDisp(Disponibilidad.RESERVADA);
		ores.reservar(deman, ini);
	}
	
	@Test(expected = DemasiadasOfertasReservadas.class)
	public void testReservarResidencial4() throws ArgumentoNoValido, UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas{
		OfertaResidencial reserva2 = new OfertaResidencial(10, ini, 10);
		reserva2.setEstado(Estado.ACEPTADA);
		reserva2.reservar(deman, ini);
		ores.reservar(deman, ini);
	}
	
	@Test
	public void testReservarResidencial5() throws ArgumentoNoValido, UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas{
		ores.reservar(deman, ini);
		assertEquals(deman.getResidencial(), ores);
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testCancelarVacacional1() throws UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas, ArgumentoNoValido {
		OfertaVacacional cancelada1 = new OfertaVacacional(1, ini, fin, 1);
		cancelada1.setEstado(Estado.ACEPTADA);
		cancelada1.reservar(deman, ini);
		ovac.cancelar(deman, false);
	}
	
	@Test
	public void testCancelarVacacional2() throws UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas, ArgumentoNoValido {
		ovac.reservar(deman, ini);
		ovac.cancelar(deman, true);
		assertTrue(ovac.getBloqueados().contains(deman));
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testCancelarResidencial1() throws UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas, ArgumentoNoValido {
		OfertaResidencial cancelada2 = new OfertaResidencial(1, ini, 1);
		cancelada2.setEstado(Estado.ACEPTADA);
		cancelada2.reservar(deman, ini);
		ovac.cancelar(deman, false);
	}
	
	@Test
	public void testCancelarResidencial2() throws UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas, ArgumentoNoValido {
		ores.reservar(deman, ini);
		ores.cancelar(deman, true);
		assertTrue(ores.getBloqueados().contains(deman));
	}
	
	
	

}
