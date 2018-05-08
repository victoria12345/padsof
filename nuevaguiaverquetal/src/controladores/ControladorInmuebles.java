package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;

import app.Sistema;
import excepciones.ArgumentoNoValido;
import excepciones.HayOtroUsuarioLogeado;
import excepciones.UsuarioNoEncontrado;
import gui.CustomFrame;
import inmuebles.Inmueble;
import paneles.AdminPanel;
import paneles.InmueblesPanel;
import usuarios.Usuario;

public class ControladorInmuebles implements ActionListener {
	private Sistema app;
	private CustomFrame ventana;
	
	public ControladorInmuebles(Sistema app, CustomFrame gui) {
		this.ventana = gui;
		this.app = app;
	}
	
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
