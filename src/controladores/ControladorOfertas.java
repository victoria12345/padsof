package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app.Sistema;
import gui.CustomFrame;
import paneles.OferPanel;

public class ControladorOfertas implements ActionListener, ListSelectionListener{
	private CustomFrame ventana;
	private Sistema app;
	
	public ControladorOfertas(CustomFrame ventana, Sistema app) {
		this.ventana = ventana;
		this.app = app;	
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		OferPanel panel = ventana.getPanelOfertas();
		Object event = arg0.getSource();
		
		if(event.equals(panel.getBotonDemandante())) {
			ventana.getPanelDemandante().iniciar(app);
			ventana.mostrarPanelDemandante();
		}
	}

}
