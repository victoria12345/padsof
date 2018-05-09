package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;

import app.Sistema;
import excepciones.ArgumentoNoValido;
import gui.CustomFrame;
import ofertas.Oferta;
import paneles.OfertasAsociadasPanel;

/**
 * Descripcion de la clase ControladorAsociadas
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class ControladorAsociadas implements ActionListener {
	private Sistema app;
	private CustomFrame ventana;
	
	/**
	 * Constructor del controlador
	 * @param ventana ventana personalizada que contiene a los paneles
	 * @param app sistema con los datos y funciones pertinentes
	 */
	public ControladorAsociadas(Sistema app, CustomFrame gui) {
		this.ventana = gui;
		this.app = app;
	}

	/**
	 * Gestiona las diferentes acciones que se pueden hacer en el panel de ofertas 
	 * asociadas
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		OfertasAsociadasPanel panel = ventana.getPanelAsociadas();
		
		if(event.equals(panel.getbAtras())) {
			ventana.mostrarPanelInmuebles();
			
		}else if(event.equals(panel.getbElim())) {
			if(panel.getOfertas().isSelectionEmpty()) {
				return;
			}
			int index = panel.getOfertas().getSelectedIndex();
			Oferta o = (Oferta)panel.getModelo().getElementAt(index);
			
			panel.getModelo().removeElementAt(index);
			try {
				panel.getI().eliminarOferta(o);
				if(app.getOfertas().contains(o)) {
					app.getOfertas().remove(o);
					ventana.getPanelOfertas().getModelo().removeElement(o);
				}
			} catch (ArgumentoNoValido e) {
				JOptionPane.showMessageDialog(null, "Errorsito");
			}
			
		}
		
	}
}
