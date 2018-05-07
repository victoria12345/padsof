package tests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import excepciones.ArgumentoNoValido;
import inmuebles.Inmueble;
import usuarios.*;

public class UsuarioTest {
	
	Usuario u, user;
	List<Rol> roles = new ArrayList<Rol>();
	Ofertante ofertante;
	Demandante deman;
	Inmueble i;
	
	@Before
	public void before() throws ArgumentoNoValido {
		u = new Usuario("nick", "nombre", "apellido", "contrasenia");
		u.setRoles(roles);
		ofertante = new Ofertante("12345");
		
		u.getRoles().add(ofertante);
		
		user = new Usuario("nick", "nombre", "apellido", "contrasenia");
		deman = new Demandante("12345");
		u.getRoles().add(deman);
	}
	
	
	@Test(expected = ArgumentoNoValido.class)
	public void testSetNick() throws ArgumentoNoValido {
		u.setNick(null);
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testSetNombre() throws ArgumentoNoValido {
		u.setNombre(null);
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testSetApellido() throws ArgumentoNoValido {
		u.setApellido(null);
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testSetContrasenia() throws ArgumentoNoValido {
		u.setContrasenia(null);
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testSetRoles() throws ArgumentoNoValido {
		u.setRoles(null);
	}

	@Test
	public void testIsBloqueado1() {
		ofertante.setBloqueado(true);
		assertTrue(u.isBloqueado());
	}
	
	@Test
	public void testIsBloqueado2() {
		assertFalse(user.isBloqueado());
	}


}
