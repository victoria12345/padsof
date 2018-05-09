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
import ofertas.OfertaVacacional;

import paneles.OfertaVacacionalPanel;


/**
 * Descripcion de la clase ControladorVacacional
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class ControladorVacacional implements ActionListener {
	private CustomFrame ventana;
	private Sistema app;
	
	/**
	 * Constructor del controlador
	 * @param ventana ventana personalizada que contiene a los paneles
	 * @param app sistema con los datos y funciones pertinentes
	 */
	public ControladorVacacional(CustomFrame gui, Sistema app) {
		this.ventana = gui; 
		this.app = app;
	}
	
	/**
	 * Gestiona las diferentes acciones que se pueden hacer en el panel de
	 * subir oferta vacacional
	 */
	@SuppressWarnings("unchecked")
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
		}else if(event.equals(pLogin.getbAsociar())) {
			Inmueble i = ventana.getPanelOfertaVac().getInmueble();
			
			if(pLogin.getCampoPrecio().getText().equals("") || pLogin.getCampoIni().getText().equals("")) {
				JOptionPane.showMessageDialog(pLogin, "Completar todos los datos.");
			}else if(pLogin.getCampoFin().getText().equals("") || pLogin.getCampoFianza().getText().equals("")) {
				JOptionPane.showMessageDialog(pLogin, "Completar todos los datos.");
			}
			
			Double precio = Double.parseDouble(pLogin.getCampoPrecio().getText());
			String inicio = pLogin.getCampoIni().getText(), fin = pLogin.getCampoFin().getText();
			String trozos1[] = inicio.split("-"), trozos2[] = fin.split("-");
			LocalDate ini, fin2;
			ini = LocalDate.of(Integer.parseInt(trozos1[2]),Integer.parseInt(trozos1[1]),Integer.parseInt(trozos1[0]));
			fin2 = LocalDate.of(Integer.parseInt(trozos2[2]),Integer.parseInt(trozos2[1]),Integer.parseInt(trozos2[0]));
			
			Oferta o = new OfertaVacacional(precio, ini, fin2,Double.parseDouble(pLogin.getCampoFianza().getText()));
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
			pLogin.getCampoFin().setText("");
			pLogin.getCampoFianza().setText("");
			ventana.mostrarPanelInmuebles();
		}
		
	}
	
}
