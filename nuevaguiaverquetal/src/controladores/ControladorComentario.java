package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;

import app.Sistema;
import excepciones.ArgumentoNoValido;
import gui.CustomFrame;
import ofertas.Comentario;
import paneles.ComentarioPanel;

/**
 * Descripcion de la clase ControladorComentario
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class ControladorComentario implements ActionListener{
	private CustomFrame ventana;
	private Sistema app;
	
	/**
	 * Constructor del controlador
	 * @param ventana ventana personalizada que contiene a los paneles
	 * @param app sistema con los datos y funciones pertinentes
	 */
	public ControladorComentario(CustomFrame ventana, Sistema app) {
		this.ventana = ventana; 
		this.app = app;
	}
	
	/**
	 * Gestiona las diferentes acciones que se pueden hacer en el panel de
	 * comentarios
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		ComentarioPanel panel = ventana.getPanelComentario();
		JList list = panel.getComents();
		Comentario c;
		int index;
		
		if(event.equals(panel.getResponder())) {
			if(list.isSelectionEmpty()) {
				return;
			}
			index = list.getSelectedIndex();
			c = (Comentario)list.getModel().getElementAt(index);
			
			String texto = JOptionPane.showInputDialog("Introduzca el texto de su comentario");
			Comentario res = new Comentario(app.getUsuarioActual(), texto);
			
			try {
				c.addRespuesta(res);
			} catch (ArgumentoNoValido e) {
				JOptionPane.showMessageDialog(null, "Ha habido un error inesperado!");
			}
		}else if(event.equals(panel.getRespuestas())) {
			if(list.isSelectionEmpty()) {
				return;
			}
			index = list.getSelectedIndex();
			c = (Comentario)list.getModel().getElementAt(index);
			
			panel.getModelo().clear();
			panel.modificarModelo(c.getRespuestas());
			
		}else if(event.equals(panel.getVolver())) {
			ventana.mostrarPanelVerOferta();
		}
	}

}
