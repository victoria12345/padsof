package paneles;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ofertas.Oferta;

public class OferPendientePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JLabel oPrecio = new JLabel();
	private JLabel oIni = new JLabel();
	private JLabel oDesc = new JLabel();
	
	private JButton botAceptar = new JButton("Aceptar");
	private JButton botRect = new JButton("Enviar rectificación");
	private JButton botVolver = new JButton("Volver");
	
	private Oferta oferta;
	
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
	
	public void iniciar(Oferta o) {
		this.oferta = o;
		
		if(o != null) {
			oPrecio.setText("Precio:" + o.getPrecio());
			oIni.setText("Fecha de inicio:" + o.getIni());
			oDesc.setText("Descripcion:" + o.getDesc());
		}
	}
	
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
	 * @param oPrecio the oPrecio to set
	 */
	public void setoPrecio(JLabel oPrecio) {
		this.oPrecio = oPrecio;
	}

	/**
	 * @return the oIni
	 */
	public JLabel getoIni() {
		return oIni;
	}

	/**
	 * @param oIni the oIni to set
	 */
	public void setoIni(JLabel oIni) {
		this.oIni = oIni;
	}

	/**
	 * @return the oDesc
	 */
	public JLabel getoDesc() {
		return oDesc;
	}

	/**
	 * @param oDesc the oDesc to set
	 */
	public void setoDesc(JLabel oDesc) {
		this.oDesc = oDesc;
	}

	/**
	 * @return the botAceptar
	 */
	public JButton getBotAceptar() {
		return botAceptar;
	}

	/**
	 * @param botAceptar the botAceptar to set
	 */
	public void setBotAceptar(JButton botAceptar) {
		this.botAceptar = botAceptar;
	}

	/**
	 * @return the botRect
	 */
	public JButton getBotRect() {
		return botRect;
	}

	/**
	 * @param botRect the botRect to set
	 */
	public void setBotRect(JButton botRect) {
		this.botRect = botRect;
	}

	/**
	 * @return the botVolver
	 */
	public JButton getBotVolver() {
		return botVolver;
	}

	/**
	 * @param botVolver the botVolver to set
	 */
	public void setBotVolver(JButton botVolver) {
		this.botVolver = botVolver;
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


