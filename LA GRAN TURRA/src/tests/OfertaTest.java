package tests;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import Ofertas.Comentario;
import Ofertas.OfertaResidencial;
import Ofertas.OfertaVacacional;

import java.util.*;

public class OfertaTest {
	LocalDate ini, fin;
	OfertaResidencial ores;
	OfertaVacacional ovac;
	List<Comentario> coment = new ArrayList<Comentario>();
	Comentario c;
	
	@Before
	public void before() {
		ini = LocalDate.of(2018, 1, 2);
		fin = LocalDate.of(2018, 1, 8);
		ores = new OfertaResidencial(-10, ini, -1);
	
		ovac = new OfertaVacacional(10, ini, fin, -1);
		ores.setValoracion(10);
		ores.setDesc("desc");
		ores.setComentarios(coment);
		c = new Comentario(null, null, 1);
		coment.add(c);
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

	@Test
	public void testSetPrecio() {
		ovac.setPrecio(-1);
		assertEquals(ovac.getPrecio(), 10, 0);
	}

	@Test
	public void testSetValoracion() {
		ores.setValoracion(-1);
		assertEquals(ores.getValoracion(), 10, 0);
	}

	@Test
	public void testSetDesc() {
		ores.setDesc(null);
		assertEquals(ores.getDesc(), "desc");
	}

	@Test
	public void testSetComentarios() {
		ores.setComentarios(null);
		assertEquals(ores.getComentarios(), coment);
	}

	@Test
	public void testAddComentario2() {
		assertFalse(ores.addComentario(null));
	}
	
	@Test
	public void testAddComentario1() {
		assertFalse(ores.addComentario(c));
	}

	@Test
	public void testValorar1() {
		assertFalse(ores.valorar(-1));
	}
	
	@Test
	public void testValorar2() {
		assertFalse(ores.valorar(11));
	}
	
	@Test
	public void testSetNmeses() {
		ores.setNmeses(-1);
		assertEquals(ores.getNmeses(), 1);
	}
	
	@Test
	public void testSetFianza() {
		ovac.setFianza(-1);
		assertEquals(ovac.getFianza(), 0, 0);
	}

}
