package paneles;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ofertas.Comentario;
/**
 * Descripcion de la clase ComentarioPanel
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class ComentarioPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JScrollPane  lista;

	private JList coments;
	private DefaultListModel modelo = new DefaultListModel();
	
	private JButton responder = new JButton("Responder");
	private JButton respuestas = new JButton("Ver respuestas");
	private JButton volver = new JButton("Volver");
	
	
	/**
	 * Constructor del panel de comentarios
	 */
	
	public ComentarioPanel() {
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		
		JPanel botonera = new JPanel(new FlowLayout());
		botonera.add(responder);
		botonera.add(respuestas);
		
		coments = new JList();
		coments.setModel(modelo);
		lista = new JScrollPane(coments);
		
		this.add(lista);
		this.add(botonera);
		this.add(volver);
		
	}
	
	/**
	 * actualiza el modelo de la lista de comentarios
	 * @param comentarios lista de comentarios a introducir en el modelo
	 */
	public void modificarModelo(List<Comentario> comentarios) {
		this.getModelo().clear();
		for(Comentario c: comentarios) {
			this.getModelo().addElement(c);
		}
	}
	
	/**
	 * Establece un controlador para el panel
	 * @param a1 controlador del panel
	 */
	public void setControlador(ActionListener a1) {
		responder.addActionListener(a1);
		respuestas.addActionListener(a1);
		volver.addActionListener(a1);
	}

	/**
	 * @return the coments
	 */
	public JList getComents() {
		return coments;
	}

	/**
	 * @param coments the coments to set
	 */
	public void setComents(JList coments) {
		this.coments = coments;
	}

	/**
	 * @return the modelo
	 */
	public DefaultListModel getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(DefaultListModel modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the responder
	 */
	public JButton getResponder() {
		return responder;
	}

	/**
	 * @return the respuestas
	 */
	public JButton getRespuestas() {
		return respuestas;
	}

	/**
	 * @return the volver
	 */
	public JButton getVolver() {
		return volver;
	}


}
