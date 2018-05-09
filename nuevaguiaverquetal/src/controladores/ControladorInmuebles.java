package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;


import gui.CustomFrame;
import inmuebles.Inmueble;

import paneles.InmueblesPanel;


/**
 * Descripcion de la clase ControladorInmuebles
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class ControladorInmuebles implements ActionListener {
	private CustomFrame ventana;
	
	/**
	 * Constructor del controlador
	 * @param ventana ventana personalizada que contiene a los paneles
	 * @param app sistema con los datos y funciones pertinentes
	 */
	public ControladorInmuebles(CustomFrame gui) {
		this.ventana = gui;
	}
	
	/**
	 * Gestiona las diferentes acciones que se pueden hacer en el panel de
	 * inmuebles
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		InmueblesPanel panel = ventana.getPanelInmuebles();
		JList list = panel.getInmuebles();
		
		if(event.equals(panel.getbSalir())) {
			ventana.mostrarPanelRol();
		}
		else if(event.equals(panel.getbAñadir())) {
			ventana.mostrarPanelSubirInmu();
		}
		else if(event.equals(panel.getbAsociar())){
			if(list.isSelectionEmpty() == false) {
				int index =  list.getSelectedIndex();
				Inmueble u;
				if((u = (Inmueble)list.getModel().getElementAt(index)) == null) {
					return;
				}
				
				ventana.getPanelEleccion().iniciar(u);
				ventana.mostrarPanelEleccion();
			}
		}
		else if(event.equals(panel.getbVer())){
			if(list.isSelectionEmpty() == false) {
				int index =  list.getSelectedIndex();
				Inmueble u;
				if((u = (Inmueble)list.getModel().getElementAt(index)) == null) {
					return;
				}
				
				ventana.getPanelAsociadas().iniciar(u);
				ventana.mostrarPanelAsociadas();
			}
		}
		else if(event.equals(panel.getbAceptar())){
			ventana.getPanelPendientesUser().iniciar();
			ventana.mostrarPendientesUsuario();
		}
	}
}
