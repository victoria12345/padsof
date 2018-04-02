import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class UsuarioTest {
	
	Usuario u, user;
	List<Rol> roles = new ArrayList<Rol>();
	Ofertante ofertante;
	Demandante deman;
	Inmueble i;
	
	@Before
	public void before() {
		u = new Usuario("nick", "nombre", "apellido", "contrasenia");
		u.setRoles(roles);
		ofertante = new Ofertante(1L);
		ofertante.setBloqueado(true);
		u.getRoles().add(ofertante);
		i = new Inmueble("loc", 28040, "desc");
		
		user = new Usuario("nick", "nombre", "apellido", "contrasenia");
		u.setRoles(roles);
		deman = new Demandante(1L);
		u.getRoles().add(deman);
	}
	
	
	@Test
	public void testSetNick() {
		u.setNick(null);
		assertEquals(u.getNick(), "nick");
	}

	@Test
	public void testSetNombre() {
		u.setNombre(null);
		assertEquals(u.getNombre(), "nombre");
	}

	@Test
	public void testSetApellido() {
		u.setApellido(null);
		assertEquals(u.getApellido(), "apellido");
	}

	@Test
	public void testSetContrasenia() {
		u.setContrasenia(null);
		assertEquals(u.getContrasenia(), "contrasenia");
	}

	@Test
	public void testSetRoles() {
		u.setRoles(null);
		assertEquals(u.getRoles(), roles);
	}

	@Test
	public void testIsBloqueado1() {
		assertTrue(u.isBloqueado());
	}
	
	@Test
	public void testIsBloqueado2() {
		assertFalse(user.isBloqueado());
	}

	@Test
	public void testAddInmueble1() {
		assertTrue(u.addInmueble(i));
	}
	
	@Test
	public void testAddInmueble2() {
		assertFalse(user.addInmueble(i));
	}


}
