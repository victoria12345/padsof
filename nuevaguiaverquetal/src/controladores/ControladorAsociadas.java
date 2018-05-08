package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;


import app.Sistema;

import gui.CustomFrame;
import paneles.OfertasAsociadasPanel;


public class ControladorAsociadas implements ActionListener {
	private Sistema app;
	private CustomFrame ventana;
	
	public ControladorAsociadas(Sistema app, CustomFrame gui) {
		this.ventana = gui;
		this.app = app;
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		OfertasAsociadasPanel panel = ventana.getPanelAsociadas();
		JList list = panel.getOfertas();
		
		if(event.equals(panel.getbAtras())) {
			ventana.mostrarPanelInmuebles();
		}
		
	}
}
