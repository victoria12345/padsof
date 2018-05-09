package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;

import app.Sistema;
import excepciones.ArgumentoNoValido;
import gui.CustomFrame;
import inmuebles.CampoAbierto;
import inmuebles.Inmueble;
import paneles.SubirInmueblePanel;
import usuarios.Ofertante;
import usuarios.Rol;
import usuarios.Usuario;

/**
 * Descripcion de la clase ControladorSubirInmueble
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class ControladorSubirInmueble implements ActionListener{
	private CustomFrame ventana;
	private Sistema app;
	
	/**
	 * Constructor del controlador
	 * @param ventana ventana personalizada que contiene a los paneles
	 * @param app sistema con los datos y funciones pertinentes
	 */
	public ControladorSubirInmueble(CustomFrame gui, Sistema app) {
		this.ventana = gui;
		this.app = app;
	}
	
	/**
	 * Gestiona las diferentes acciones que se pueden hacer en el panel de
	 * subir un inmueble
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		SubirInmueblePanel pSubir = ventana.getPanelSubirInmu();
		
		if(event.equals(pSubir.getbAddCampo())) {
			CampoAbierto c = new CampoAbierto(pSubir.getCampoClave().getText(), pSubir.getCampoValor().getText());
			pSubir.getCampos().add(c);
			JOptionPane.showMessageDialog(null, "Campo añadido");
		}	
		else if(event.equals(pSubir.getbSubir())){
				Inmueble i;
				
				if(pSubir.getCampoCP().getText().equals("")||pSubir.getCampoLoc().getText().equals("")||pSubir.getCampoDesc().getText().equals("")) {
					JOptionPane.showMessageDialog(pSubir, "Error con los datos.");
					return;
				}
				
				i = new Inmueble(pSubir.getCampoLoc().getText(),Integer.parseInt(pSubir.getCampoCP().getText()) , pSubir.getCampoDesc().getText());
				app.getInmuebles().add(i);
				for(CampoAbierto c: pSubir.getCampos()) {
					try {
						System.out.println(c);
						i.addCampo(c);
					} catch (ArgumentoNoValido e) {
						e.printStackTrace();
					}
				}
				pSubir.getCampos().clear();
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
