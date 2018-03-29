import java.util.*;

/**
 * Descripcion de la clase Demandante
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class Demandante extends Rol{
	private long tarjeta;
	private boolean bloqueado;
	private List<Oferta> reservas = new ArrayList<Oferta>();
	private List<Oferta> ofertas = new ArrayList<Oferta>();
	
	/**
	 * @return las reservas
	 */
	public List<Oferta> getReservas() {
		return reservas;
	}

	/**
	 * @param reservas nueva lista de reservas
	 */
	public void setReservas(List<Oferta> reservas) {
		if(reservas == null) {
			return;
		}
		this.reservas = reservas;
	}

	/**
	 * @return las ofertas contratadas
	 */
	public List<Oferta> getOfertas() {
		return ofertas;
	}

	/**
	 * @param ofertas nuevo array de ofertas contratadas
	 */
	public void setOfertas(List<Oferta> ofertas) {
		if(ofertas == null ) {
			return;
		}
		this.ofertas = ofertas;
	}
	
	/**
	 * Se annade una reserva. Solo se puede reservar una oferta que no lo esta
	 * @param o oferta que se desea reservar
	 */
	public void addReserva(Oferta o) {
		if(o == null || o.getDisp() == Disponibilidad.RESERVADA) {
			return;
		}
		reservas.add(o);
	}
	
	/**
	 * Se annade una reserva contratada.
	 * Solo se pueden contratar las que no lo esten por el usuario
	 * @param o
	 */
	public void addOferta(Oferta o) {
		if(o == null || (o.getDisp() == Disponibilidad.RESERVADA) && reservas.contains(o)==false){
			return;
		}
		ofertas.add(o);
	}

	/**
	 * Constructor de Demandante
	 * @param tarjeta tarjeta de credito del demandante
	 */
	public Demandante(long tarjeta) {
		this.tarjeta = tarjeta;
		this.bloqueado = false;
	}

	/**
	 * @return la tarjeta
	 */
	public long getTarjeta() {
		return tarjeta;
	}

	/**
	 * @param tarjeta nueva tarjeta del demandante
	 */
	public void setTarjeta(long tarjeta) {
		this.tarjeta = tarjeta;
	}

	/**
	 * @return el estado de bloqueado
	 */
	public boolean isBloqueado() {
		return bloqueado;
	}

	/**
	 * @param bloqueado nuevo estado de bloqueado
	 */
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	/**
	 * Devuelve si es ofertante
	 * @return false
	 */
	public boolean isOfertante() {
		return false;
	}
	
	/**
	 * No hace nada
	 */
	public void addInmueble(Inmueble i) {
		
	}

}

