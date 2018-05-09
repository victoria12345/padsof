package paneles;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import app.Sistema;
import ofertas.Oferta;
/**
 * Descripcion de la clase OferPanel
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class OferPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JScrollPane  listaOfer;
	private JList ofers;
	private DefaultListModel modelo = new DefaultListModel();
	
	
	
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
	private JLabel labelIni = new JLabel("Fecha inicio:");
	private JLabel labelFin = new JLabel("Fecha fin:");
	private JTextField campoCP = new JTextField(10);
	private JTextField campoPrecio = new JTextField(10);
	private JTextField campoValoracion = new JTextField(10);
	private JTextField campoIni = new JTextField(10);
	private JTextField campoFin = new JTextField(10);
	private JComboBox comboDisp = new JComboBox(disp);
	private JButton botonFiltrar = new JButton("Filtrar ofertas");
	private JButton botonMostrarTodas = new JButton("Mostrar todas");
	
	private Sistema sist;
	
	/**
	 * Constructor del panel de ofertas
	 * @param sist sistema con los datos y funciones pertinentes
	 */
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
		cons.gridx = 2;
		cons.gridy = 2;
		layout2.setConstraints(panel4, cons);
		
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
		cons.gridy = 3;
		layout2.setConstraints(panel5, cons);
		
		JPanel panel8 = new JPanel();
		panel8.add(botonMostrarTodas);
		cons.gridx = 2;
		cons.gridy = 3;
		layout2.setConstraints(panel8, cons);
		
		pFiltrar.add(panel1);
		pFiltrar.add(panel2);
		pFiltrar.add(panel3);
		pFiltrar.add(panel4);
		pFiltrar.add(panel6);
		pFiltrar.add(panel7);
		pFiltrar.add(panel5);
		pFiltrar.add(panel8);
		
		
		ofers = new JList();
		ofers.setModel(modelo);
		
		for(Oferta o: this.sist.getOfertas()) {
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
	
	/**
	 * Establece un controlador para el panel
	 * @param a1 controlador del panel
	 */
	public void setControlador(ActionListener a1) {
		botonDemandante.addActionListener(a1);
		botonVer.addActionListener(a1);
		botonVolver.addActionListener(a1);
		botonOrdenar.addActionListener(a1);
		botonFiltrar.addActionListener(a1);
		botonMostrarTodas.addActionListener(a1);
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
	 * @return the ordenes
	 */
	public String[] getOrdenes() {
		return ordenes;
	}

	/**
	 * @return the comboOrdenes
	 */
	public JComboBox getComboOrdenes() {
		return comboOrdenes;
	}

	/**
	 * @return the botonOrdenar
	 */
	public JButton getBotonOrdenar() {
		return botonOrdenar;
	}

	/**
	 * @return the botonVer
	 */
	public JButton getBotonVer() {
		return botonVer;
	}

	/**
	 * @return the botonVolver
	 */
	public JButton getBotonVolver() {
		return botonVolver;
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
	 * @return the disp
	 */
	public String[] getDisp() {
		return disp;
	}

	/**
	 * @return the labelCP
	 */
	public JLabel getLabelCP() {
		return labelCP;
	}

	/**
	 * @return the labelPrecio
	 */
	public JLabel getLabelPrecio() {
		return labelPrecio;
	}

	/**
	 * @return the labelValoracion
	 */
	public JLabel getLabelValoracion() {
		return labelValoracion;
	}

	/**
	 * @return the labelDisp
	 */
	public JLabel getLabelDisp() {
		return labelDisp;
	}

	/**
	 * @return the campoCP
	 */
	public JTextField getCampoCP() {
		return campoCP;
	}


	/**
	 * @return the campoPrecio
	 */
	public JTextField getCampoPrecio() {
		return campoPrecio;
	}


	/**
	 * @return the campoValoracion
	 */
	public JTextField getCampoValoracion() {
		return campoValoracion;
	}



	/**
	 * @return the comboDisp
	 */
	public JComboBox getComboDisp() {
		return comboDisp;
	}


	/**
	 * @return the botonFiltrar
	 */
	public JButton getBotonFiltrar() {
		return botonFiltrar;
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

	/**
	 * @return the labelIni
	 */
	public JLabel getLabelIni() {
		return labelIni;
	}

	/**
	 * @return the labelFin
	 */
	public JLabel getLabelFin() {
		return labelFin;
	}

	/**
	 * @return the campoIni
	 */
	public JTextField getCampoIni() {
		return campoIni;
	}

	/**
	 * @return the campoFin
	 */
	public JTextField getCampoFin() {
		return campoFin;
	}

	/**
	 * @return the botonMostrarTodas
	 */
	public JButton getBotonMostrarTodas() {
		return botonMostrarTodas;
	}
}
