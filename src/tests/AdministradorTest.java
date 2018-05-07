package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import excepciones.ArgumentoNoValido;
import usuarios.*;;

public class AdministradorTest {
	
	Administrador admin;
	Usuario u;
	Demandante deman;
	
	@Before
	public void before() {
		admin = new Administrador();
		u = new Usuario("nick", "nombre", "apellido", "contraseña");
		deman = new Demandante("12345");
		u.getRoles().add(deman);
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testSetBloqueados() throws ArgumentoNoValido {
		admin.setBloqueados(null);
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testAddBloqueado() throws ArgumentoNoValido {
		admin.addBloqueado(u);
		admin.addBloqueado(u);
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testDelBloqueado() throws ArgumentoNoValido {
		admin.delBloqueado(u);
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testCambiarTarjeta1() throws ArgumentoNoValido {
		admin.cambiarTarjeta(u, "12345");
	}
	
	@Test
	public void testCambiarTarjeta2() throws ArgumentoNoValido {
		admin.addBloqueado(u);
		admin.cambiarTarjeta(u, "123456789");
		assertEquals("123456789", deman.getTarjeta());
	}
	

}
