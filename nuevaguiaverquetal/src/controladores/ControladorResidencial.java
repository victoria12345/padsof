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
import ofertas.OfertaResidencial;
import ofertas.OfertaVacacional;
import paneles.LoginPanel;
import paneles.OfertaResidencialPanel;
import paneles.OfertaVacacionalPanel;
import usuarios.Rol;
import usuarios.Usuario;

public class ControladorResidencial implements ActionListener{

		private Sistema app;
		private CustomFrame ventana;
	
	public ControladorResidencial(CustomFrame gui, Sistema app) {
		this.ventana = gui; 
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		OfertaResidencialPanel pLogin = ventana.getPanelResidencial();
		
		if(event.equals(pLogin.getbCancelar())){
			pLogin.getCampoPrecio().setText("");
			pLogin.getCampoIni().setText("");
			pLogin.getCamponMeses().setText("");
			
			ventana.mostrarPanelInmuebles();
		}else if(event.equals(pLogin.getbCancelar())) {
			Usuario u = app.getUsuarioActual();
			Double precio = Double.parseDouble(pLogin.getCampoPrecio().getText());
			String inicio = pLogin.getCampoIni().getText();
			String trozos1[] = inicio.split("-");
			LocalDate ini;
			ini = LocalDate.of(Integer.parseInt(trozos1[2]),Integer.parseInt(trozos1[1]),Integer.parseInt(trozos1[0]));
			
			Oferta o = new OfertaResidencial(precio, ini, Integer.parseInt(pLogin.getCamponMeses().getText()));
			/*Annadir oferta al inmueble*/
			
			pLogin.getCampoPrecio().setText("");
			pLogin.getCampoIni().setText("");
			pLogin.getCamponMeses().setText("");
			ventana.mostrarPanelInmuebles();
		}
		
	}

}
