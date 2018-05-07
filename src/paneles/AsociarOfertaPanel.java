package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.Sistema;

public class AsociarOfertaPanel extends JPanel{
	private String[] tipos = {"Vacacional", "Residencial"};
	private JComboBox tipoOferta = new JComboBox(tipos);
	private JLabel labelPrecio = new JLabel("Precio:");
	private JTextField campoPrecio = new JTextField(10);
	private JLabel labelIni = new JLabel("Fecha inicio(aaaa/mm/dd):");
	private JTextField campoIni = new JTextField(10);
	
	private JLabel labelFin = new JLabel("Fecha fin(aaaa/mm/dd):");
	private JTextField campoFin = new JTextField(10);
	private JLabel labelFianza = new JLabel("Fianza:");
	private JTextField campoFianza = new JTextField(10);
	
	private JLabel labelNmeses = new JLabel("Número de meses:");
	private JTextField campoNmeses = new JTextField(10);
	
	private JButton botonAsociar = new JButton("Asociar Oferta");
	
	private Sistema sist;
	
	public AsociarOfertaPanel(Sistema sist) {
		this.sist = sist;
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();
		this.setLayout(layout);
		
		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.WEST;
		
		cons.gridx = 1;
		cons.gridy = 0;
		layout.setConstraints(tipoOferta, cons);
		
		JPanel p1 = new JPanel();
		p1.add(labelPrecio);
		p1.add(campoPrecio);
		cons.gridy = 1;
		layout.setConstraints(p1, cons);
		
		JPanel p2 = new JPanel();
		p2.add(labelIni);
		p2.add(campoIni);
		cons.gridy = 2;
		layout.setConstraints(p2, cons);
		
		JPanel p3 = new JPanel();
		campoFin.setText("Solo vacacionales");
		p3.add(labelFin);
		p3.add(campoFin);
		cons.gridy = 3;
		layout.setConstraints(p3, cons);
		
		JPanel p4 = new JPanel();
		campoFianza.setText("Solo vacacionales");
		p4.add(labelFianza);
		p4.add(campoFianza);
		cons.gridy = 4;
		layout.setConstraints(p4, cons);
		
		JPanel p5 = new JPanel();
		campoNmeses.setText("Solo residenciales");
		p5.add(labelNmeses);
		p5.add(campoNmeses);
		cons.gridy = 5;
		layout.setConstraints(p5, cons);
		
		cons.gridy = 6;
		layout.setConstraints(botonAsociar, cons);
		
		this.add(tipoOferta);
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.add(botonAsociar);
		
		
	}

}
