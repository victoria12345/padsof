
import java.io.*;
import java.time.LocalDate;

import ofertas.*;
import usuarios.*;
import es.uam.eps.padsof.telecard.FailedInternetConnectionException;
import es.uam.eps.padsof.telecard.InvalidCardNumberException;
import es.uam.eps.padsof.telecard.OrderRejectedException;
import excepciones.ArgumentoNoValido;
import excepciones.DemasiadasOfertasReservadas;
import excepciones.HayOtroUsuarioLogeado;
import excepciones.OfertaNoDisponible;
import excepciones.UsuarioBloqueado;
import excepciones.UsuarioNoEncontrado;
import inmuebles.*;

public class Tester {

	public static void main(String[] args) throws IOException {
		Sistema airbnb;
		try {
			airbnb = new Sistema();
			Administrador admin = null;
			
			System.out.println("Sistema creado\n");
			
			LocalDate ini = LocalDate.of(2018, 1, 1);
			LocalDate fecha = LocalDate.of(2019, 1, 1);
			LocalDate fecha2 = LocalDate.of(2020, 1, 1);
			LocalDate fecha3 = LocalDate.of(2021, 1, 1);
			LocalDate fecha4 = LocalDate.of(2022, 1, 1);
			
			
			Usuario ofertante = airbnb.getUsuarios().get(0);
			Usuario demandante = airbnb.getUsuarios().get(1);
			
			System.out.println("Ofertante:\n" + ofertante + "\n");
			System.out.println("Demandante:\n" + demandante + "\n");
			
			System.out.println("Creando nuevas ofertas");
			
			OfertaResidencial ores = new OfertaResidencial(10, ini, 10);
			OfertaResidencial ores2 = new OfertaResidencial(9, fecha, 10);
			OfertaResidencial ores3 = new OfertaResidencial(8, fecha2, 10);
			OfertaResidencial ores4 = new OfertaResidencial(7, fecha3, 10);
			OfertaResidencial ores5 = new OfertaResidencial(6, fecha4, 10);
			
			
			ores.setValoracion(2);
			ores2.setValoracion(6);
			ores3.setValoracion(10);
			ores4.setValoracion(4);
			ores5.setValoracion(8);
		
			
			ores.setEstado(Estado.ACEPTADA);
			ores2.setEstado(Estado.ACEPTADA);
			ores3.setEstado(Estado.ACEPTADA);
			ores4.setEstado(Estado.ACEPTADA);
			ores5.setEstado(Estado.ACEPTADA);
			
			ores2.setDisp(Disponibilidad.RESERVADA);
			
			airbnb.addOferta(ores);
			airbnb.addOferta(ores2);
			airbnb.addOferta(ores3);
			airbnb.addOferta(ores4);
			airbnb.addOferta(ores5);
			
			
		
			
			System.out.println(ores);
			System.out.println(ores2);
			System.out.println(ores3);
			System.out.println(ores4);
			System.out.println(ores5);
			
			System.out.println("\nCreando nuevos inmuebles");
			
			Inmueble i = new Inmueble(null, 28040, null);
			Inmueble i2 = new Inmueble(null, 28080, null);
			
			airbnb.getInmuebles().add(i);
			airbnb.getInmuebles().add(i2);
			
			System.out.println(i);
			System.out.println(i2 + "\n");
			
			System.out.println("Asociando las oferta al inmueble \n");
			
			i.asociarOferta(ores);
			i.asociarOferta(ores2);
			i.asociarOferta(ores3);
			i.asociarOferta(ores4);
			i.asociarOferta(ores5);
			
			System.out.println("Se han asociado las ofertas al inmueble");
			
			System.out.println("Añadiendo el inmueble al usuario ofertante\n");
			
			Ofertante ofer = null;
			for(Rol r: ofertante.getRoles()) {
				if(r.isOfertante() == true) {
					ofer = (Ofertante) r;
				}
			}
			
			ofer.addInmueble(i);
			ofer.addInmueble(i2);
			
			System.out.println("Se ha añadido al ofertante " + ofertante.getNombre() +
								" el inmueble:\n" + ofer.getInmuebles().get(0) + "\n");
			
			
			System.out.println("El usuario demandante esta haciendo login");
			
			try {
				airbnb.login(demandante.getNick(), demandante.getContrasenia());
			} catch (HayOtroUsuarioLogeado e2) {
				System.out.println(e2);
			} catch (UsuarioNoEncontrado e2) {
				System.out.println(e2);
			}
			
			System.out.println("El usuario " + airbnb.getUsuarioActual() + "ha realizado el login de manera satisfactioria");
			
			
			
			Demandante deman = null;
			for(Rol r: demandante.getRoles()) {
				if(r.isDemandante() == true) {
					deman = (Demandante) r;
				}
			}
			
			System.out.println("\nEl demandante esta reservando la oferta");
			try {
				ores.reservar(deman, ini);
			} catch (UsuarioBloqueado e1) {
				System.out.println("El usuario está bloqueado");
			} catch (OfertaNoDisponible e1) {
				System.out.println("La oferta no está disponible para reservas");
			} catch (DemasiadasOfertasReservadas e1) {
				System.out.println("El usuario no puede reservar mas de una oferta residencial a la vez");
			}
			System.out.println("La oferta esta: " + ores.getDisp());
			
			System.out.println("El demandante se dispone a cancelar la reserva");
			
			ores.cancelar(deman, false);
			
			System.out.println("La oferta esta: " + ores.getDisp());

			
			System.out.println("\nEl demandante procede a pagar la oferta");
		
			try {
				deman.pagarOferta(ores, "Pago de la oferta");
			} catch (InvalidCardNumberException e) {
				System.out.println("El número de tarjeta no es váido");
			} catch (FailedInternetConnectionException e) {
				System.out.println("Fallo en la conexion a internet");
			} catch (OrderRejectedException e) {
				System.out.println("Orden rechazada");
			}
			
			System.out.println("El pago de ha realizado con exito");
			
			System.out.println("Se encuentra la oferta en las ofertas pagadas del demandante?\n" + deman.getOfertas().contains(ores));
			
			System.out.println("\nEl demandante se dispone a filtrar las ofertas del sistema");
			
			System.out.println("\nCreando nueva oferta para el inmueble 2");
			OfertaResidencial oresI2 = new OfertaResidencial(5, fecha4, 5);
			System.out.println(oresI2);
			System.out.println("Asociando la oferta al inmueble 2");
			i2.asociarOferta(oresI2);
			airbnb.addOferta(oresI2);
			
			System.out.println("\nFiltrando ofertas por código postal");
			airbnb.filtrar_codigo(28080);
			System.out.println("Ofertas filtradas:");
			for(Oferta o : airbnb.getFiltradas()) {
				System.out.println(o);
			}
			
			System.out.println("\nFiltrando ofertas con un precio maximo de 8");
			airbnb.filtrar_precio(8);
			System.out.println("Ofertas filtradas:");
			for(Oferta o : airbnb.getFiltradas()) {
				System.out.println(o);
			}
			
			
			System.out.println("\nFiltrando ofertas con una valoracion minima de 6");
			airbnb.filtrar_valoracion(6);
			System.out.println("Ofertas filtradas:");
			for(Oferta o : airbnb.getFiltradas()) {
				System.out.println(o);
			}
			
			System.out.println("\nFiltrando ofertas entre entre el 1 de enero de 2019 y el 31 de diciembre de 2022");
			airbnb.filtrar_fecha(LocalDate.of(2019, 1, 1), LocalDate.of(2022, 12, 31));
			System.out.println("Ofertas filtradas:");
			for(Oferta o : airbnb.getFiltradas()) {
				System.out.println(o);
			}
			
			System.out.println("\nMostrando solo ofertas disponibles");
			airbnb.filtrar_disp(Disponibilidad.DISPONIBLE);
			System.out.println("Ofertas filtradas:");
			for(Oferta o : airbnb.getFiltradas()) {
				System.out.println(o);
			}
			
			System.out.println("\nEl Demandante se dispone a ordenar las ofertas filtradas por precio de menor a mayor");
			airbnb.ordenar_precio(airbnb.getFiltradas(), 0);
			for(Oferta o : airbnb.getFiltradas()) {
				System.out.println(o);
			}
			
			System.out.println("\nEl Demandante se dispone a ordenar las ofertas filtradas por precio de mayor a menor");
			airbnb.ordenar_precio(airbnb.getFiltradas(), 1);
			for(Oferta o : airbnb.getFiltradas()) {
				System.out.println(o);
			}
		
			System.out.println("\nDemandante añadiendo un comentario a la: " + ores2);
			Comentario c = new Comentario(demandante, "Increible!", 1);
			ores2.addComentario(c);
			System.out.println("Comentario añadido:" + ores2.getComentarios().get(0));
			
			Comentario c2 = new Comentario(ofertante, "Esta muy bien", 2);
			ores.addComentario(c2);
			System.out.println("\nDemandante respondiendo a un comentario de la: " + ores);
			Comentario c3 = new Comentario(demandante, "Pues a mi no me parecio para tanto...!", 3);
			ores.getComentarios().get(0).addRespuesta(c3);
			System.out.println("Comentario añadido:" + ores.getComentarios().get(0).getRespuestas().get(0));
			System.out.println("respondiendo a: " +  c3.getPadre());
			
			
			System.out.println("\nEl demandante se dispone a reservar una última oferta");
			System.out.println(ores3);
			try {
				ores3.reservar(deman, fecha3);//1-1-2021
				System.out.println("La oferta se ha reservado satisfactoriamente");
				System.out.println(ores3);
			} catch (UsuarioBloqueado e) {
				System.out.println("El usuario esta bloqueado");
			} catch (OfertaNoDisponible e) {
				System.out.println("La oferta no esta disponible");
			} catch (DemasiadasOfertasReservadas e) {
				System.out.println("Demasiadasofertas reservadas");
			}
			
			
			
			System.out.println("\nEl demandante se dispone a hacer logout");
			airbnb.logout();
			
			System.out.println("\nEl sistema se va a cerrar");
			airbnb.serializar();
			
			System.out.println("\nEl sistema se abrirá 6 dias más tarde");
			
			System.out.println("\nAbriendo el sistema de nuevo");
			Sistema airbnb2 = new Sistema();
			try {
				airbnb = airbnb2.deserializar(fecha3.plusDays(6));
				System.out.println("El sistema se ha abierto correctamente");
			} catch (ClassNotFoundException e) {
				System.out.println("No ha sido posible la carga del sistema");
			}
			
			System.out.println("\nComprobamos la persistencia de los datos");
			for(Oferta o : airbnb.getOfertas()) {
				System.out.println(o);
			}
			System.out.println("\nPodemos observar que las ofertas se mantienen y que la oferta reservada varios dias antes vuelve a estar disponible");
	
			System.out.println("\nUn nuevo usuario se dispone a hacer login");
			Usuario err = airbnb.getUsuarios().get(3);
			try {
				airbnb.login(err.getNick(), err.getContrasenia());
				System.out.println("El usuario:\n" + airbnb.getUsuarioActual() + " ha realizado el login de manera satisfactoria");
			} catch (HayOtroUsuarioLogeado e2) {
				System.out.println(e2);
			} catch (UsuarioNoEncontrado e2) {
				System.out.println(e2);
			}
			
			
			System.out.println("\nEl usuario actual procede a pagar la oferta:\n" + ores5);
			
			for(Rol r: airbnb.getUsuarioActual().getRoles()) {
				if(r.isDemandante() == true) {
					deman = (Demandante) r;
				}
			}
			
			try {
				deman.pagarOferta(ores5, "Pago de la oferta");
			} catch (InvalidCardNumberException e) {
				System.out.println("El número de tarjeta no es váido");
				deman.setBloqueado(true);
				for(Rol r: airbnb.getAdmin().getRoles()) {
					if(r.isAdmin() == true) {
						admin = (Administrador) r;
					}
				}
				admin.addBloqueado(airbnb.getUsuarioActual());
				System.out.println("El usuario actual ha sido bloqueado hasta que el administrador cambie la tarjeta");
			} catch (FailedInternetConnectionException e) {
				System.out.println("Fallo en la conexion a internet");
			} catch (OrderRejectedException e) {
				System.out.println("Orden rechazada");
			}
			
			System.out.println("\nEl usuario actual se dispone a hacer logout");
			airbnb.logout();
			
			System.out.println("\nEl administrador se dispone a hacer login en el sistema");
			try {
				airbnb.login("admin", "admin");
				System.out.println("El usuario:\n" + airbnb.getUsuarioActual() + " ha realizado el login de manera satisfactoria");
			} catch (HayOtroUsuarioLogeado e) {
				System.out.println(e);
			} catch (UsuarioNoEncontrado e) {
				System.out.println(e);
			}
			
			System.out.println("\nEl administrador se dispone a cambiar la tarjeta del usuario bloqueado");
			for(Rol r: airbnb.getAdmin().getRoles()) {
				if(r.isAdmin() == true) {
					admin = (Administrador) r;
				}
			}
			admin.cambiarTarjeta(airbnb.getUsuarios().get(3), "1234567891234567");
			admin.delBloqueado(airbnb.getUsuarios().get(3));
			
			System.out.println("Tarjeta cambiada");
			
			System.out.println("\nEl administrador se dispone a hacer logout");
			airbnb.logout();
			
			System.out.println("\nEl usuario previamente bloqueado se dispone a hacer login de nuevo");
			try {
				airbnb.login(err.getNick(), err.getContrasenia());
				System.out.println("El usuario:\n" + airbnb.getUsuarioActual() + " ha realizado el login de manera satisfactoria");
			} catch (HayOtroUsuarioLogeado e) {
				System.out.println(e);
			} catch (UsuarioNoEncontrado e) {
				System.out.println(e);
			}
			
			
			System.out.println("\nEl usuario actual procede a pagar la oferta:\n" + ores5);
			
			for(Rol r: airbnb.getUsuarioActual().getRoles()) {
				if(r.isDemandante() == true) {
					deman = (Demandante) r;
				}
			}
			
			try {
				deman.pagarOferta(ores5, "Pago de la oferta");
				System.out.println("Una vez cambiada la tarjeta, la oferta ha sido contratada correctamente");
				System.out.println(ores5);
			} catch (InvalidCardNumberException e) {
				System.out.println("El número de tarjeta no es váido");
				deman.setBloqueado(true);
				for(Rol r: airbnb.getAdmin().getRoles()) {
					if(r.isAdmin() == true) {
						admin = (Administrador) r;
					}
				}
				admin.addBloqueado(airbnb.getUsuarioActual());
				System.out.println("El usuario actual ha sido bloqueado hasta que el administrador cambie la tarjeta");
			} catch (FailedInternetConnectionException e) {
				System.out.println("Fallo en la conexion a internet");
			} catch (OrderRejectedException e) {
				System.out.println("Orden rechazada");
			}
			
			System.out.println("\nEl usario actual se dispone a hacer logout");
			airbnb.logout();
			
			System.out.println("\nEl sistema se va a cerrar");
			airbnb.serializar();
		
		} catch (ArgumentoNoValido e1) {
			System.out.println("No ha sido posible iniciar el sistema");
		}
		
		
	}	

	
	
}
