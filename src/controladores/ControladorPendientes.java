package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import app.Sistema;
import gui.CustomFrame;
import ofertas.Oferta;
import paneles.AdminPanel;
import paneles.PendientesPanel;

public class ControladorPendientes implements ActionListener{
	private CustomFrame ventana;
	private Sistema app;
	
	public ControladorPendientes(CustomFrame ventana, Sistema app) {
		this.ventana = ventana; 
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		PendientesPanel panel = ventana.getPanelPendientes();
		JList list = panel.getPendientes();
		
		if(event.equals(panel.getBotonVer())) {
			if(list.isSelectionEmpty() == false) {
				int index = list.getSelectedIndex();
				Oferta o;
				if((o = (Oferta)list.getModel().getElementAt(index)) == null) {
					return;
				}
				ventana.getPanelOferPendiente().iniciar(o);
				ventana.mostrarPanelOferPendiente();
				
			}		
		}else if(event.equals(panel.getBotonVolver())) {
			ventana.mostrarPanelAdmin();
		}
		
	}

}
