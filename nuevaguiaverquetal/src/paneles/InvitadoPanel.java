package paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

import app.Sistema;
import ofertas.Oferta;

public class InvitadoPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JScrollPane  listaOfer;
	private JList ofers = new JList();
	private DefaultListModel modelo = new DefaultListModel();
	private JButton salir = new JButton("Salir");
	
	private JLabel labelCP = new JLabel("Código postal:");
	private JLabel labelPrecio = new JLabel("Precio:");
	private JLabel labelIni = new JLabel("Fecha inicio:");
	private JLabel labelFin = new JLabel("Fecha fin:");
	private JTextField campoCP = new JTextField(10);
	private JTextField campoPrecio = new JTextField(10);
	private JTextField campoIni = new JTextField(10);
	private JTextField campoFin = new JTextField(10);
	private JButton botonFiltrar = new JButton("Filtrar ofertas");
	private JButton botonMostrarTodas = new JButton("Mostrar todas");
	
	private Sistema sist;
	
	
	public InvitadoPanel(Sistema sist) {
		this.sist = sist;
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		
		JPanel panelOferta = new JPanel();
		JPanel panelLista = new JPanel();
		panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));
		
		panelOferta.setLayout(new BorderLayout());
		
		JPanel pFiltrar = new JPanel();
		GridBagLayout layout2 = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();
		pFiltrar.setLayout(layout2);
		
		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.EAST;
		
		JPanel panel1 = new JPanel();
		panel1.add(labelCP);
		panel1.add(campoCP);
		cons.gridx = 1;
		cons.gridy = 0;
		layout2.setConstraints(panel1, cons);
		
		JPanel panel2 = new JPanel();
		panel2.add(labelPrecio);
		panel2.add(campoPrecio);
		cons.gridx = 1;
		cons.gridy = 1;
		layout2.setConstraints(panel2, cons);
		
		JPanel panel6 = new JPanel();
		panel6.add(labelIni);
		panel6.add(campoIni);
		cons.gridx = 2;
		cons.gridy = 0;
		layout2.setConstraints(panel6, cons);
		
		JPanel panel7 = new JPanel();
		panel7.add(labelFin);
		panel7.add(campoFin);
		cons.gridx = 2;
		cons.gridy = 1;
		layout2.setConstraints(panel7, cons);
		
		JPanel panel5 = new JPanel();
		panel5.add(botonFiltrar);
		cons.gridx = 1;
		cons.gridy = 2;
		layout2.setConstraints(panel5, cons);
		
		JPanel panel8 = new JPanel();
		panel8.add(botonMostrarTodas);
		cons.gridx = 2;
		cons.gridy = 2;
		layout2.setConstraints(panel8, cons);
		
		pFiltrar.add(panel1);
		pFiltrar.add(panel2);
		pFiltrar.add(panel6);
		pFiltrar.add(panel7);
		pFiltrar.add(panel5);
		pFiltrar.add(panel8);
		
		ofers.setModel(modelo);
		
		for(Oferta o: sist.getOfertas()) {
			modelo.addElement(o);
		}
		
		listaOfer = new JScrollPane(ofers);
		

		
		
		panelLista.add(listaOfer);
		panelLista.add(pFiltrar);

		
		
		this.add(panelLista);
		this.add(panelOferta);
		this.add(salir);
		
	}

	/**
	 * @return the listaOfer
	 */
	public JScrollPane getListaOfer() {
		return listaOfer;
	}


	/**
	 * @param listaOfer the listaOfer to set
	 */
	public void setListaOfer(JScrollPane listaOfer) {
		this.listaOfer = listaOfer;
	}

	/**
	 * @return the salir
	 */
	public JButton getSalir() {
		return salir;
	}


	/**
	 * @param salir the salir to set
	 */
	public void setSalir(JButton salir) {
		this.salir = salir;
	}


	/**
	 * @return the sist
	 */
	public Sistema getSist() {
		return sist;
	}


	/**
	 * @param sist the sist to set
	 */
	public void setSist(Sistema sist) {
		this.sist = sist;
	}
	
	public void setControlador(ActionListener a1) {
		this.salir.addActionListener(a1);
		botonFiltrar.addActionListener(a1);
		botonMostrarTodas.addActionListener(a1);
	}


	/**
	 * @return the ofers
	 */
	public JList getOfers() {
		return ofers;
	}


	/**
	 * @param ofers the ofers to set
	 */
	public void setOfers(JList ofers) {
		this.ofers = ofers;
	}


	/**
	 * @return the labelCP
	 */
	public JLabel getLabelCP() {
		return labelCP;
	}


	/**
	 * @param labelCP the labelCP to set
	 */
	public void setLabelCP(JLabel labelCP) {
		this.labelCP = labelCP;
	}


	/**
	 * @return the labelPrecio
	 */
	public JLabel getLabelPrecio() {
		return labelPrecio;
	}


	/**
	 * @param labelPrecio the labelPrecio to set
	 */
	public void setLabelPrecio(JLabel labelPrecio) {
		this.labelPrecio = labelPrecio;
	}


	/**
	 * @return the labelIni
	 */
	public JLabel getLabelIni() {
		return labelIni;
	}


	/**
	 * @param labelIni the labelIni to set
	 */
	public void setLabelIni(JLabel labelIni) {
		this.labelIni = labelIni;
	}


	/**
	 * @return the labelFin
	 */
	public JLabel getLabelFin() {
		return labelFin;
	}


	/**
	 * @param labelFin the labelFin to set
	 */
	public void setLabelFin(JLabel labelFin) {
		this.labelFin = labelFin;
	}


	/**
	 * @return the campoCP
	 */
	public JTextField getCampoCP() {
		return campoCP;
	}


	/**
	 * @param campoCP the campoCP to set
	 */
	public void setCampoCP(JTextField campoCP) {
		this.campoCP = campoCP;
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
	 * @return the botonFiltrar
	 */
	public JButton getBotonFiltrar() {
		return botonFiltrar;
	}


	/**
	 * @param botonFiltrar the botonFiltrar to set
	 */
	public void setBotonFiltrar(JButton botonFiltrar) {
		this.botonFiltrar = botonFiltrar;
	}


	/**
	 * @return the botonMostrarTodas
	 */
	public JButton getBotonMostrarTodas() {
		return botonMostrarTodas;
	}


	/**
	 * @param botonMostrarTodas the botonMostrarTodas to set
	 */
	public void setBotonMostrarTodas(JButton botonMostrarTodas) {
		this.botonMostrarTodas = botonMostrarTodas;
	}


	/**
	 * @return the modelo
	 */
	public DefaultListModel getModelo() {
		return modelo;
	}


	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(DefaultListModel modelo) {
		this.modelo = modelo;
	}

}
