package paneles;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import app.Sistema;

public class OfertaResidencialPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel labelPrecio = new JLabel("Precio:");
	private JTextField campoPrecio = new JTextField(30);
	private JLabel labelIni = new JLabel("Fecha Inicial:");
	private JTextField campoIni = new JTextField(30);
	private JLabel labelnMeses = new JLabel("Numero de meses:");
	private JTextField camponMeses = new JTextField(10);
	
	private Sistema app;
	
	private JButton bCancelar = new JButton("Cancelar");
	private JButton bAsociar = new JButton("Asociar");
	
	public OfertaResidencialPanel(Sistema sist) {
		this.app = sist;
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();
		this.setLayout(layout);
		
		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.WEST;
		
		cons.gridx = 1;
		JPanel p1 = new JPanel();
		p1.add(labelPrecio);
		p1.add(campoPrecio);
		cons.gridy = 0;
		layout.setConstraints(p1, cons);
		
		JPanel p2 = new JPanel();
		p2.add(labelIni);
		p2.add(campoIni);
		cons.gridy = 1;
		layout.setConstraints(p2, cons);
		
		JPanel p3 = new JPanel();
		p3.add(labelnMeses);
		p3.add(camponMeses);
		cons.gridy = 2;
		layout.setConstraints(p3, cons);
		
		cons.gridx = 2;
		cons.gridy = 0;
		layout.setConstraints(bCancelar, cons);
		
		cons.gridy = 2;	
		layout.setConstraints(bAsociar, cons);
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		
		this.add(bAsociar);
		this.add(bCancelar);
	}

	public JTextField getCampoPrecio() {
		return campoPrecio;
	}

	public void setCampoPrecio(JTextField campoPrecio) {
		this.campoPrecio = campoPrecio;
	}

	public JTextField getCampoIni() {
		return campoIni;
	}

	public void setCampoIni(JTextField campoIni) {
		this.campoIni = campoIni;
	}

	public JTextField getCamponMeses() {
		return camponMeses;
	}

	public void setCamponMeses(JTextField camponMeses) {
		this.camponMeses = camponMeses;
	}

	public JButton getbCancelar() {
		return bCancelar;
	}

	public void setbCancelar(JButton bCancelar) {
		this.bCancelar = bCancelar;
	}

	public JButton getbAsociar() {
		return bAsociar;
	}

	public void setbAsociar(JButton bAsociar) {
		this.bAsociar = bAsociar;
	}
	
	public void setControlador(ActionListener al) {
		this.bAsociar.addActionListener(al);
		this.bCancelar.addActionListener(al);
	}
}
