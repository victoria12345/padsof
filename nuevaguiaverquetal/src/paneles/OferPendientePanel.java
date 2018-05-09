package paneles;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ofertas.Oferta;
/**
 * Descripcion de la clase OferPendientePanel
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class OferPendientePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JLabel oPrecio = new JLabel();
	private JLabel oIni = new JLabel();
	private JLabel oDesc = new JLabel();
	
	private JButton botAceptar = new JButton("Aceptar");
	private JButton botRect = new JButton("Enviar rectificación");
	private JButton botVolver = new JButton("Volver");
	
	private Oferta oferta;
	/**
	 * Constructor del panel de oferta pendiente
	 */
	public OferPendientePanel() {
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		
		JPanel botonera = new JPanel();
		botonera.setLayout(new FlowLayout());
		botonera.add(botAceptar);
		botonera.add(botRect);
		
		this.add(oPrecio);
		this.add(oIni);
		this.add(oDesc);
		this.add(botonera);
		this.add(botVolver);
	}
	/**
	 * Inicia el panel con la oferta cuyos datos se mostraran
	 * @param o oferta con la que se va a iniciar el panel
	 */
	public void iniciar(Oferta o) {
		this.oferta = o;
		
		if(o != null) {
			oPrecio.setText("Precio:" + o.getPrecio());
			oIni.setText("Fecha de inicio:" + o.getIni());
			oDesc.setText("Descripcion:" + o.getDesc());
		}
	}
	
	/**
	 * Establece un controlador para el panel
	 * @param a1 controlador del panel
	 */
	public void setControlador(ActionListener a1) {
		botAceptar.addActionListener(a1);
		botRect.addActionListener(a1);
		botVolver.addActionListener(a1);
	}

	/**
	 * @return the oPrecio
	 */
	public JLabel getoPrecio() {
		return oPrecio;
	}

	/**
	 * @return the oIni
	 */
	public JLabel getoIni() {
		return oIni;
	}


	/**
	 * @return the oDesc
	 */
	public JLabel getoDesc() {
		return oDesc;
	}


	/**
	 * @return the botAceptar
	 */
	public JButton getBotAceptar() {
		return botAceptar;
	}

	/**
	 * @return the botRect
	 */
	public JButton getBotRect() {
		return botRect;
	}

	/**
	 * @return the botVolver
	 */
	public JButton getBotVolver() {
		return botVolver;
	}

	/**
	 * @return the oferta
	 */
	public Oferta getOferta() {
		return oferta;
	}

	/**
	 * @param oferta the oferta to set
	 */
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
}


