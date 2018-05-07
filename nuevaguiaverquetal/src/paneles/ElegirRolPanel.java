package paneles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import app.Sistema;


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

	public JTextField getCampoCont() {
		return campoCont;
	}

	public void setCampoCont(JTextField campoCont) {
		this.campoCont = campoCont;
	}

	public JButton getbOfertante() {
		return bOfertante;
	}

	public void setbOfertante(JButton bOfertante) {
		this.bOfertante = bOfertante;
	}

	public JButton getbDemandante() {
		return bDemandante;
	}

	public void setbDemandante(JButton bDemandante) {
		this.bDemandante = bDemandante;
	}

	public JButton getbAdministrador() {
		return bAdministrador;
	}

	public void setbAdministrador(JButton bAdministrador) {
		this.bAdministrador = bAdministrador;
	}

	public JButton getbSalir() {
		return bSalir;
	}

	public void setbSalir(JButton bSalir) {
		this.bSalir = bSalir;
	}

	public JButton getbCont() {
		return bCont;
	}

	public void setbCont(JButton bCont) {
		this.bCont = bCont;
	}

	public Sistema getSist() {
		return sist;
	}

	public void setSist(Sistema sist) {
		this.sist = sist;
	}
	
	public void setControlador(ActionListener al) {
		this.bOfertante.addActionListener(al);
		this.bAdministrador.addActionListener(al);
		this.bDemandante.addActionListener(al);
		this.bSalir.addActionListener(al);
		this.bCont.addActionListener(al);
	}

}
