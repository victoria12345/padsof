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
import inmuebles.Inmueble;
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
		OfertaResidencialPanel pLogin = ventana.getPanelOfertaRes();
		
		if(event.equals(pLogin.getbCancelar())){
			pLogin.getCampoPrecio().setText("");
			pLogin.getCampoIni().setText("");
			pLogin.getCamponMeses().setText("");
			
			ventana.mostrarPanelInmuebles();
		}else if(event.equals(pLogin.getbAsociar())) {
			Inmueble i = pLogin.getInmueble();
			
			if(pLogin.getCampoPrecio().getText().equals("") || pLogin.getCampoIni().getText().equals("")) {
				JOptionPane.showMessageDialog(pLogin, "Completar todos los datos.");
			}else if(pLogin.getCamponMeses().getText().equals("") ) {
				JOptionPane.showMessageDialog(pLogin, "Completar todos los datos.");
			}
			
			Double precio = Double.parseDouble(pLogin.getCampoPrecio().getText());
			String inicio = pLogin.getCampoIni().getText();
			String trozos1[] = inicio.split("-");
			LocalDate ini;
			ini = LocalDate.of(Integer.parseInt(trozos1[2]),Integer.parseInt(trozos1[1]),Integer.parseInt(trozos1[0]));
			
			Oferta o = new OfertaResidencial(precio, ini, Integer.parseInt(pLogin.getCamponMeses().getText()));
			/*Annadir oferta al inmueble*/
			try {
				i.asociarOferta(o);
			} catch (ArgumentoNoValido e) {
				JOptionPane.showMessageDialog(pLogin, "Oferta no valida.");
			}
			
			pLogin.getCampoPrecio().setText("");
			pLogin.getCampoIni().setText("");
			pLogin.getCamponMeses().setText("");
			ventana.mostrarPanelInmuebles();
		}
		
	}

}
