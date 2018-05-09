package paneles;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import app.Sistema;
import ofertas.Oferta;
/**
 * Descripcion de la clase PendientesPanel
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class PendientesPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private JButton botonVer = new JButton("Ver oferta");
	private JButton botonVolver = new JButton("Volver");
	
	
	private JList pendientes = new JList();
	private DefaultListModel modelo = new DefaultListModel();
	private JScrollPane listPendientes;
	
	private Sistema app;
	/**
	 * Constructor del panel de pendientes
	 * @param sist sistema con los datos y funciones pertinentes
	 */
	public PendientesPanel(Sistema app) {
		this.app = app;
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		
		pendientes.setModel(modelo);
		for(Oferta o: this.app.getPendientes()) {
			modelo.addElement(o);
		}
		listPendientes = new JScrollPane(pendientes);
		
		JPanel botones2 = new JPanel();
		botones2.setLayout(new FlowLayout());
		botones2.add(botonVer);
		botones2.add(botonVolver);
		
		this.add(listPendientes);
		this.add(botones2);
	}
	
	/**
	 * Establece un controlador para el panel
	 * @param a1 controlador del panel
	 */
	public void setControlador(ActionListener a1) {
		botonVer.addActionListener(a1);
		botonVolver.addActionListener(a1);
	}

	/**
	 * @return the botonVer
	 */
	public JButton getBotonVer() {
		return botonVer;
	}
	/**
	 * @return the botonVolver
	 */
	public JButton getBotonVolver() {
		return botonVolver;
	}

	/**
	 * @return the pendientes
	 */
	public JList getPendientes() {
		return pendientes;
	}

	/**
	 * @param pendientes the pendientes to set
	 */
	public void setPendientes(JList pendientes) {
		this.pendientes = pendientes;
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
	 * @return the listPendientes
	 */
	public JScrollPane getListPendientes() {
		return listPendientes;
	}


}
