package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Sistema;
import gui.CustomFrame;
import paneles.DemandantePanel;

public class ControladorDemandante implements ActionListener{
	private CustomFrame ventana;
	private Sistema app;
	
	
	public ControladorDemandante(CustomFrame ventana, Sistema app) {
		this.ventana = ventana;
		this.app = app;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		DemandantePanel panel = ventana.getPanelDemandante();
		if(event.equals(panel.getAtras())) {
			ventana.mostrarPanelOfertas();
		}
		
	}

}
