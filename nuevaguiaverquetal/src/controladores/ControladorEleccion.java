package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.Sistema;
import excepciones.ArgumentoNoValido;
import excepciones.HayOtroUsuarioLogeado;
import excepciones.UsuarioNoEncontrado;
import gui.CustomFrame;
import paneles.EleccionOfertaPanel;
import paneles.ElegirRolPanel;
/**
 * Descripcion de la clase controlador Eleccion
 * 
 * @author Victoria Pelayo e Ignacio Rabunnal
 */
public class ControladorEleccion implements ActionListener{
	/**
	 * Ventana de la aplicacion 
	 */
	private CustomFrame ventana;
	
	/**
	 * Constructor del controlador Eleccion
	 * @param gui ventana de la aplicacion
	 * @param sist sistema de la aplicacion
	 * 
	 * @author Victoria Pelayo e Ignacio Rabunnal
	 */
	public ControladorEleccion(CustomFrame gui, Sistema sist) {
		this.ventana = gui; 
	}
	
	/**
	 * Implementa la accion tras un evento
	 * @param arg0 evento escuchado
	 * 
	 * @author Victoria Pelayo e Ignacio Rabunnal
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		EleccionOfertaPanel pEleccion = ventana.getPanelEleccion();
		
		if(event.equals(pEleccion.getbVacacional())){
			ventana.mostrarPanelVacacional();
		}else if(event.equals(pEleccion.getbResidencial())) {
			ventana.mostrarPanelResidencial();
		}else if((event.equals(pEleccion.getbAtras()))){
			ventana.mostrarPanelInmuebles();
		}
	}

}
