package paneles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import app.Sistema;
/**
 * Descripcion de la clase ElegirRolPanel
 * @author victoria Pelayo e Ignacio Rabunnal
 *
 */
public class ElegirRolPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel labelModo = new JLabel("Elija el modo que desea usar");
	
	private JLabel labelCont = new JLabel("Nueva Contraseña:");
	private JTextField campoCont = new JTextField(30);
	
	private JButton bOfertante = new JButton("Ofertante");
	private JButton bDemandante = new JButton("Demandante");
	private JButton bAdministrador = new JButton("Administrador");
	private JButton bSalir = new JButton("Salir");
	private JButton bCont = new JButton("Cambiar contrasenna");
	private Sistema sist;

	/**
	 * Constructor de la clase ElegirRolPanel
	 * @param sist sistema de la aplicacion
	 */
	public ElegirRolPanel(Sistema sist) {
		this.sist = sist;
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();
		this.setLayout(layout);
		
		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.WEST;
		
		cons.gridx = 1;
		cons.gridy = 0;
		layout.setConstraints(bOfertante, cons);
		
		cons.gridy = 1;
		layout.setConstraints(bAdministrador, cons);
		
		cons.gridy = 2;
		layout.setConstraints(bDemandante, cons);
		cons.gridy = 3;
		layout.setConstraints(bSalir, cons);
		
		cons.gridx = 0;
		cons.gridy = 0;
		JPanel p4 = new JPanel();
		p4.add(labelCont);
		p4.add(campoCont);
		cons.gridy = 1;
		layout.setConstraints(bCont, cons);
		
		cons.gridx = 0;
		cons.gridy = 7;
		JPanel p5 = new JPanel();
		p4.add(labelModo);
		
		
		
		this.add(p4);
		this.add(p5);
		this.add(bCont);
		this.add(bOfertante);
		this.add(bDemandante);
		this.add(bAdministrador);
		this.add(bSalir);
	}
	
	/**
	 * @return campo Contrasenna
	 */
	public JTextField getCampoCont() {
		return campoCont;
	}

	/**
	 * cambio del campo sontrasenna
	 * @param campoCont nuevo campo contrasenna
	 */
	public void setCampoCont(JTextField campoCont) {
		this.campoCont = campoCont;
	}

	/**
	 * @return boton ofertante
	 */
	public JButton getbOfertante() {
		return bOfertante;
	}

	/**
	 * Cambia boton ofertante
	 * @param bOfertante nuevo boton
	 */
	public void setbOfertante(JButton bOfertante) {
		this.bOfertante = bOfertante;
	}

	/**
	 * @return boton demandante
	 */
	public JButton getbDemandante() {
		return bDemandante;
	}

	/**
	 * @return boton administrador
	 */
	public JButton getbAdministrador() {
		return bAdministrador;
	}


	/**
	 * @return boton salir
	 */
	public JButton getbSalir() {
		return bSalir;
	}
	/**
	 * @return boton cambiar contrasenna
	 */
	public JButton getbCont() {
		return bCont;
	}
	/**
	 * @return sistema de la aplicacion
	 */
	public Sistema getSist() {
		return sist;
	}

	/**
	 * Cabia sistema de la aplicacion
	 * @param sist nuevo sistema
	 */
	public void setSist(Sistema sist) {
		this.sist = sist;
	}
	
	/**
	 * Cambia controlador del panel
	 * @param al nuevo controlador
	 */
	public void setControlador(ActionListener al) {
		this.bOfertante.addActionListener(al);
		this.bAdministrador.addActionListener(al);
		this.bDemandante.addActionListener(al);
		this.bSalir.addActionListener(al);
		this.bCont.addActionListener(al);
	}

}
