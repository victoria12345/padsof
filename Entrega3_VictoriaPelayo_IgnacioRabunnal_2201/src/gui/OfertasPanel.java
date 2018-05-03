package gui;


import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class OfertasPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private String[] disp = {"Disponible", "Reservada","Contratada"};
	private Gui gui;
	private JLabel labelCP;
	private JLabel labelPrecio;
	private JLabel labelValoracion;
	private JLabel labelDisp;
	private JTextField campoCP;
	private JTextField campoPrecio;
	private JTextField campoValoracion;
	private JComboBox comboDisp = new JComboBox(disp);
	private JButton botonFiltrar;
	
	public OfertasPanel(Gui gui){
		this.gui = gui;
		this.setLayout(new FlowLayout());
		
		this.labelCP = new JLabel("Código postal");
		this.labelPrecio = new JLabel("Precio");
		this.labelValoracion = new JLabel("Valoración");
		this.labelDisp = new JLabel("Disponibilidad");
		
		this.campoCP = new JTextField(5);
		this.campoPrecio = new JTextField(5);
		this.campoValoracion = new JTextField(5);
		
		botonFiltrar.addActionListener(this);
		
		this.add(labelCP);
		this.add(labelPrecio);
		this.add(labelValoracion);
		this.add(labelDisp);
		this.add(campoCP);
		this.add(campoPrecio);
		this.add(campoValoracion);
		this.add(botonFiltrar);
		this.add(comboDisp);
	}
	
	
	public void actionPerformed(ActionEvent ev) {
		gui.
	}
}
