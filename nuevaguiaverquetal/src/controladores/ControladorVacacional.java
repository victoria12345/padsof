package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import app.Sistema;
import excepciones.ArgumentoNoValido;
import excepciones.HayOtroUsuarioLogeado;
import excepciones.UsuarioNoEncontrado;
import gui.CustomFrame;
import ofertas.Oferta;
import ofertas.OfertaVacacional;
import paneles.LoginPanel;
import paneles.OfertaVacacionalPanel;
import usuarios.Rol;
import usuarios.Usuario;

public class ControladorVacacional implements ActionListener {
	private CustomFrame ventana;
	private Sistema app;
	
	public ControladorVacacional(CustomFrame gui, Sistema app) {
		this.ventana = gui; 
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		OfertaVacacionalPanel pLogin = ventana.getPanelOfertaVac();
		
		if(event.equals(pLogin.getbCancelar())){
			pLogin.getCampoPrecio().setText("");
			pLogin.getCampoIni().setText("");
			pLogin.getCampoFin().setText("");
			pLogin.getCampoFianza().setText("");
			
			ventana.mostrarPanelInmuebles();
		}else if(event.equals(pLogin.getbCancelar())) {
			Usuario u = app.getUsuarioActual();
			Double precio = Double.parseDouble(pLogin.getCampoPrecio().getText());
			String inicio = pLogin.getCampoIni().getText(), fin = pLogin.getCampoFin().getText();
			String trozos1[] = inicio.split("-"), trozos2[] = fin.split("-");
			LocalDate ini, fin2;
			ini = LocalDate.of(Integer.parseInt(trozos1[2]),Integer.parseInt(trozos1[1]),Integer.parseInt(trozos1[0]));
			fin2 = LocalDate.of(Integer.parseInt(trozos2[2]),Integer.parseInt(trozos2[1]),Integer.parseInt(trozos2[0]));
			
			Oferta o = new OfertaVacacional(precio, ini, fin2,Integer.parseInt(pLogin.getCampoFianza().getText()));
			/*Annadir oferta al inmueble*/
			
			pLogin.getCampoPrecio().setText("");
			pLogin.getCampoIni().setText("");
			pLogin.getCampoFin().setText("");
			pLogin.getCampoFianza().setText("");
			ventana.mostrarPanelInmuebles();
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
