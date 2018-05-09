package paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.Sistema;
import usuarios.Demandante;
import usuarios.Rol;
import usuarios.Usuario;
/**
 * Descripcion de la clase DemandantePanel
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class DemandantePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Sistema app;

	private JLabel rResidencial = new JLabel("Reserva residencial:");
	private JLabel rVacacional = new JLabel("Reserva vacacional:");
	private JButton atras = new JButton("Atrás");
	
	private JButton cancelarRes = new JButton("Cancelar reserva residencial");
	private JButton cancelarVac = new JButton("Cancelar reserva vacacional");
	
	private JButton pagarRes = new JButton("Pagar reserva residencial");
	private JButton pagarVac = new JButton("Pagar reserva vacacional");
	
	
	private Demandante deman;
	
	/**
	 * Constructor del panel de demandante
	 */
	public DemandantePanel() {
		this.setLayout(new BorderLayout());
		
		JPanel botonera = new JPanel(new FlowLayout());
		botonera.add(cancelarRes);
		botonera.add(cancelarVac);
		
		JPanel botonera2 = new JPanel(new FlowLayout());
		botonera2.add(pagarRes);
		botonera2.add(pagarVac);
		
		
		JPanel principal = new JPanel();
		BoxLayout layout = new BoxLayout(principal, BoxLayout.Y_AXIS);
		principal.setLayout(layout);
		principal.add(rResidencial);
		principal.add(rVacacional);
		principal.add(botonera);
		principal.add(botonera2);
		principal.add(atras);
		
		this.add(principal, BorderLayout.CENTER);
	}
	
	
	public void iniciar(Sistema app) {
		this.app = app;
		Usuario u = app.getUsuarioActual();
		for(Rol r: u.getRoles()) {
			if(r.isDemandante()) {
				deman = (Demandante)r;
			}
		}
		
		if(deman.getResidencial() != null) {
			rResidencial.setText("Reserva residencial:" + deman.getResidencial().toString());
		}
		
		if(deman.getVacacional() != null) {
			rVacacional.setText("Reserva vacacional:" + deman.getVacacional().toString());
		}
		
	}

	
	/**
	 * Establece un controlador para el panel
	 * @param a1 controlador del panel
	 */
	public void setControlador(ActionListener a1) {
		atras.addActionListener(a1);
		cancelarRes.addActionListener(a1);
		cancelarVac.addActionListener(a1);
		pagarRes.addActionListener(a1);
		pagarVac.addActionListener(a1);
	}


	/**
	 * @return the atras
	 */
	public JButton getAtras() {
		return atras;
	}


	/**
	 * @return the rResidencial
	 */
	public JLabel getrResidencial() {
		return rResidencial;
	}
	
	/**
	 * @return the rVacacional
	 */
	public JLabel getrVacacional() {
		return rVacacional;
	}

	/**
	 * @return the cancelarRes
	 */
	public JButton getCancelarRes() {
		return cancelarRes;
	}

	/**
	 * @return the cancelarVac
	 */
	public JButton getCancelarVac() {
		return cancelarVac;
	}

	/**
	 * @return the deman
	 */
	public Demandante getDeman() {
		return deman;
	}


	/**
	 * @param deman the deman to set
	 */
	public void setDeman(Demandante deman) {
		this.deman = deman;
	}


	/**
	 * @return the pagarRes
	 */
	public JButton getPagarRes() {
		return pagarRes;
	}

	/**
	 * @return the pagarVac
	 */
	public JButton getPagarVac() {
		return pagarVac;
	}

}

