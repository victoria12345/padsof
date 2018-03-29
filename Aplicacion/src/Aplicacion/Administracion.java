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
	
	/**
	 * Constructor de sistema
	 * @param sistema sistema que se va a administrar
	 */
	public Administracion(Sistema sistema) {
		this.sistema = sistema;
	}
	
	/**
	 * Carga los usuarios en el sistema leidos desde un fichero
	 * @param fichero nombre del fichero donde estan los usuarios
	 * @return true si lo realiza correctamente y false si no es asi
	 * @throws IOException
	 */
	public boolean cargarUsuarios(String fichero) throws IOException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		InputStreamReader reader = new InputStreamReader(new FileInputStream(fichero));
		@SuppressWarnings("resource")
		BufferedReader buffer = new BufferedReader(reader);
		
		String linea;
		int i = 0;
		while((linea = buffer.readLine()) != null) {
			if(i == 0) {
				i = 1; // Nos saltamos la cabecera del fichero
			}else{
				Usuario u ;
				StringTokenizer tokens = new StringTokenizer(linea,";");

				//Leemos los tokens de la linea
				while(tokens.hasMoreTokens()) {
										
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
	
	/**
	 * Guarda en el sistema y en los usuarios los inmuebles leidos de un fichero
	 * @param fichero nombre del fichero donde estan los inmuebles
	 * @return true si se realiza correctamente y false si no es asi
	 * @throws IOException
	 */
	public boolean cargarInmuebles(String fichero) throws IOException {
		List<Inmueble> inmuebles = new ArrayList<Inmueble>();
		
		InputStreamReader reader = new InputStreamReader(new FileInputStream(fichero));
		@SuppressWarnings("resource")
		BufferedReader buffer = new BufferedReader(reader);
		
		String linea;
		int j = 0;
		
		
		while((linea = buffer.readLine()) != null) {
			if(j == 0) {
				j = 1; //nos saltamos la cabecera
			}else {
				StringTokenizer tokens = new StringTokenizer(linea,";");
				Inmueble i ;
				
				//Leemos los tokens de la linea
				while(tokens.hasMoreTokens()) {
					
					
					String localizacion = tokens.nextToken();

					String codigopostal = tokens.nextToken();
					
					String descripcion = tokens.nextToken();
					
					String camposabs = tokens.nextToken();
					
					String ofertas = tokens.nextToken();
					
					String nick = tokens.nextToken();
					
					String cont = tokens.nextToken();
					
					i = new Inmueble(localizacion, Integer.parseInt(codigopostal), descripcion);
					
					//leemos todos los campos abiertos que tiene
					if(camposabs != "NO_CAMPO") { 
						StringTokenizer tok2 = new StringTokenizer(camposabs, ",");
						List<CampoAbierto> campos = new ArrayList<CampoAbierto>();
						
						while(tok2.hasMoreTokens()) {
							String campo = tok2.nextToken();
							StringTokenizer tok3 = new StringTokenizer(campo, "|");
							String clave = tok3.nextToken();
							String valor = tok3.nextToken();
							
							CampoAbierto cmp = new CampoAbierto(clave,valor);
							campos.add(cmp);
						}
						i.setCampos(campos);
					}
					
					//leemos las ofertas asociadas
					if(ofertas != "NO_OFERTA") {
						StringTokenizer tok2 = new StringTokenizer(ofertas, ",");
						List<Oferta> ofs = new ArrayList<Oferta>();
						String id;
						
						while(tok2.hasMoreTokens()) {
							id = tok2.nextToken();
							
							Oferta o = sistema.buscarOferta(Integer.parseInt(id));
							if(o == null) {
								return false;
							}else {
								ofs.add(o);
							}
						}
						i.setOfertas(ofs);
					}
					inmuebles.add(i);
					Usuario u = sistema.buscarUsuario(nick, cont);
					u.addInmueble(i);
					
				}
			}
		}
		
		//annadimos todos los inmuebles leidos al sistema
		sistema.setInmuebles(inmuebles);
		
		return true;
	}
}
