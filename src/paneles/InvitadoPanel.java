package paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;

import app.Sistema;
import ofertas.Oferta;

public class InvitadoPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JScrollPane  listaOfer;
	private JList ofers = new JList();
	
	private JLabel rotulo = new JLabel("Oferta:"); 
	
	private JButton salir = new JButton("Salir");

	
	private Sistema sist;
	
	
	public InvitadoPanel(Sistema sist) {
		this.sist = sist;
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		JPanel panelOferta = new JPanel();
		JPanel panelLista = new JPanel();
		panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));
		
		panelOferta.setLayout(new BorderLayout());
		panelOferta.add(rotulo, BorderLayout.NORTH);
		panelOferta.add(salir, BorderLayout.SOUTH);
		
		
		

		
		
		FiltrarPanel pFiltrar = new FiltrarPanel(sist);
		pFiltrar.getLabelValoracion().setVisible(false);
		pFiltrar.getLabelDisp().setVisible(false);
		pFiltrar.getCampoValoracion().setVisible(false);
		pFiltrar.getComboDisp().setVisible(false);
		
		
		DefaultListModel modelo = new DefaultListModel();
		
		ofers.setModel(modelo);
		
		for(Oferta o: sist.getOfertas()) {
			modelo.addElement(o);
		}
		
		listaOfer = new JScrollPane(ofers);
		

		
		
		panelLista.add(listaOfer);
		panelLista.add(pFiltrar);

		
		
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
	 * @return the rotulo
	 */
	public JLabel getRotulo() {
		return rotulo;
	}


	/**
	 * @param rotulo the rotulo to set
	 */
	public void setRotulo(JLabel rotulo) {
		this.rotulo = rotulo;
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
	
	public void setControlador(ActionListener a1, ListSelectionListener l1) {
		this.salir.addActionListener(a1);
		this.ofers.addListSelectionListener(l1);
	}

}
