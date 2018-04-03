package Tests;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import Ofertas.Comentario;
import Usuarios.Usuario;

public class ComentarioTest {

	Comentario com;
	Usuario u;
	Usuario user = null;
	Comentario com2 = null;
	List<Comentario> respuestas = new ArrayList<Comentario>();
	
	@Before
	public void before() {
		u = new Usuario("nick","nombre", "apellido", "contrasenia" );
		com = new Comentario(u, "texto", 2);
		com.setRespuestas(respuestas);
	}
	@Test
	public void testComentario() {
		Comentario comentario = new Comentario(u, null, 1);
		assertEquals(comentario.getTexto(), "no texto");
	}

	@Test
	public void testSetTexto() {
		com.setTexto(null);
		assertEquals(com.getTexto(), "texto");
	}

	@Test
	public void testSetUsuario() {
		com.setUsuario(user);
		assertEquals(com.getUsuario(), u);
	}

	@Test
	public void testSetRespuestas() {
		com.setRespuestas(null);
		assertEquals(com.getRespuestas(), respuestas);
	}

	@Test
	public void testAddRespuesta() {
		com.addRespuesta(com2);
		assertFalse(com.getRespuestas().contains(com2));
	}

	@Test
	public void testDelRespuesta1() {
		assertFalse(com.delRespuesta(com2));
	}
	
	@Test
	public void testDelRespuesta2() {
		com2 = new Comentario(u, null, 3);
		assertFalse(com.delRespuesta(com2));
	}


}
