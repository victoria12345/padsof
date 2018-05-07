package paneles;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import app.Sistema;
import ofertas.Oferta;

public class OferPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JScrollPane  listaOfer;
	private JList ofers;
	
	
	
	
	private JButton botonDemandante = new JButton("Mis reservas");
	private JButton botonVer = new JButton("Ver Oferta");
	private JButton botonVolver = new JButton("Volver");
	
	private JLabel labelOrden = new JLabel("Orden:");
	private String[] ordenes = {"Más caras primero", "Más baratas primero"};
	private JComboBox comboOrdenes = new JComboBox(ordenes);
	private JButton botonOrdenar = new JButton("Ordenar");
	
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
	
	
	public OferPanel(Sistema sist) {
		this.sist = sist;
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		
		
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
		
		JPanel panel3 = new JPanel();
		panel3.add(labelValoracion);
		panel3.add(campoValoracion);
		cons.gridx = 1;
		cons.gridy = 2;
		layout2.setConstraints(panel3, cons);
		
		JPanel panel4 = new JPanel();
		panel4.add(labelDisp);
		panel4.add(comboDisp);
		cons.gridx = 1;
		cons.gridy = 3;
		layout2.setConstraints(panel4, cons);
		
		JPanel panel5 = new JPanel();
		panel5.add(botonFiltrar);
		cons.gridx = 1;
		cons.gridy = 4;
		layout2.setConstraints(panel5, cons);
		
		pFiltrar.add(panel1);
		pFiltrar.add(panel2);
		pFiltrar.add(panel3);
		pFiltrar.add(panel4);
		pFiltrar.add(panel5);
		
		
		ofers = new JList();
		DefaultListModel modelo = new DefaultListModel();
		
		ofers.setModel(modelo);
		
		for(Oferta o: sist.getOfertas()) {
			modelo.addElement(o);
		}
		
		listaOfer = new JScrollPane(ofers);
		
		JPanel panelOrdenar = new JPanel();
		panelOrdenar.setLayout(new FlowLayout());
		panelOrdenar.add(labelOrden);
		panelOrdenar.add(comboOrdenes);
		panelOrdenar.add(botonOrdenar);
		
		JPanel botonera = new JPanel(new FlowLayout());
		botonera.add(botonDemandante);
		botonera.add(botonVer);
		botonera.add(botonVolver);
		
		this.add(listaOfer);
		this.add(pFiltrar);
		this.add(panelOrdenar);
		this.add(botonera);
	}
	
	public void setControlador(ActionListener a1) {
		botonDemandante.addActionListener(a1);
		botonVer.addActionListener(a1);
		botonVolver.addActionListener(a1);
		botonOrdenar.addActionListener(a1);
		botonFiltrar.addActionListener(a1);
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
	 * @return the botonDemandante
	 */
	public JButton getBotonDemandante() {
		return botonDemandante;
	}


	/**
	 * @param botonDemandante the botonDemandante to set
	 */
	public void setBotonDemandante(JButton botonDemandante) {
		this.botonDemandante = botonDemandante;
	}


	/**
	 * @return the ordenes
	 */
	public String[] getOrdenes() {
		return ordenes;
	}


	/**
	 * @param ordenes the ordenes to set
	 */
	public void setOrdenes(String[] ordenes) {
		this.ordenes = ordenes;
	}


	/**
	 * @return the comboOrdenes
	 */
	public JComboBox getComboOrdenes() {
		return comboOrdenes;
	}


	/**
	 * @param comboOrdenes the comboOrdenes to set
	 */
	public void setComboOrdenes(JComboBox comboOrdenes) {
		this.comboOrdenes = comboOrdenes;
	}


	/**
	 * @return the botonOrdenar
	 */
	public JButton getBotonOrdenar() {
		return botonOrdenar;
	}


	/**
	 * @param botonOrdenar the botonOrdenar to set
	 */
	public void setBotonOrdenar(JButton botonOrdenar) {
		this.botonOrdenar = botonOrdenar;
	}
	/**
	 * @return the botonVer
	 */
	public JButton getBotonVer() {
		return botonVer;
	}


	/**
	 * @param botonVer the botonVer to set
	 */
	public void setBotonVer(JButton botonVer) {
		this.botonVer = botonVer;
	}


	/**
	 * @return the botonVolver
	 */
	public JButton getBotonVolver() {
		return botonVolver;
	}


	/**
	 * @param botonVolver the botonVolver to set
	 */
	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
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
	 * @return the labelOrden
	 */
	public JLabel getLabelOrden() {
		return labelOrden;
	}


	/**
	 * @param labelOrden the labelOrden to set
	 */
	public void setLabelOrden(JLabel labelOrden) {
		this.labelOrden = labelOrden;
	}


	/**
	 * @return the disp
	 */
	public String[] getDisp() {
		return disp;
	}


	/**
	 * @param disp the disp to set
	 */
	public void setDisp(String[] disp) {
		this.disp = disp;
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
	 * @return the labelValoracion
	 */
	public JLabel getLabelValoracion() {
		return labelValoracion;
	}


	/**
	 * @param labelValoracion the labelValoracion to set
	 */
	public void setLabelValoracion(JLabel labelValoracion) {
		this.labelValoracion = labelValoracion;
	}


	/**
	 * @return the labelDisp
	 */
	public JLabel getLabelDisp() {
		return labelDisp;
	}


	/**
	 * @param labelDisp the labelDisp to set
	 */
	public void setLabelDisp(JLabel labelDisp) {
		this.labelDisp = labelDisp;
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
	 * @return the campoValoracion
	 */
	public JTextField getCampoValoracion() {
		return campoValoracion;
	}


	/**
	 * @param campoValoracion the campoValoracion to set
	 */
	public void setCampoValoracion(JTextField campoValoracion) {
		this.campoValoracion = campoValoracion;
	}


	/**
	 * @return the comboDisp
	 */
	public JComboBox getComboDisp() {
		return comboDisp;
	}


	/**
	 * @param comboDisp the comboDisp to set
	 */
	public void setComboDisp(JComboBox comboDisp) {
		this.comboDisp = comboDisp;
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
}
