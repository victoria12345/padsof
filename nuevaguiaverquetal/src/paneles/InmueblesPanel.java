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

public class InmueblesPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JList inmuebles = new JList();
	private DefaultListModel modelo = new DefaultListModel();
	private JScrollPane listaInmuebles;
	private JButton bAñadir = new JButton("Nuevo inmueble");
	private JButton bAsociar = new JButton("Asociar oferta");
	private JButton bSalir = new JButton("Salir");
	private JButton bVer = new JButton("Ver Ofertas Asociadas");
	private JButton bAceptar = new JButton("Pendientes de aceptar");
	
	private Sistema sist;
	
	public InmueblesPanel(Sistema app) {
		this.sist = app;
		
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		inmuebles.setModel(modelo);
		
		listaInmuebles = new JScrollPane(inmuebles);
		
		JPanel panelInmu = new JPanel();
		
		panelInmu.setLayout(new BoxLayout(panelInmu, BoxLayout.Y_AXIS));
		panelInmu.add(listaInmuebles);
		JPanel botones2 = new JPanel();
		botones2.setLayout(new FlowLayout());
		
		botones2.add(bAñadir);
		botones2.add(bAsociar);
		botones2.add(bSalir);
		botones2.add(bVer);
		botones2.add(bAceptar);
		
		this.add(panelInmu, BorderLayout.CENTER);
		this.add(botones2, BorderLayout.SOUTH);
		
	}

	/**
	 * @return the bVer
	 */
	public JButton getbVer() {
		return bVer;
	}

	/**
	 * @return the inmuebles
	 */
	public JList getInmuebles() {
		return inmuebles;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(DefaultListModel modelo) {
		this.modelo = modelo;
	}
	
	/**
	 * @return the modelo
	 */
	public DefaultListModel getModelo() {
		return modelo;
	}

	/**
	 * @return the listaInmuebles
	 */
	public JScrollPane getListaInmuebles() {
		return listaInmuebles;
	}

	/**
	 * @return the bAñadir
	 */
	public JButton getbAñadir() {
		return bAñadir;
	}

	/**
	 * @return the bAsociar
	 */
	public JButton getbAsociar() {
		return bAsociar;
	}

	/**
	 * @return the bSalir
	 */
	public JButton getbSalir() {
		return bSalir;
	}
	
	/**
	 * @return the bAceptar
	 */
	public JButton getbAceptar() {
		return bAceptar;
	}

	/**
	 * @param bAceptar the bAceptar to set
	 */
	public void setbAceptar(JButton bAceptar) {
		this.bAceptar = bAceptar;
	}

	public void setControlador(ActionListener al) {
		this.bSalir.addActionListener(al);
		this.bAsociar.addActionListener(al);
		this.bAñadir.addActionListener(al);
		this.bVer.addActionListener(al);
		this.bAceptar.addActionListener(al);
	}	
	
	public void actualizarInmuebles(Ofertante o) {
		for(Inmueble i: o.getInmuebles()) {
			modelo.addElement(i);
		}
	}

}
