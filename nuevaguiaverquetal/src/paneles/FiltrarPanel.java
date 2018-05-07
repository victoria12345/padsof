package paneles;


import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

import javax.swing.*;

import app.Sistema;
import gui.CustomFrame;

public class FiltrarPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private String[] disp = {"Disponible", "Reservada","Contratada"};

	
	private JLabel labelCP = new JLabel("Código postal:");
	private JLabel labelPrecio = new JLabel("Precio:");
	private JLabel labelValoracion = new JLabel("Valoración:");
	private JLabel labelDisp = new JLabel("Disponibilidad:");
	private JTextField campoCP = new JTextField(10);
	private JTextField campoPrecio = new JTextField(10);
	private JTextField campoValoracion = new JTextField(10);
	private JComboBox comboDisp = new JComboBox(disp);
	
	
	private JButton botonFiltrar = new JButton("Filtrar ofertas");
	private Sistema sist;
;
	
	public FiltrarPanel(Sistema sist){
		this.sist = sist;

		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();
		this.setLayout(layout);
		
		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.EAST;
		
		JPanel panel1 = new JPanel();
		panel1.add(labelCP);
		panel1.add(campoCP);
		cons.gridx = 1;
		cons.gridy = 0;
		layout.setConstraints(panel1, cons);
		
		JPanel panel2 = new JPanel();
		panel2.add(labelPrecio);
		panel2.add(campoPrecio);
		cons.gridx = 1;
		cons.gridy = 1;
		layout.setConstraints(panel2, cons);
		
		JPanel panel3 = new JPanel();
		panel3.add(labelValoracion);
		panel3.add(campoValoracion);
		cons.gridx = 1;
		cons.gridy = 2;
		layout.setConstraints(panel3, cons);
		
		JPanel panel4 = new JPanel();
		panel4.add(labelDisp);
		panel4.add(comboDisp);
		cons.gridx = 1;
		cons.gridy = 3;
		layout.setConstraints(panel4, cons);
		
		JPanel panel5 = new JPanel();
		panel5.add(botonFiltrar);
		cons.gridx = 1;
		cons.gridy = 4;
		layout.setConstraints(panel5, cons);
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);
		

	

	}
}
