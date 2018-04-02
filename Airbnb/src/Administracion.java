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
	 * @throws IOException
	 */
	public void cargarUsuarios(String fichero) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fichero)));
		String linea;
		String nick, rol, nombre, apellidos, tarjeta, contrasenia;
		List<Rol> roles = new ArrayList<Rol>();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		int i = 0;

		while((linea = buffer.readLine()) != null){
			if(i == 0){ //nos saltamos la cabecera
				i = 1;
			}else{
				Usuario u;
				String trozos[] = linea.split(";");
				String fullname[] = trozos[2].split(", "); //Dividimos fullname en dos trozos(nombre y apellido)
				
				rol = trozos[0];
				nick = trozos[1];
				nombre = fullname[1];
				apellidos = fullname[0];
				contrasenia = trozos[3];
				tarjeta = trozos[4];

				u = new Usuario(nick, nombre, apellidos, contrasenia);

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

		buffer.close();
		sistema.setUsuarios(usuarios);
	}
	
	/**
	 * Guarda en el sistema y en los usuarios los inmuebles leidos de un fichero
	 * @param fichero nombre del fichero donde estan los inmuebles
	 * @throws IOException
	 */
	public void cargarInmuebles(String fichero) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fichero)));
		String linea;
		String localizacion, codigo, desc, camposab, ofertas, nick, contrasenia;
		List<CampoAbierto> campos = new ArrayList<CampoAbierto>();
		List<Inmueble> inmuebles = new ArrayList<Inmueble>();
		int i = 0;
		
		while((linea = buffer.readLine()) != null){
			if(i == 0){ //nos saltamos la cabecera
				i = 1;
			}else{
				Inmueble i;
				String trozos[] = linea.split(";");
				
				localizacion = trozos[0];
				codigo = trozos[1];
				desc = trozos[2];
				camposab = trozos[3];
				ofertas = trozos[4];
				nick = trozos[5];
				contrasenia = trozos[6];

					//////////HAY QUE ACABARLA
			}

			
		}

		buffer.close();
		sistema.setInmuebles(inmuebles);
		
	}
}
