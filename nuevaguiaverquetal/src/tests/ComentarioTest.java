package tests;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import excepciones.ArgumentoNoValido;
import ofertas.Comentario;
import usuarios.Usuario;

public class ComentarioTest {

	Comentario com;
	Usuario u;
	Usuario user = null;
	List<Comentario> respuestas = new ArrayList<Comentario>();
	
	@Before
	public void before() throws ArgumentoNoValido {
		u = new Usuario("nick","nombre", "apellido", "contrasenia" );
		com = new Comentario(u, "texto", 2);
	}
	@Test
	public void testComentario() {
		Comentario comentario = new Comentario(u, null, 1);
		assertEquals(comentario.getTexto(), "no texto");
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testSetTexto() throws ArgumentoNoValido {
		com.setTexto(null);
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testSetUsuario() throws ArgumentoNoValido {
		com.setUsuario(null);
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testAddRespuesta() throws ArgumentoNoValido {
		com.addRespuesta(null);
	}

	@Test(expected = ArgumentoNoValido.class)
	public void testDelRespuesta1() throws ArgumentoNoValido {
		com.delRespuesta(null);
	}
	
	@Test(expected = ArgumentoNoValido.class)
	public void testDelRespuesta2() throws ArgumentoNoValido {
		Comentario com2 = new Comentario(u, null, 3);
		com.delRespuesta(com2);
	}


}