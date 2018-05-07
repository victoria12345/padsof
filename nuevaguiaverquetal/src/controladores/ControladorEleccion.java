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

public class ControladorEleccion implements ActionListener{
	private CustomFrame ventana;
	private Sistema app;
	
	
	public ControladorEleccion(CustomFrame gui, Sistema sist) {
		this.ventana = gui; 
		this.app = app;
	}
	
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
	
	public CustomFrame getVentana() {
		return ventana;
	}

	public void setVentana(CustomFrame ventana) {
		this.ventana = ventana;
	}

	public Sistema getApp() {
		return app;
	}

	public void setApp(Sistema app) {
		this.app = app;
	}
}
