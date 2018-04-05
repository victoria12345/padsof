
import java.io.*;
import java.time.LocalDate;

import ofertas.*;
import usuarios.*;
import es.uam.eps.padsof.telecard.FailedInternetConnectionException;
import es.uam.eps.padsof.telecard.InvalidCardNumberException;
import es.uam.eps.padsof.telecard.OrderRejectedException;
import excepciones.ArgumentoNoValido;
import excepciones.DemasiadasOfertasReservadas;
import excepciones.OfertaNoDisponible;
import excepciones.UsuarioBloqueado;
import inmuebles.*;

public class Tester {

	public static void main(String[] args) throws IOException {
		Sistema airbnb;
		try {
			airbnb = new Sistema();
			
			System.out.println("Sistema creado\n");
			
			LocalDate ini = LocalDate.of(2018, 1, 1);
			
			Usuario ofertante = airbnb.getUsuarios().get(0);
			Usuario demandante = airbnb.getUsuarios().get(1);
			
			System.out.println("Ofertante:\n" + ofertante + "\n");
			System.out.println("Demandante:\n" + demandante + "\n");
			
			System.out.println("Creando nueva oferta");
			
			OfertaResidencial ores = new OfertaResidencial(10, ini, 10);
			ores.setEstado(Estado.ACEPTADA);
		
			
			System.out.println(ores + "\n");
			
			System.out.println("Creando nuevo inmueble");
			
			Inmueble i = new Inmueble(null, 28040, null);
			
			System.out.println(i + "\n");
			
			System.out.println("Asociando la oferta al inmueble \n");
			
			i.asociarOferta(ores);
			
			System.out.println("Se ha asociado al inmueble\n" + i + "\nla oferta:\n" + i.getOfertas().get(0) + "\n");
			
			System.out.println("Añadiendo el inmueble al usuario ofertante\n");
			
			Ofertante ofer = null;
			for(Rol r: ofertante.getRoles()) {
				if(r.isOfertante() == true) {
					ofer = (Ofertante) r;
				}
			}
			
			ofer.addInmueble(i);
			
			System.out.println("Se ha añadido al ofertante " + ofertante.getNombre() +
								" el inmueble:\n" + ofer.getInmuebles().get(0) + "\n");
			
			System.out.println("El demandante esta reservando la oferta\n");
			Demandante deman = null;
			for(Rol r: demandante.getRoles()) {
				if(r.isDemandante() == true) {
					deman = (Demandante) r;
				}
			}
			
			
			try {
				ores.reservar(deman, ini);
			} catch (UsuarioBloqueado e1) {
				System.out.println("El usuario está bloqueado");
			} catch (OfertaNoDisponible e1) {
				System.out.println("La oferta no está disponible para reservas");
			} catch (DemasiadasOfertasReservadas e1) {
				System.out.println("El usuario no puede reservar mas de una oferta residencial a la vez");
			}
			
			System.out.println("La " + deman.getResidencial() + " está: " + ores.getDisp());
			
			System.out.println("El demandante procede a pagar la oferta");
		
			try {
				deman.pagarOferta(ores, "Pago de la reserva");
			} catch (InvalidCardNumberException e) {
				System.out.println("El número de tarjeta no es váido");
			} catch (FailedInternetConnectionException e) {
				System.out.println("Fallo en la conexion a internet");
			} catch (OrderRejectedException e) {
				System.out.println("Orden rechazada");
			}
			
			System.out.println("El pago de ha realizado con exito");
			
			System.out.println("Se encuentra la oferta en las ofertas pagadas del demandante?\n" + deman.getOfertas().contains(ores));
		
		} catch (ArgumentoNoValido e1) {
			System.out.println("No ha sido posible iniciar el sistema");
		}
		
		
	}	

	
	
}
