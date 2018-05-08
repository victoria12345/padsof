package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ofertas.Oferta;

public class RectificarPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JLabel oPrecio = new JLabel("Precio:");
	private JLabel oIni = new JLabel("Fecha ini:");
	private JLabel oDesc = new JLabel("Descripcion:");
	private JLabel nmeses = new JLabel("Numero de meses:");
	private JLabel fin = new JLabel("Fecha fin:");
	private JLabel fianza = new JLabel("Fianza");
	
	private JTextField campoPrecio = new JTextField(10);
	private JTextField campoIni = new JTextField(10);
	private JTextField campoFin = new JTextField(10);
	private JTextField campoDesc = new JTextField(10);
	private JTextField campoNmeses = new JTextField(10);
	private JTextField campoFianza = new JTextField(10);
	
	private Oferta oferta;
	
	private JButton rectificar = new JButton("Rectificar");
	private JButton volver = new JButton("Volver");
	
	public RectificarPanel() {
		
		GridBagLayout layout2 = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();
		this.setLayout(layout2);
		
		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.EAST;
		
		JPanel panel1 = new JPanel();
		panel1.add(oPrecio);
		panel1.add(campoPrecio);
		cons.gridx = 1;
		cons.gridy = 0;
		layout2.setConstraints(panel1, cons);
		
		JPanel panel2 = new JPanel();
		panel2.add(oIni);
		panel2.add(campoIni);
		cons.gridx = 1;
		cons.gridy = 1;
		layout2.setConstraints(panel2, cons);
		
		JPanel panel3 = new JPanel();
		panel3.add(fin);
		panel3.add(campoFin);
		cons.gridx = 1;
		cons.gridy = 2;
		layout2.setConstraints(panel3, cons);
		
		JPanel panel4 = new JPanel();
		panel4.add(oDesc);
		panel4.add(campoDesc);
		cons.gridx = 2;
		cons.gridy = 0;
		layout2.setConstraints(panel4, cons);
		
		JPanel panel6 = new JPanel();
		panel6.add(nmeses);
		panel6.add(campoNmeses);
		cons.gridx = 2;
		cons.gridy = 1;
		layout2.setConstraints(panel6, cons);
		
		JPanel panel7 = new JPanel();
		panel7.add(fianza);
		panel7.add(campoFianza);
		cons.gridx = 2;
		cons.gridy = 2;
		layout2.setConstraints(panel7, cons);
		
		cons.gridx = 1;
		cons.gridy = 3;
		layout2.setConstraints(rectificar, cons);
		
		cons.gridx = 2;
		cons.gridy = 3;
		layout2.setConstraints(volver, cons);
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel6);
		this.add(panel7);
		this.add(rectificar);
		this.add(volver);
	}
	
	public void iniciar(Oferta o) {
		this.oferta = o;
		
		if(o.isResidencial()) {
			this.campoFianza.setVisible(false);
			this.fianza.setVisible(false);
			this.campoFin.setVisible(false);
			this.fin.setVisible(false);
			this.campoNmeses.setVisible(true);
			this.nmeses.setVisible(true);
		}else if(o.isVacacional()) {
			this.campoFianza.setVisible(true);
			this.fianza.setVisible(true);
			this.campoFin.setVisible(true);
			this.fin.setVisible(true);
			this.campoNmeses.setVisible(false);
			this.nmeses.setVisible(false);
		}
	}
	
	public void setControlador(ActionListener a1) {
		rectificar.addActionListener(a1);
		volver.addActionListener(a1);
	}

	/**
	 * @return the oPrecio
	 */
	public JLabel getoPrecio() {
		return oPrecio;
	}

	/**
	 * @param oPrecio the oPrecio to set
	 */
	public void setoPrecio(JLabel oPrecio) {
		this.oPrecio = oPrecio;
	}

	/**
	 * @return the oIni
	 */
	public JLabel getoIni() {
		return oIni;
	}

	/**
	 * @param oIni the oIni to set
	 */
	public void setoIni(JLabel oIni) {
		this.oIni = oIni;
	}

	/**
	 * @return the oDesc
	 */
	public JLabel getoDesc() {
		return oDesc;
	}

	/**
	 * @param oDesc the oDesc to set
	 */
	public void setoDesc(JLabel oDesc) {
		this.oDesc = oDesc;
	}

	/**
	 * @return the nmeses
	 */
	public JLabel getNmeses() {
		return nmeses;
	}

	/**
	 * @param nmeses the nmeses to set
	 */
	public void setNmeses(JLabel nmeses) {
		this.nmeses = nmeses;
	}

	/**
	 * @return the fin
	 */
	public JLabel getFin() {
		return fin;
	}

	/**
	 * @param fin the fin to set
	 */
	public void setFin(JLabel fin) {
		this.fin = fin;
	}

	/**
	 * @return the fianza
	 */
	public JLabel getFianza() {
		return fianza;
	}

	/**
	 * @param fianza the fianza to set
	 */
	public void setFianza(JLabel fianza) {
		this.fianza = fianza;
	}

	/**
	 * @return the campoPrecio
	 */
	public JTextField getCampoPrecio() {
		return campoPrecio;
	}

	/**
	 * @param campoPrecio the campoPrecio to set
	 */
	public void setCampoPrecio(JTextField campoPrecio) {
		this.campoPrecio = campoPrecio;
	}

	/**
	 * @return the campoIni
	 */
	public JTextField getCampoIni() {
		return campoIni;
	}

	/**
	 * @param campoIni the campoIni to set
	 */
	public void setCampoIni(JTextField campoIni) {
		this.campoIni = campoIni;
	}

	/**
	 * @return the campoFin
	 */
	public JTextField getCampoFin() {
		return campoFin;
	}

	/**
	 * @param campoFin the campoFin to set
	 */
	public void setCampoFin(JTextField campoFin) {
		this.campoFin = campoFin;
	}

	/**
	 * @return the campoDesc
	 */
	public JTextField getCampoDesc() {
		return campoDesc;
	}

	/**
	 * @param campoDesc the campoDesc to set
	 */
	public void setCampoDesc(JTextField campoDesc) {
		this.campoDesc = campoDesc;
	}

	/**
	 * @return the campoNmeses
	 */
	public JTextField getCampoNmeses() {
		return campoNmeses;
	}

	/**
	 * @param campoNmeses the campoNmeses to set
	 */
	public void setCampoNmeses(JTextField campoNmeses) {
		this.campoNmeses = campoNmeses;
	}

	/**
	 * @return the campoFianza
	 */
	public JTextField getCampoFianza() {
		return campoFianza;
	}

	/**
	 * @param campoFianza the campoFianza to set
	 */
	public void setCampoFianza(JTextField campoFianza) {
		this.campoFianza = campoFianza;
	}

	/**
	 * @return the rectificar
	 */
	public JButton getRectificar() {
		return rectificar;
	}

	/**
	 * @param rectificar the rectificar to set
	 */
	public void setRectificar(JButton rectificar) {
		this.rectificar = rectificar;
	}

	/**
	 * @return the volver
	 */
	public JButton getVolver() {
		return volver;
	}

	/**
	 * @param volver the volver to set
	 */
	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	/**
	 * @return the oferta
	 */
	public Oferta getOferta() {
		return oferta;
	}

	/**
	 * @param oferta the oferta to set
	 */
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
	
	

}
