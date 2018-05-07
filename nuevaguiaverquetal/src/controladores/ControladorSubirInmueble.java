package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.Sistema;
import excepciones.ArgumentoNoValido;
import excepciones.HayOtroUsuarioLogeado;
import excepciones.UsuarioNoEncontrado;
import gui.CustomFrame;
import inmuebles.CampoAbierto;
import inmuebles.Inmueble;
import paneles.SubirInmueblePanel;
import usuarios.Ofertante;
import usuarios.Usuario;

public class ControladorSubirInmueble implements ActionListener{
	private CustomFrame ventana;
	private Sistema app;
	
	public ControladorSubirInmueble(CustomFrame gui, Sistema app) {
		this.ventana = gui;
		this.app = app;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		SubirInmueblePanel pSubir = ventana.getPanelSubirInmu();
		
		if(event.equals(pSubir.getbAddCampo())) {
			Inmueble o = new Inmueble(pSubir.getCampoLoc().getText(),Integer.parseInt(pSubir.getCampoCP().getText()) , pSubir.getCampoDesc().getText());
			
			try {
				o.addCampo(new CampoAbierto(pSubir.getCampoClave().getText(), pSubir.getCampoValor().getText()));
			} catch (ArgumentoNoValido e) {
				e.printStackTrace();
			}
			
			while(event.equals(pSubir.getbAddCampo())) {
				try {
					o.addCampo(new CampoAbierto(pSubir.getCampoClave().getText(), pSubir.getCampoValor().getText()));
				} catch (ArgumentoNoValido e) {
					e.printStackTrace();
				}
			}
			
			if(event.equals(pSubir.getbSubir())){
				Usuario u = app.getUsuarioActual();
				for(int i = 0; i < u.getRoles().size(); i++) {
					if(u.getRoles().get(i).isOfertante() == true) {
						Ofertante rol = (Ofertante)u.getRoles().get(i);
						try {
							rol.addInmueble(o);
						} catch (ArgumentoNoValido e) {
							e.printStackTrace();
						}
					}
				}
				ventana.mostrarPanelInmuebles();
			}
			
			
		}
		else if(event.equals(pSubir.getbSubir())) {
			Inmueble o = new Inmueble(pSubir.getCampoLoc().getText(),Integer.parseInt(pSubir.getCampoCP().getText()) , pSubir.getCampoDesc().getText());
		
			Usuario u = app.getUsuarioActual();
			for(int i = 0; i < u.getRoles().size(); i++) {
				if(u.getRoles().get(i).isOfertante() == true) {
					Ofertante rol = (Ofertante)u.getRoles().get(i);
					try {
						rol.addInmueble(o);
					} catch (ArgumentoNoValido e) {
						e.printStackTrace();
					}
				}
			}
			ventana.mostrarPanelInmuebles();
		}
		
		else if(event.equals(pSubir.getbCancelar())) {
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
