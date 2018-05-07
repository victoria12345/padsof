package ofertas;
import java.time.*;
import java.util.*;

import usuarios.Demandante;
import usuarios.Ofertante;
import es.uam.eps.padsof.telecard.*;
import excepciones.ArgumentoNoValido;
import excepciones.DemasiadasOfertasReservadas;
import excepciones.OfertaNoDisponible;
import excepciones.UsuarioBloqueado;

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
	 * @throws ArgumentoNoValido si el precio es menor que 0
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
	 * @param disp nuevo estado disponibilidad
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
	 * @throws ArgumentoNoValido si la descripcion es null
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
	 * @return comentarios de la oferta
	 */
	public List<Comentario> getComentarios(){
		return comentarios;
	}
	

	
	/**
	 * Annade un comentario
	 * @param c comentario nuevo sobre la oferta
	 * @throws ArgumentoNoValido si el comentario es null o la lista de comentarios ya contiene al comentario
	 */
	public void addComentario(Comentario c) throws ArgumentoNoValido{
		if(c == null || comentarios.contains(c) == true) {
			throw new ArgumentoNoValido();
		}
		
		comentarios.add(c);
	}
	
	public void delComentario(Comentario c) throws ArgumentoNoValido{
		if(c == null || comentarios.contains(c) == false) {
			throw new ArgumentoNoValido();
		}
		
		comentarios.remove(c);
	}
	
	
	/**
	 * Recalcula la valoracion de la oferta
	 * @param valoracion nuevo valor introducido por un usuario
	 * @throws ArgumentoNoValido si la valoracion es menor que 1 o mayor que 10
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
	 * @param tarjeta tarjeta del usuario que paga la oferta
	 * @param concepto concepto del pago
	 * @throws InvalidCardNumberException si la tarjeta es erronea
	 * @throws FailedInternetConnectionException si falla la conexion a internet
	 * @throws OrderRejectedException si la orden de transaccion ha sido rechazada
	 * @throws ArgumentoNoValido 
	 */
	public void pagar(Demandante deman, Ofertante ofer, String concepto) throws InvalidCardNumberException, FailedInternetConnectionException, OrderRejectedException, ArgumentoNoValido{
		deman.pagarOferta(this, concepto);
		ofer.recibirPago(this, concepto);
	}

	/**
	 * Añade un bloqueado a una determinada oferta
	 * @param deman demandante que va a ser bloqueado en la oferta
	 * @throws ArgumentoNoValido si el demandante es null o si la lista de bloqueados ya contiene al demandante
	 */
	public void addBloqueado(Demandante deman) throws ArgumentoNoValido {
		if(deman == null ||bloqueados.contains(deman)) {
			throw new ArgumentoNoValido();
		}
		bloqueados.add(deman);
	}
	
	public void delBloqueado(Demandante deman) throws ArgumentoNoValido {
		if(deman == null ||bloqueados.contains(deman) == false) {
			throw new ArgumentoNoValido();
		}
		bloqueados.remove(deman);
	}
	
	/**
	 * Crea un string con la informacion de la oferta
	 * @return oferta String con la informacion de la oferta
	 */
	public String toString() {
		String oferta = "Descripcion: " + this.getDesc() + "\nPrecio: " + this.getPrecio() + "\nFecha ini: " + this.getIni() + "\nValoracion: " + this.getValoracion() + "\nDisponibilidad: " + this.getDisp();
		return oferta;				
	}
	
	public abstract void reservar(Demandante deman, LocalDate date)throws UsuarioBloqueado, OfertaNoDisponible, DemasiadasOfertasReservadas;
	public abstract void cancelar(Demandante deman, boolean valor) throws ArgumentoNoValido;
	public abstract double calcularPrecio();
}
