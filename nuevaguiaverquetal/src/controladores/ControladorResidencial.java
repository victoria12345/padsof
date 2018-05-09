package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import app.Sistema;
import excepciones.ArgumentoNoValido;

import gui.CustomFrame;
import inmuebles.Inmueble;
import ofertas.Oferta;
import ofertas.OfertaResidencial;

import paneles.OfertaResidencialPanel;


/**
 * Descripcion de la clase ControladorResidencial
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class ControladorResidencial implements ActionListener{

	private Sistema app;
	private CustomFrame ventana;
	
	/**
	 * Constructor del controlador
	 * @param ventana ventana personalizada que contiene a los paneles
	 * @param app sistema con los datos y funciones pertinentes
	 */
	public ControladorResidencial(CustomFrame gui, Sistema app) {
		this.ventana = gui; 
		this.app = app;
	}
	
	/**
	 * Gestiona las diferentes acciones que se pueden hacer en el panel de
	 * asociar oferta residencial
	 */
	@SuppressWarnings("unchecked")
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
				app.addPendiente(o);
				ventana.getPanelPendientes().getModelo().addElement(o);
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
