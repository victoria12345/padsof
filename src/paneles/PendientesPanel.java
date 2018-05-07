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

public class PendientesPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private JButton botonVer = new JButton("Ver oferta");
	private JButton botonVolver = new JButton("Volver");
	
	
	private JList pendientes = new JList();
	private DefaultListModel modelo = new DefaultListModel();
	private JScrollPane listPendientes;
	
	private Sistema app;
	
	public PendientesPanel(Sistema app) {
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		
		pendientes.setModel(modelo);
		for(Oferta o: app.getPendientes()) {
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
	 * @param botonVer the botonVer to set
	 */
	public void setBotonVer(JButton botonVer) {
		this.botonVer = botonVer;
	}

	/**
	 * @return the botonVolver
	 */
	public JButton getBotonVolver() {
		return botonVolver;
	}

	/**
	 * @param botonVolver the botonVolver to set
	 */
	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
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

	/**
	 * @param listPendientes the listPendientes to set
	 */
	public void setListPendientes(JScrollPane listPendientes) {
		this.listPendientes = listPendientes;
	}

}
