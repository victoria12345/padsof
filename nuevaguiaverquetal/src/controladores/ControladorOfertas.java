package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app.Sistema;
import gui.CustomFrame;
import ofertas.Oferta;
import paneles.OferPanel;
import usuarios.Usuario;

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
		JList list = panel.getOfers();
		
		if(event.equals(panel.getBotonDemandante())) {
			ventana.getPanelDemandante().iniciar(app);
			ventana.mostrarPanelDemandante();
			
		}else if(event.equals(panel.getBotonVer())) {
			if(list.isSelectionEmpty() == false) {
				int index =  list.getSelectedIndex();
				Oferta o;
				if((o = (Oferta)list.getModel().getElementAt(index)) == null) {
					return;
				}
				ventana.getPanelVerOferta().iniciar(o);
				ventana.mostrarPanelVerOferta();
			}
			
		}else if(event.equals(panel.getBotonVolver())) {
			ventana.mostrarPanelRol();
			
		}else if(event.equals(panel.getBotonFiltrar())) {
			
			
		}else if(event.equals(panel.getBotonOrdenar())) {
			
		}
	}

}
