package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.Sistema;


public class SubirInmueblePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JLabel labelDesc = new JLabel("Descripcion:");
	private JTextField campoDesc = new JTextField(30);
	private JLabel labelLoc = new JLabel("Localización:");
	private JTextField campoLoc = new JTextField(30);
	private JLabel labelCP = new JLabel("Codigo postal:");
	private JTextField campoCP = new JTextField(10);
	
	private JLabel labelClave = new JLabel("Clave:");
	private JTextField campoClave = new JTextField(10);
	private JLabel labelValor = new JLabel("Valor:");
	private JTextField campoValor = new JTextField(10);
	
	private JButton bSubir = new JButton("Subir");
	private JButton bAddCampo = new JButton("Añadir campo abierto");
	private Sistema sist;

	public SubirInmueblePanel(Sistema sist) {
		this.sist = sist;
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();
		this.setLayout(layout);
		
		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.WEST;
		
		cons.gridx = 1;
		
		JPanel p1 = new JPanel();
		p1.add(labelLoc);
		p1.add(campoLoc);
		cons.gridy = 0;
		layout.setConstraints(p1, cons);
		
		JPanel p2 = new JPanel();
		p2.add(labelCP);
		p2.add(campoCP);
		cons.gridy = 1;
		layout.setConstraints(p2, cons);
		
		JPanel p3 = new JPanel();
		p3.add(labelDesc);
		p3.add(campoDesc);
		cons.gridy = 2;
		layout.setConstraints(p3, cons);
		
		cons.gridy = 3;
		layout.setConstraints(bSubir, cons);
		
		JPanel p4 = new JPanel();
		p4.add(labelClave);
		p4.add(campoClave);
		cons.gridx = 2;
		cons.gridy = 0;
		layout.setConstraints(p4, cons);
		
		JPanel p5 = new JPanel();
		p5.add(labelValor);
		p5.add(campoValor);
		cons.gridy = 1;
		layout.setConstraints(p5, cons);
		
		cons.gridy = 2;
		layout.setConstraints(bAddCampo, cons);
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.add(bSubir);
		this.add(bAddCampo);
		
		
	}

}
