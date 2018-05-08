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

public class ComentarioPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JScrollPane  lista;
	private JList coments;
	private DefaultListModel modelo = new DefaultListModel();
	
	private JButton responder = new JButton("Responder");
	private JButton respuestas = new JButton("Ver respuestas");
	private JButton volver = new JButton("Volver");
	
	
	
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
	
	public void modificarModelo(List<Comentario> comentarios) {
		this.getModelo().clear();
		for(Comentario c: comentarios) {
			this.getModelo().addElement(c);
		}
	}
	
	public void setControlador(ActionListener a1) {
		responder.addActionListener(a1);
		respuestas.addActionListener(a1);
		volver.addActionListener(a1);
	}

	/**
	 * @return the lista
	 */
	public JScrollPane getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(JScrollPane lista) {
		this.lista = lista;
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
	 * @param responder the responder to set
	 */
	public void setResponder(JButton responder) {
		this.responder = responder;
	}

	/**
	 * @return the respuestas
	 */
	public JButton getRespuestas() {
		return respuestas;
	}

	/**
	 * @param respuestas the respuestas to set
	 */
	public void setRespuestas(JButton respuestas) {
		this.respuestas = respuestas;
	}

	/**
	 * @return the volver
	 */
	public JButton getVolver() {
		return volver;
	}

	/**
	 * @param volver the volver to set
	 */
	public void setVolver(JButton volver) {
		this.volver = volver;
	}

}
