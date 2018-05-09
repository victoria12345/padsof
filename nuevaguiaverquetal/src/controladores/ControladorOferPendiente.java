package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import app.Sistema;
import gui.CustomFrame;
import ofertas.Oferta;
import paneles.OferPendientePanel;
import paneles.PendientesPanel;

/**
 * Descripcion de la clase ControladoOferPendiente
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class ControladorOferPendiente implements ActionListener{
	private CustomFrame ventana;
	private Sistema app;
	
	/**
	 * Constructor del controlador
	 * @param ventana ventana personalizada que contiene a los paneles
	 * @param app sistema con los datos y funciones pertinentes
	 */
	public ControladorOferPendiente(CustomFrame ventana, Sistema app) {
		this.ventana = ventana; 
		this.app = app;	
	}
	
	/**
	 * Gestiona las diferentes acciones que se pueden hacer en el panel de
	 * de oferta pendiente
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		OferPendientePanel panel = ventana.getPanelOferPendiente();
		Object event = arg0.getSource();
		Oferta o = panel.getOferta();
		PendientesPanel pend = ventana.getPanelPendientes();
		
		
		if(event.equals(panel.getBotAceptar())) {
			app.aceptarOferta(o);
			ventana.getPanelOfertas().getModelo().addElement(o);
			JOptionPane.showMessageDialog(null, "La oferta ha sido aceptada");
			pend.getModelo().removeElement(o);
				
		}else if(event.equals(panel.getBotRect())) {
			String rect;
			rect = JOptionPane.showInputDialog("Introduzca una rectificación para el ofertante");
			app.rectificar(o, rect, ventana.getFecha());
			
		}else if(event.equals(panel.getBotVolver())) {
			pend.getPendientes().clearSelection();
			ventana.mostrarPanelPendientes();
		}
	}

}
