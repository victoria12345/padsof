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


/**
 * Descripcion de la clase SubirInmueblePanel
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
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

	/**
	 * Constructor del panel de SubirInmueble
	 */
	public SubirInmueblePanel() {
		
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

	public JTextField getCampoDesc() {
		return campoDesc;
	}

	public JTextField getCampoLoc() {
		return campoLoc;
	}

	public JTextField getCampoCP() {
		return campoCP;
	}

	public JTextField getCampoClave() {
		return campoClave;
	}

	public JTextField getCampoValor() {
		return campoValor;
	}

	public JButton getbSubir() {
		return bSubir;
	}

	public JButton getbAddCampo() {
		return bAddCampo;
	}

	
	/**
	 * Establece un controlador para el panel
	 * @param a1 controlador del panel
	 */
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
