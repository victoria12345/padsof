package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import app.Sistema;
import excepciones.ArgumentoNoValido;
import excepciones.HayOtroUsuarioLogeado;
import excepciones.UsuarioNoEncontrado;
import gui.CustomFrame;
import paneles.ElegirRolPanel;
import paneles.LoginPanel;
import usuarios.Ofertante;
import usuarios.Usuario;

/**
 * Descripcion de la clase ControladorRol
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class ControladorRol implements ActionListener {
	private CustomFrame ventana;
	private Sistema app;
	
	/**
	 * Constructor del controlador
	 * @param ventana ventana personalizada que contiene a los paneles
	 * @param app sistema con los datos y funciones pertinentes
	 */
	public ControladorRol(CustomFrame gui, Sistema app) {
		this.ventana = gui; 
		this.app = app;
	}
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		ElegirRolPanel pRol = ventana.getPanelRol();
		Usuario u = app.getUsuarioActual();
		
		if(event.equals(pRol.getbOfertante())){
			if(u == app.getAdmin()) {
				ventana.mostrarPanelInmuebles();
			}
			for(int i = 0; i< u.getRoles().size(); i++) {
				if(u.getRoles().get(i).isOfertante() == true) {
					ventana.getPanelInmuebles().actualizarInmuebles((Ofertante) u.getRoles().get(i));
					ventana.mostrarPanelInmuebles();
				}
			}
		}else if(event.equals(pRol.getbSalir())) {
			app.logout();
			try {
				app.serializar();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error al hacer logout");
			}
			ventana.mostrarPanelLogin();
		}else if(event.equals(pRol.getbDemandante())) {
			if(u == app.getAdmin()) {
				ventana.mostrarPanelOfertas();
			}
			for(int i = 0; i< u.getRoles().size(); i++) {
				if(u.getRoles().get(i).isDemandante() == true) {
					ventana.mostrarPanelOfertas();
				}
			}
		}else if(event.equals(pRol.getbAdministrador())) {
			for(int i = 0; i< u.getRoles().size(); i++) {
				if(u.getRoles().get(i).isAdmin() == true) {
					ventana.mostrarPanelAdmin();
				}
			}
		}else if(event.equals(pRol.getbCont())) {
			try {
				app.getUsuarioActual().setContrasenia(pRol.getCampoCont().getText());
				pRol.getCampoCont().setText("");
			} catch (ArgumentoNoValido e) {
				e.printStackTrace();
			}
		}
		
	}

	public CustomFrame getVentana() {
		return ventana;
	}

	public void setVentana(CustomFrame ventana) {
		this.ventana = ventana;
	}

	public Sistema getApp() {
		return app;
	}

	public void setApp(Sistema app) {
		this.app = app;
	}

}
