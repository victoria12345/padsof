package paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import app.Sistema;
import inmuebles.Inmueble;
import ofertas.Oferta;
import usuarios.Ofertante;
import usuarios.Rol;
import usuarios.Usuario;


public class OfertasAsociadasPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JList ofertas = new JList();
	private DefaultListModel modelo = new DefaultListModel();
	private JScrollPane listaOfertas;
	private JButton bAtras = new JButton("Atrás");
	
	private Sistema sist;
	
	public OfertasAsociadasPanel(Sistema app) {
		this.sist = app;
		
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		ofertas.setModel(modelo);
		
		listaOfertas = new JScrollPane(ofertas);
		
		JPanel panelOfertas = new JPanel();
		
		panelOfertas.setLayout(new BoxLayout(panelOfertas, BoxLayout.Y_AXIS));
		panelOfertas.add(listaOfertas);
		
		JPanel botones2 = new JPanel();
		botones2.setLayout(new FlowLayout());
		
		botones2.add(bAtras);
		
		this.add(panelOfertas, BorderLayout.CENTER);
		this.add(botones2, BorderLayout.SOUTH);
		
	}
	
	/**
	 * @return the ofertas
	 */
	public JList getOfertas() {
		return ofertas;
	}

	/**
	 * @param ofertas the ofertas to set
	 */
	public void setOfertas(JList ofertas) {
		this.ofertas = ofertas;
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
	 * @return the listaOfertas
	 */
	public JScrollPane getListaOfertas() {
		return listaOfertas;
	}

	/**
	 * @param listaOfertas the listaOfertas to set
	 */
	public void setListaOfertas(JScrollPane listaOfertas) {
		this.listaOfertas = listaOfertas;
	}

	/**
	 * @return the bAtras
	 */
	public JButton getbAtras() {
		return bAtras;
	}

	/**
	 * @param bAtras the bAtras to set
	 */
	public void setbAtras(JButton bAtras) {
		this.bAtras = bAtras;
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

	public void iniciar(Inmueble i) {
		for(Oferta o: i.getOfertas()) {
			modelo.addElement(o);
		}
	}
	
	public void setControlador(ActionListener al) {
		this.bAtras.addActionListener(al);
	}
}
