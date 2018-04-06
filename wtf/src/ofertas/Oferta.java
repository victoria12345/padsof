package ofertas;
import java.time.*;
import java.util.*;

import usuarios.Demandante;
import es.uam.eps.padsof.telecard.*;
import excepciones.ArgumentoNoValido;

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
	private String rectificacion;
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	private List<Demandante> bloqueados = new ArrayList<Demandante>();

	
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
		this.estado = Estado.PENDIENTE;
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
	public void setPrecio(double precio) throws ArgumentoNoValido{
		if(precio <0 ) {
			throw new ArgumentoNoValido();
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
	public void setValoracion(double valoracion) throws ArgumentoNoValido{
		if(valoracion <0) {
			throw new ArgumentoNoValido();
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
	public void setDesc(String desc) throws ArgumentoNoValido{
		if(desc == null) {
			throw new ArgumentoNoValido();
		}
		this.desc = desc;
	}
	
	/**
	 * @return la rectificacion
	 */
	public String getRectificacion() {
		return rectificacion;
	}
	
	/**
	 * @param rectificacion nueva rectificacion
	 */
	public void setRectificacion(String rectificacion) {
		this.rectificacion = rectificacion;
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
	
	
	/**
	 * @return cancelacion fecha de cancelacion de la oferta
	 */
	public LocalDate getCancelacion() {
		return cancelacion;
	}
	
	/**
	 * @param cancelacion fecha de cancelacion de la oferta
	 */
	public void setCancelacion(LocalDate cancelacion) {
		this.cancelacion = cancelacion;
	}
	
	/**
	 * @return bloqueados lista de bloqueados en la oferta
	 */
	public List<Demandante> getBloqueados() {
		return bloqueados;
	}
	
	/**
	 * @param bloqueados lista de usuarios bloqueados
	 */
	public void setBloqueados(List<Demandante> bloqueados) throws ArgumentoNoValido { 
		if(bloqueados == null) {
			throw new ArgumentoNoValido();
		}
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
	public void setComentarios(List<Comentario> comentarios) throws ArgumentoNoValido{
		if(comentarios == null) {
			throw new ArgumentoNoValido();
		}
		this.comentarios = comentarios;
	}
	
	/**
	 * Annade un comentario
	 * @param c comentario nuevo sobre la oferta
	 */
	public void addComentario(Comentario c) throws ArgumentoNoValido{
		if(c == null || comentarios.contains(c) == true) {
			throw new ArgumentoNoValido();
		}
		
		comentarios.add(c);
	}
	
	/**
	 * Recalcula la valoracion de la oferta
	 * @param valoracion nuevo valor introducido por un usuario
	 */
	public void valorar(int valoracion) throws ArgumentoNoValido {
		if(valoracion < 0 || valoracion > 10) { //la valoracion estara entre 0 y 10
			throw new ArgumentoNoValido();
		}
		this.valoracion += valoracion;
		this.valoracion = this.valoracion/2;
	}
	
	/**
	 * Paga una oferta
	 * @param tareta tarjeta del usuario que paga la oferta
	 * @param concepto concepto del pago
	 */
	public void pagar(String tarjeta, String concepto) throws InvalidCardNumberException, FailedInternetConnectionException, OrderRejectedException{
		TeleChargeAndPaySystem.charge(tarjeta, concepto, this.getPrecio());
		
	}

	/**
	 * Añade un bloqueado a una determinada oferta
	 * @param deman demandante que va a ser bloqueado en la oferta
	 */
	public void addBloqueado(Demandante deman) throws ArgumentoNoValido {
		if(deman == null ||bloqueados.contains(deman)) {
			throw new ArgumentoNoValido();
		}
		bloqueados.add(deman);
	}
	
	/**
	 * Crea un string con la informacion de la oferta
	 * @return oferta String con la informacion de la oferta
	 */
	public String toString() {
		String oferta = "Oferta->" + " Descripcion: " + this.getDesc() + " Precio: " + this.getPrecio() + " Fecha ini: " + this.getIni() + " Valoracion: " + this.getValoracion() + " Disponibilidad: " + this.getDisp();
		return oferta;				
	}
}
