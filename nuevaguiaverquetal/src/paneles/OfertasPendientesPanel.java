package paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import app.Sistema;
import inmuebles.Inmueble;
import ofertas.Estado;
import ofertas.Oferta;
import usuarios.Ofertante;
import usuarios.Rol;
import usuarios.Usuario;

/**
 * Descripcion de la clase OfertasPendientesPanel
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class OfertasPendientesPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JList ofertas = new JList();
	private DefaultListModel modelo = new DefaultListModel();
	private JScrollPane listaOfertas;
	private JButton bAtras = new JButton("Atrás");
	private JButton bRectificar = new JButton("Rectificar");
	
	private Sistema sist;
	/**
	 * Constructor del panel de ofertas pendientes
	 * @param sist sistema con los datos y funciones pertinentes
	 */
	public OfertasPendientesPanel(Sistema app) {
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
		botones2.add(bRectificar);
		
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
	 * añade las ofertas pendientes de rectificacion al modelo
	 */
	public void iniciar() {
		Usuario u = sist.getUsuarioActual();
		for(Rol r: u.getRoles()) {
			if(r.isOfertante() == true) {
				for(Inmueble i1: ((Ofertante) r).getInmuebles()) {
					for(Oferta o: i1.getOfertas()) {
						if(o.getEstado() == Estado.PENDIENTE) {
							modelo.addElement(o);
						}
					}
				}
			}
			
		}
	}
	
	/**
	 * Establece un controlador para el panel
	 * @param a1 controlador del panel
	 */
	public void setControlador(ActionListener al) {
		this.bAtras.addActionListener(al);
		this.bRectificar.addActionListener(al);
	}

	/**
	 * @return the bRectificar
	 */
	public JButton getbRectificar() {
		return bRectificar;
	}

	/**
	 * @param bRectificar the bRectificar to set
	 */
	public void setbRectificar(JButton bRectificar) {
		this.bRectificar = bRectificar;
	}
}
