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
import usuarios.Rol;
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
				JOptionPane.showMessageDialog(pSubir, "Introducir correctamente los datos.");
			}
			
		}	
		else if(event.equals(pSubir.getbSubir())){
				Inmueble i;
				
				if(pSubir.getCampoCP().getText().equals("")||pSubir.getCampoLoc().getText().equals("")||pSubir.getCampoDesc().getText().equals("")) {
					JOptionPane.showMessageDialog(pSubir, "Error con los datos.");
					return;
				}
				
				i = new Inmueble(pSubir.getCampoLoc().getText(),Integer.parseInt(pSubir.getCampoCP().getText()) , pSubir.getCampoDesc().getText());
				
				Usuario u = app.getUsuarioActual();
				for(Rol r: u.getRoles()) {
					if(r.isOfertante() == true) {
						try {
							((Ofertante) r).addInmueble(i);
							ventana.getPanelInmuebles().actualizarInmuebles((Ofertante) r);
						} catch (ArgumentoNoValido e) {
							JOptionPane.showMessageDialog(pSubir, "Error al crear el inmueble.");
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
