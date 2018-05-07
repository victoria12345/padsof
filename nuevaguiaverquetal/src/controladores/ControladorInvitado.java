package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app.Sistema;
import gui.CustomFrame;
import paneles.InvitadoPanel;

public class ControladorInvitado implements ActionListener, ListSelectionListener{
	private CustomFrame ventana;
	private Sistema app;
	
	public ControladorInvitado(CustomFrame ventana, Sistema app) {
		this.ventana = ventana; 
		this.app = app;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		InvitadoPanel panel = ventana.getPanelInvitado();
		if(event.equals(panel.getSalir())) {
			ventana.mostrarPanelLogin();
		}		
	}

}
