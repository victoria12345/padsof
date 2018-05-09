package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import app.Sistema;
import inmuebles.Inmueble;
/**
 * Descripcion de la clase EleccionOfertaPanel
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class EleccionOfertaPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	Inmueble i;
	Sistema app;
	
	private JButton bVacacional = new JButton("Oferta Vacacional");
	private JButton bResidencial = new JButton("Oferta Residencial");
	private JButton bAtras = new JButton("Cancelar");
	/**
	 * Constructor del panel de eleccion de oferta
	 * @param sist sistema con los datos y funciones pertinentes
	 */
	public EleccionOfertaPanel(Sistema sist) {
		this.app = sist;
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();
		this.setLayout(layout);
		
		cons.fill = GridBagConstraints.NONE;
		cons.anchor = GridBagConstraints.WEST;
		
		cons.gridx = 1;
		
		cons.gridy = 0;
		layout.setConstraints(bVacacional, cons);
		
		cons.gridy = 2;	
		layout.setConstraints(bResidencial, cons);
		
		cons.gridy = 3;	
		layout.setConstraints(bAtras, cons);
		
		this.add(bVacacional);
		this.add(bResidencial);
		this.add(bAtras);
	}

	public Inmueble getInmueble() {
		return this.i;
	}

	/**
	 * @param app the app to set
	 */
	public void setApp(Sistema app) {
		this.app = app;
	}

	public JButton getbAtras() {
		return bAtras;
	}


	public JButton getbVacacional() {
		return bVacacional;
	}


	public JButton getbResidencial() {
		return bResidencial;
	}

	/**
	 * Establece un controlador para el panel
	 * @param a1 controlador del panel
	 */
	public void setControlador(ActionListener al) {
		this.bResidencial.addActionListener(al);
		this.bVacacional.addActionListener(al);
		this.bAtras.addActionListener(al);
	}
	
	/**
	 * establece el inmueble al que se va a asociar la oferta
	 * @param i inmueble al que se va a asociar la oferta
	 */
	public void iniciar(Inmueble i) {
		this.i= i;
	}
	
}
