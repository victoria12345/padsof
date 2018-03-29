import java.io.*;
import java.util.*;
/**
 * Definicion de la clase administracion
 * Se encargara de guardar el estado de la aplicacion y de cargar
 * el anterior estado
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class Administracion {

	private Sistema sistema;
	
	public Administracion(Sistema sistema) {
		this.sistema = sistema;
	}
	
	public boolean cargarUsuarios(String fichero) throws IOException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		InputStreamReader reader = new InputStreamReader(new FileInputStream(fichero));
		BufferedReader buffer = new BufferedReader(reader);
		
		
		String linea;
		int i = 0;
		
		while((linea = buffer.readLine()) != null) {
			if(i == 0) {
				i = 1; // Nos saltamos la cabecera del fichero
			}else{
				
				StringTokenizer tokens = new StringTokenizer(linea,";");

				//Leemos los tokens de la linea
				while(tokens.hasMoreTokens()) {
					Usuario u ;
					
					String rol = tokens.nextToken();

					String nick = tokens.nextToken();
					
					String fullname = tokens.nextToken();
					StringTokenizer tok2 = new StringTokenizer(fullname, ",");
					String nombre = tok2.nextToken();
					String apellido = tok2.nextToken();
					
					String contrasenia = tokens.nextToken();
					
					String tarjeta = tokens.nextToken();
					
					//Comprobamos que no hay error en lo que se ha leido
					if(rol == null || nick == null || nombre == null || apellido == null || contrasenia == null
							|| tarjeta == null) {
						return false;
					}
					
					u = new Usuario(nick, nombre, apellido, contrasenia);
					
					List<Rol> roles = new ArrayList<Rol>();
					

					switch(rol) {
					case "D":
						roles.add(new Demandante(Long.parseLong(tarjeta)));
					case "O":
						roles.add(new Ofertante(Long.parseLong(tarjeta)));
					case "OD":
						roles.add(new Demandante(Long.parseLong(tarjeta)));
						roles.add(new Ofertante(Long.parseLong(tarjeta)));
					}
					
					u.setRoles(roles);
					usuarios.add(u);
				}		
			}
		}
		
		reader.close();
		buffer.close();
		
		sistema.setUsuarios(usuarios);
		
		return true;
	}
}
