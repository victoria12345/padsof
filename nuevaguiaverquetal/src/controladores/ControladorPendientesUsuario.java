package controladores;


import gui.*;
import ofertas.Oferta;

import paneles.OfertasPendientesPanel;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JList;


/**
 * Descripcion de la clase ControladorPendientesUsuario
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class ControladorPendientesUsuario implements ActionListener{

	private CustomFrame ventana;
	
	/**
	 * Constructor del controlador
	 * @param ventana ventana personalizada que contiene a los paneles
	 * @param app sistema con los datos y funciones pertinentes
	 */
	public ControladorPendientesUsuario(CustomFrame ventana) {
		this.ventana = ventana; 

	}

	/**
	 * Gestiona las diferentes acciones que se pueden hacer en el panel de
	 * ofertas pendientes de rectificar del usuario
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void actionPerformed(ActionEvent arg0) {

		Object event = arg0.getSource();
		OfertasPendientesPanel panel = ventana.getPanelPendientesUser();
		JList lista = panel.getOfertas();

		if(event.equals(panel.getbAtras())){
			ventana.mostrarPanelInmuebles();
		
		}else if(event.equals(panel.getbRectificar())) {
			if(lista.isSelectionEmpty() == false) {
				int index = lista.getSelectedIndex();
				Oferta o = (Oferta)lista.getModel().getElementAt(index);
				ventana.getPanelRectificar().iniciar(o);
				ventana.mostrarPanelRectificar();
			}
		}
		
	}

}
