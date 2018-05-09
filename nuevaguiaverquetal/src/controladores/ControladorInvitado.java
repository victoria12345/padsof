package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JOptionPane;


import app.Sistema;
import gui.CustomFrame;

import ofertas.Oferta;
import paneles.InvitadoPanel;


/**
 * Descripcion de la clase ControladorInvitado
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class ControladorInvitado implements ActionListener{
	private CustomFrame ventana;
	private Sistema app;
	
	/**
	 * Constructor del controlador
	 * @param ventana ventana personalizada que contiene a los paneles
	 * @param app sistema con los datos y funciones pertinentes
	 */
	public ControladorInvitado(CustomFrame ventana, Sistema app) {
		this.ventana = ventana; 
		this.app = app;
	}


	/**
	 * Gestiona las diferentes acciones que se pueden hacer en el panel de
	 * inivitado
	 */
	@SuppressWarnings({"unchecked" })
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		InvitadoPanel panel = ventana.getPanelInvitado();
		List<Oferta> ofers = new ArrayList<Oferta>();
		
		
		if(event.equals(panel.getSalir())) {
			ventana.mostrarPanelLogin();
			
		}else if(event.equals(panel.getBotonFiltrar())) {
			for(int i = 0; i < panel.getModelo().getSize(); i++) {
				ofers.add((Oferta)panel.getModelo().getElementAt(i));
			}
			
			if(panel.getCampoCP().getText().isEmpty() == false) {
				ofers = app.filtrar_codigo(ofers, Integer.parseInt(panel.getCampoCP().getText()));
			}
			
			if(panel.getCampoPrecio().getText().isEmpty() == false) {
				ofers = app.filtrar_precio(ofers, Integer.parseInt(panel.getCampoPrecio().getText()));
			}
			
			if(panel.getCampoIni().getText().isEmpty() == false && panel.getCampoFin().getText().isEmpty() == false) {
				String trozosIni[] = panel.getCampoIni().getText().split("-");
				String trozosFin[] = panel.getCampoFin().getText().split("-");
				if(trozosIni.length < 3 || trozosFin.length < 3) {
					JOptionPane.showMessageDialog(null, "Las fechas tienen que estar en el formato indiciado");
					return;
				}
				LocalDate ini = LocalDate.of(Integer.parseInt(trozosIni[2]), Integer.parseInt(trozosIni[1]), Integer.parseInt(trozosIni[0]));
				LocalDate fin = LocalDate.of(Integer.parseInt(trozosFin[2]), Integer.parseInt(trozosFin[1]), Integer.parseInt(trozosFin[0]));
				ofers = app.filtrar_fecha(ofers, ini, fin);
			}
			
			panel.getModelo().clear();
			
			for(Oferta o: ofers) {
				panel.getModelo().addElement(o);
			}
		}else if(event.equals(panel.getBotonMostrarTodas())) {
			panel.getModelo().clear();
			for(Oferta o: app.getOfertas()) {
				panel.getModelo().addElement(o);
			}
		}	
	}

}
