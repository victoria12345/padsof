import java.time.*;
import java.util.*;
import java.io.*;

public class Oferta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double precio;
	private double valoracion;
	private Estado estado;
	private Disponibilidad disp;
	private LocalDate ini;
	private String desc;
	

	private List<Comentario> comentarios = new ArrayList<Comentario>();
	
	public Oferta(double precio, LocalDate ini) {
		this.precio = precio;
		this.valoracion = 0;
		this.estado = Estado.CANCELADA;
		this.disp = Disponibilidad.DISPONIBLE;
		this.ini = ini;
	}
	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	/**
	 * @return the valoracion
	 */
	public double getValoracion() {
		return valoracion;
	}
	/**
	 * @param valoracion the valoracion to set
	 */
	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}
	/**
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	/**
	 * @return the disponible
	 */
	public Disponibilidad getDisp() {
		return disp;
	}
	/**
	 * @param disponible the disponible to set
	 */
	public void setDisp(Disponibilidad disp) {
		this.disp = disp;
	}
	
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/**
	 * @return the ini
	 */
	public LocalDate getIni() {
		return ini;
	}
	
	/**
	 * @param ini the ini to set
	 */
	public void setIni(LocalDate ini) {
		this.ini = ini;
	}

	public List<Comentario> getComentarios(){
		return comentarios;
	}
	
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

}
