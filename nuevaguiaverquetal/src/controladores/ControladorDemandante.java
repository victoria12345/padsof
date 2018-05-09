package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import es.uam.eps.padsof.telecard.FailedInternetConnectionException;
import es.uam.eps.padsof.telecard.InvalidCardNumberException;
import es.uam.eps.padsof.telecard.OrderRejectedException;
import excepciones.ArgumentoNoValido;
import gui.CustomFrame;
import paneles.DemandantePanel;
import usuarios.Demandante;

/**
 * Descripcion de la clase ControladorDemandante
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class ControladorDemandante implements ActionListener{
	private CustomFrame ventana;

	
	/**
	 * Constructor del controlador
	 * @param ventana ventana personalizada que contiene a los paneles
	 */
	public ControladorDemandante(CustomFrame ventana) {
		this.ventana = ventana;
	}

	/**
	 * Gestiona las diferentes acciones que se pueden hacer en el panel de
	 * demandante
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		DemandantePanel panel = ventana.getPanelDemandante();
		Demandante deman = panel.getDeman();
		if(event.equals(panel.getAtras())) {
			ventana.mostrarPanelOfertas();
			
		}else if(event.equals(panel.getCancelarRes())) {
			if(deman.getResidencial() == null) {
				return;
			}
			try {
				deman.getResidencial().cancelar(deman, true);
			} catch (ArgumentoNoValido e1) {
				JOptionPane.showMessageDialog(null, "Se ha producido un error");
			}
			
			panel.getrResidencial().setText("Reserva residencial:");
		}else if(event.equals(panel.getCancelarVac())) {
			if(deman.getVacacional() == null) {
				return;
			}
			try {
				deman.getVacacional().cancelar(deman, true);
			} catch (ArgumentoNoValido e1) {
				JOptionPane.showMessageDialog(null, "Se ha producido un error");
			}
			
			panel.getrVacacional().setText("Reserva vacacional:");
			
		}else if(event.equals(panel.getPagarRes())) {
			if(deman.getResidencial() == null) {
				return;
			}
			
			if(deman.isBloqueado()) {
				JOptionPane.showMessageDialog(null, "No puedes contratar ofertas estando bloqueado");
				return;
			}
			try {
				deman.getResidencial().pagar(deman, "Pago");
				JOptionPane.showMessageDialog(null, "La oferta ha sido contratada");
			} catch (InvalidCardNumberException e1) {
				JOptionPane.showMessageDialog(null, "Número de tarjeta no valido");
				deman.setBloqueado(true);
			} catch (FailedInternetConnectionException e1) {
				JOptionPane.showMessageDialog(null, "La conexión a internet ha fallado");
			} catch (OrderRejectedException e1) {
				JOptionPane.showMessageDialog(null, "La operación ha sido rechazada");
			} catch (ArgumentoNoValido e1) {
				JOptionPane.showMessageDialog(null, "Oh! parece que ha habido un error :)");
			}
			panel.getrResidencial().setText("Reserva residencial:");
		}else if(event.equals(panel.getPagarVac())) {
			if(deman.getVacacional() == null) {
				return;
			}
			
			if(deman.isBloqueado()) {
				JOptionPane.showMessageDialog(null, "No puedes contratar ofertas estando bloqueado");
				return;
			}
			try {
				deman.getVacacional().pagar(deman, "Pago");
				JOptionPane.showMessageDialog(null, "La oferta ha sido contratada");
			} catch (InvalidCardNumberException e1) {
				JOptionPane.showMessageDialog(null, "Número de tarjeta no valido");
				deman.setBloqueado(true);
			} catch (FailedInternetConnectionException e1) {
				JOptionPane.showMessageDialog(null, "La conexión a internet ha fallado");
			} catch (OrderRejectedException e1) {
				JOptionPane.showMessageDialog(null, "La operación ha sido rechazada");
			} catch (ArgumentoNoValido e1) {
				JOptionPane.showMessageDialog(null, "Oh! parece que ha habido un error :)");
			}
			
			panel.getrVacacional().setText("Reserva vacacional:");
			
		}
		
		
	}

}
