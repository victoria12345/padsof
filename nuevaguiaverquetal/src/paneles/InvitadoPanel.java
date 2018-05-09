package paneles;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import app.Sistema;
import ofertas.Oferta;

/**
 * Descripcion de la clase InvitadoPanel
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
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
	
	/**
	 * Constructor del panel de invitado
	 * @param sist sistema con los datos y funciones pertinentes
	 */
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
	
	/**
	 * Establece un controlador para el panel
	 * @param a1 controlador del panel
	 */
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
	 * @return the labelPrecio
	 */
	public JLabel getLabelPrecio() {
		return labelPrecio;
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
	 * @return the botonFiltrar
	 */
	public JButton getBotonFiltrar() {
		return botonFiltrar;
	}

	/**
	 * @return the botonMostrarTodas
	 */
	public JButton getBotonMostrarTodas() {
		return botonMostrarTodas;
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
