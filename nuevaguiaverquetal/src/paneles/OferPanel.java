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
	
	
	
	private JButton botonContratar = new JButton("Contratar");
	private JButton botonReservar = new JButton("Reservar");
	private JButton botonComentar = new JButton("Comentar");
	private JButton botonValorar = new JButton("Valorar");
	private JButton botonDemandante = new JButton("Mis reservas");
	private JLabel rotulo = new JLabel("Oferta:"); 
	
	private JLabel labelOrden = new JLabel("Orden:");
	private String[] ordenes = {"Más caras primero", "Más baratas primero"};
	private JComboBox comboOrdenes = new JComboBox(ordenes);
	private JButton botonOrdenar = new JButton("Ordenar");
	
	private Sistema sist;
	
	
	public OferPanel(Sistema sist) {
		this.sist = sist;
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		JPanel panelOferta = new JPanel();
		JPanel panelLista = new JPanel();
		panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));
		
		panelOferta.setLayout(new BorderLayout());
		panelOferta.add(rotulo, BorderLayout.NORTH);
		
		JPanel botones = new JPanel();
		botones.setLayout(new FlowLayout());
		botones.add(botonContratar);
		botones.add(botonReservar);
		botones.add(botonComentar);
		botones.add(botonValorar);
		botones.add(botonDemandante);
		
		
		
		panelOferta.add(botones, BorderLayout.SOUTH);
		
		
		FiltrarPanel pFiltrar = new FiltrarPanel(sist);
		
		
		JList ofers = new JList();
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
		
		
		panelLista.add(listaOfer);
		panelLista.add(pFiltrar);
		panelLista.add(panelOrdenar);
		panelLista.add(botonOrdenar);
		
		
		this.add(panelLista, BorderLayout.EAST);
		
		this.add(panelOferta, BorderLayout.WEST);
		
		
		
		
		
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
	 * @return the botonContratar
	 */
	public JButton getBotonContratar() {
		return botonContratar;
	}


	/**
	 * @param botonContratar the botonContratar to set
	 */
	public void setBotonContratar(JButton botonContratar) {
		this.botonContratar = botonContratar;
	}


	/**
	 * @return the botonReservar
	 */
	public JButton getBotonReservar() {
		return botonReservar;
	}


	/**
	 * @param botonReservar the botonReservar to set
	 */
	public void setBotonReservar(JButton botonReservar) {
		this.botonReservar = botonReservar;
	}


	/**
	 * @return the botonComentar
	 */
	public JButton getBotonComentar() {
		return botonComentar;
	}


	/**
	 * @param botonComentar the botonComentar to set
	 */
	public void setBotonComentar(JButton botonComentar) {
		this.botonComentar = botonComentar;
	}


	/**
	 * @return the botonValorar
	 */
	public JButton getBotonValorar() {
		return botonValorar;
	}


	/**
	 * @param botonValorar the botonValorar to set
	 */
	public void setBotonValorar(JButton botonValorar) {
		this.botonValorar = botonValorar;
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

	
	public void setControlador(ActionListener a1, ListSelectionListener l1) {
		this.botonDemandante.addActionListener(a1);
	}
}
