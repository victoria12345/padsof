package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import inmuebles.CampoAbierto;

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
	private JButton bCancelar = new JButton("Cancelar");
	
	private List<CampoAbierto> campos = new ArrayList<CampoAbierto>();
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
		
		cons.gridy = 4;
		layout.setConstraints(bCancelar, cons);
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.add(bSubir);
		this.add(bAddCampo);
		this.add(bCancelar);
	}

	public JButton getbCancelar() {
		return bCancelar;
	}

	public void setbCancelar(JButton bCancelar) {
		this.bCancelar = bCancelar;
	}

	public JTextField getCampoDesc() {
		return campoDesc;
	}

	public void setCampoDesc(JTextField campoDesc) {
		this.campoDesc = campoDesc;
	}

	public JTextField getCampoLoc() {
		return campoLoc;
	}

	public void setCampoLoc(JTextField campoLoc) {
		this.campoLoc = campoLoc;
	}

	public JTextField getCampoCP() {
		return campoCP;
	}

	public void setCampoCP(JTextField campoCP) {
		this.campoCP = campoCP;
	}

	public JTextField getCampoClave() {
		return campoClave;
	}

	public void setCampoClave(JTextField campoClave) {
		this.campoClave = campoClave;
	}

	public JTextField getCampoValor() {
		return campoValor;
	}

	public void setCampoValor(JTextField campoValor) {
		this.campoValor = campoValor;
	}

	public JButton getbSubir() {
		return bSubir;
	}

	public void setbSubir(JButton bSubir) {
		this.bSubir = bSubir;
	}

	public JButton getbAddCampo() {
		return bAddCampo;
	}

	public void setbAddCampo(JButton bAddCampo) {
		this.bAddCampo = bAddCampo;
	}
	
	public void setControlador(ActionListener al) {
		this.bAddCampo.addActionListener(al);
		this.bSubir.addActionListener(al);
		this.bCancelar.addActionListener(al);
	}

	/**
	 * @return the campos
	 */
	public List<CampoAbierto> getCampos() {
		return campos;
	}

	/**
	 * @param campos the campos to set
	 */
	public void setCampos(List<CampoAbierto> campos) {
		this.campos = campos;
	}
	

}
