package Ofertas;
import java.time.*;
import java.util.*;

import Usuarios.Usuario;
import es.uam.eps.padsof.telecard.*;

import java.io.*;

/**
 * Descripcion de la clase oferta
 * @author Victoria Pelayo e Ignacio Rabunnal
 */


public abstract class Oferta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private double precio;
	private double valoracion;
	private Estado estado;
	private Disponibilidad disp;
	private LocalDate ini;
	private LocalDate cancelacion;
	private String desc;
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	private List<Usuario> bloqueados = new ArrayList<Usuario>();

	
	/**
	 * Constructor de Oferta
	 * @param precio precio de la oferta
	 * @param ini fecha inicio de la oferta
	 */
	public Oferta(double precio, LocalDate ini) {
		if(precio < 0) {
			this.precio = 0;
		}else{
			this.precio = precio;
		}
		this.valoracion = 0;
		this.estado = Estado.CANCELADA;
		this.disp = Disponibilidad.DISPONIBLE;
		this.ini = ini;
		this.cancelacion = null;
	}
	/**
	 * @return el precio
	 */
	public double getPrecio() {
		return precio;
	}
	
	/**
	 * @param precio nuevo precio de la oferta
	 */
	public void setPrecio(double precio) {
		if(precio <0 ) {
			return;
		}
		this.precio = precio;
	}
	
	/**
	 * @return la valoracion
	 */
	public double getValoracion() {
		return valoracion;
	}
	
	/**
	 * @param valoracion nuevo valor de valoracion
	 */
	public void setValoracion(double valoracion) {
		if(valoracion <0) {
			return;
		}
		this.valoracion = valoracion;
	}
	
	/**
	 * @return el estado
	*/
	public Estado getEstado() {
		return estado;
	}
	
	/**
	 * @param estado nuevo estado de la oferta
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	/**
	 * @return la disponibilidad 
	 */
	public Disponibilidad getDisp() {
		return disp;
	}
	
	/**
	 * @param disponible nuevo estado disponibilidad
	 */
	public void setDisp(Disponibilidad disp) {
		this.disp = disp;
	}
	
	/**
	 * @return la descripcion
	 */
	public String getDesc() {
		return desc;
	}
	
	/**
	 * @param desc nueva descripcion
	 */
	public void setDesc(String desc) {
		if(desc == null) {
			return;
		}
		this.desc = desc;
	}
	
	/**
	 * @return el inicio de la oferta
	 */
	public LocalDate getIni() {
		return ini;
	}
	
	/**
	 * @return fecha fin de la oferta
	 */
	public abstract LocalDate getFin();
	
	/**
	 * @param ini nuevo inicio de la oferta
	 */
	public void setIni(LocalDate ini) {
		this.ini = ini;
	}
	
	public LocalDate getCancelacion() {
		return cancelacion;
	}
	public void setCancelacion(LocalDate cancelacion) {
		this.cancelacion = cancelacion;
	}
	
	public List<Usuario> getBloqueados() {
		return bloqueados;
	}
	public void setBloqueados(List<Usuario> bloqueados) {
		this.bloqueados = bloqueados;
	}


	/**
	 * @return comentarios de la oferta
	 */
	public List<Comentario> getComentarios(){
		return comentarios;
	}
	
	/**
	 * @param comentarios nueva lista de comentarios de la oferta
	 */
	public void setComentarios(List<Comentario> comentarios) {
		if(comentarios == null) {
			return;
		}
		this.comentarios = comentarios;
	}
	
	/**
	 * Annade un comentario
	 * @param c comentario nuevo sobre la oferta
	 */
	public boolean addComentario(Comentario c) {
		if(c == null || comentarios.contains(c) == true) {
			return false;
		}
		
		comentarios.add(c);
		return true;
	}
	
	/**
	 * Recalcula la valoracion de la oferta
	 * @param valoracion nuevo valor introducido por un usuario
	 */
	public boolean valorar(int valoracion) {
		if(valoracion < 0 || valoracion > 10) { //la valoracion estara entre 0 y 10
			return false;
		}
		this.valoracion += valoracion;
		this.valoracion = this.valoracion/2;
		return true;
	}
	
	public void pagar(String tarjeta, String concepto) throws InvalidCardNumberException, FailedInternetConnectionException, OrderRejectedException{
		TeleChargeAndPaySystem.charge(tarjeta, concepto, this.getPrecio());
		
	}

	public void addBloqueado(Usuario u) {
		if(bloqueados.contains(u)) {
			return;
		}
		bloqueados.add(u);
	}
	
	public String toString() {
		String oferta = "Oferta:\n" + 
						"Descripcion:" + this.getDesc() + "\n" +
						"Precio:" + this.getPrecio();
		return oferta;				
	}
}
