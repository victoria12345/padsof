package paneles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import app.Sistema;
import inmuebles.Inmueble;

public class OfertaVacacionalPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel labelPrecio = new JLabel("Precio:");
	private JTextField campoPrecio = new JTextField(30);
	private JLabel labelIni = new JLabel("Fecha Inicial(int-int-int/ dd-mm-aaaa):");
	private JTextField campoIni = new JTextField(10);
	private JLabel labelFin = new JLabel("Fecha final(int-int-int/ dd-mm-aaaa):");
	private JTextField campoFin = new JTextField(10);
	private JLabel labelFianza = new JLabel("Fianza:");
	private JTextField campoFianza = new JTextField(10);
	
	private JButton bCancelar = new JButton("Cancelar");
	private JButton bAsociar = new JButton("Asociar");
	
	Sistema app;
	
	private Inmueble i;
	
	public OfertaVacacionalPanel(Sistema sist) {
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
		p3.add(labelFin);
		p3.add(campoFin);
		cons.gridy = 2;
		layout.setConstraints(p3, cons);
		
		JPanel p4 = new JPanel();
		p3.add(labelFianza);
		p3.add(campoFianza);
		cons.gridy = 3;
		layout.setConstraints(p4, cons);
		
		cons.gridx = 2;
		cons.gridy = 0;
		layout.setConstraints(bCancelar, cons);
		
		cons.gridy = 2;	
		layout.setConstraints(bAsociar, cons);
		
		this.campoPrecio.setText("");
		this.campoFianza.setText("");
		this.campoIni.setText("");
		this.campoFin.setText("");
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		
		this.add(bAsociar);
		this.add(bCancelar);
	}

	public void iniciar(Inmueble i) {
		this.i= i;
	}
	
	public Inmueble getInmueble() {
		return this.i;
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

	public JTextField getCampoFin() {
		return campoFin;
	}

	public void setCampoFin(JTextField campoFin) {
		this.campoFin = campoFin;
	}

	public JTextField getCampoFianza() {
		return campoFianza;
	}

	public void setCampoFianza(JTextField campoFianza) {
		this.campoFianza = campoFianza;
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
		this.bCancelar.addActionListener(al);
		this.bAsociar.addActionListener(al);
	}
}
