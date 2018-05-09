package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;


import gui.CustomFrame;
import ofertas.Oferta;
import paneles.PendientesPanel;

/**
 * Descripcion de la clase ControladorPendientes
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class ControladorPendientes implements ActionListener{
	private CustomFrame ventana;

	
	
	/**
	 * Constructor del controlador
	 * @param ventana ventana personalizada que contiene a los paneles
	 * @param app sistema con los datos y funciones pertinentes
	 */
	public ControladorPendientes(CustomFrame ventana) {
		this.ventana = ventana; 

	}

	/**
	 * Gestiona las diferentes acciones que se pueden hacer en el panel de
	 * pendientes
	 */
	@SuppressWarnings("rawtypes")
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
