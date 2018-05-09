package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import gui.CustomFrame;
import paneles.EleccionOfertaPanel;

/**
 * Descripcion de la clase ControladorEleccion
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class ControladorEleccion implements ActionListener{
	private CustomFrame ventana;
	
	/**
	 * Constructor del controlador
	 * @param ventana ventana personalizada que contiene a los paneles
	 * @param app sistema con los datos y funciones pertinentes
	 */
	public ControladorEleccion(CustomFrame gui) {
		this.ventana = gui; 

	}
	
	/**
	 * Gestiona las diferentes acciones que se pueden hacer en el panel de
	 * eleccion de oferta
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		EleccionOfertaPanel pEleccion = ventana.getPanelEleccion();
		
		if(event.equals(pEleccion.getbVacacional())){
			ventana.getPanelOfertaVac().iniciar(pEleccion.getInmueble());
			ventana.mostrarPanelOfertaVac();
		}else if(event.equals(pEleccion.getbResidencial())) {
			ventana.getPanelOfertaRes().iniciar(pEleccion.getInmueble());
			ventana.mostrarPanelOfertaRes();
		}else if((event.equals(pEleccion.getbAtras()))){
			ventana.mostrarPanelInmuebles();
		}
	}
}
