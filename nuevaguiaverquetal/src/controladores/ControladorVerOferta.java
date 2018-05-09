package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.Sistema;
import es.uam.eps.padsof.telecard.FailedInternetConnectionException;
import es.uam.eps.padsof.telecard.InvalidCardNumberException;
import es.uam.eps.padsof.telecard.OrderRejectedException;
import excepciones.ArgumentoNoValido;
import excepciones.DemasiadasOfertasReservadas;
import excepciones.OfertaNoDisponible;
import excepciones.UsuarioBloqueado;
import gui.CustomFrame;
import ofertas.Comentario;
import ofertas.Oferta;
import paneles.OferPanel;
import paneles.VerOfertaPanel;
import usuarios.Demandante;
import usuarios.Rol;
import usuarios.Usuario;

/**
 * Descripcion de la clase ControladorVerOferta
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class ControladorVerOferta implements ActionListener{
	private CustomFrame ventana;
	private Sistema app;
	
	/**
	 * Constructor del controlador
	 * @param ventana ventana personalizada que contiene a los paneles
	 * @param app sistema con los datos y funciones pertinentes
	 */
	public ControladorVerOferta(CustomFrame ventana, Sistema app) {
		this.ventana = ventana; 
		this.app = app;	
	}

	/**
	 * Gestiona las diferentes acciones que se pueden hacer en el panel de
	 * ver oferta
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		VerOfertaPanel panel = ventana.getPanelVerOferta();
		Oferta o = panel.getOferta();
		Demandante deman = null;
		Usuario u = app.getUsuarioActual();
		
		if(event.equals(panel.getBotonContratar())) {
			if(u == app.getAdmin()) {
				return;
			}
			for(Rol r: app.getUsuarioActual().getRoles()) {
				if(r.isDemandante()) {
					deman = (Demandante)r;
				}
			}
			if(deman.isBloqueado()) {
				JOptionPane.showMessageDialog(null, "No puedes contratar ofertas estando bloqueado");
				return;
			}
			try {
				o.pagar(deman, "Pago");
				JOptionPane.showMessageDialog(null, "La oferta ha sido contratada");
			} catch (InvalidCardNumberException e) {
				JOptionPane.showMessageDialog(null, "Número de tarjeta no valido");
				deman.setBloqueado(true);
			} catch (FailedInternetConnectionException e) {
				JOptionPane.showMessageDialog(null, "La conexión a internet ha fallado");
			} catch (OrderRejectedException e) {
				JOptionPane.showMessageDialog(null, "La operación ha sido rechazada");
			} catch (ArgumentoNoValido e) {
				JOptionPane.showMessageDialog(null, "Oh! parece que ha habido un error :)");
			}
		}else if(event.equals(panel.getBotonReservar())) {
			if(u == app.getAdmin()) {
				return;
			}
			for(Rol r: app.getUsuarioActual().getRoles()) {
				if(r.isDemandante()) {
					deman = (Demandante)r;
				}
			}
			try {
				o.reservar(deman, ventana.getFecha());
				JOptionPane.showMessageDialog(null, "La oferta ha sido reservada");
			} catch (UsuarioBloqueado e) {
				JOptionPane.showMessageDialog(null, "No puedes reservar ofertas estando bloqueado");
			} catch (OfertaNoDisponible e) {
				JOptionPane.showMessageDialog(null, "Esta oferta no esta disponible para reserva");
			} catch (DemasiadasOfertasReservadas e) {
				JOptionPane.showMessageDialog(null, "Tienes demasiadas ofertas reservadas");
			}
		}else if(event.equals(panel.getBotonComentar())) {
			Comentario c;
			String text;
			text = JOptionPane.showInputDialog("Introduzca el comentarios que desee realizar");
			c = new Comentario(app.getUsuarioActual(), text);
			try {
				o.addComentario(c);
			} catch (ArgumentoNoValido e) {
				JOptionPane.showMessageDialog(null, "El comentario que has introducido no es valido");
			}
		}else if(event.equals(panel.getBotonValorar())) {
			if(u == app.getAdmin()) {
				return;
			}
			int val;
			val = Integer.parseInt(JOptionPane.showInputDialog("Introduzca una valoracion entre 1 y 10"));
			try {
				o.valorar(val);
			} catch (ArgumentoNoValido e) {
				JOptionPane.showMessageDialog(null, "Error,puntuación inválida");
			}
			
		}else if(event.equals(panel.getBotonVolver())) {
			OferPanel ofer = ventana.getPanelOfertas();
			ofer.getOfers().clearSelection();
			ventana.mostrarPanelOfertas();
		}else if(event.equals(panel.getBotonComentarios())) {
			ventana.getPanelComentario().modificarModelo(o.getComentarios());
			ventana.mostrarPanelComentario();
		}
	}

}
