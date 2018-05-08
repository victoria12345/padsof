package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app.Sistema;
import gui.CustomFrame;
import ofertas.Disponibilidad;
import ofertas.Oferta;
import paneles.OferPanel;
import usuarios.Usuario;

public class ControladorOfertas implements ActionListener, ListSelectionListener{
	private CustomFrame ventana;
	private Sistema app;
	
	public ControladorOfertas(CustomFrame ventana, Sistema app) {
		this.ventana = ventana;
		this.app = app;	
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		OferPanel panel = ventana.getPanelOfertas();
		Object event = arg0.getSource();
		JList list = panel.getOfers();
		Usuario u = app.getUsuarioActual();
		List<Oferta> ofers = new ArrayList<Oferta>();
		
		if(event.equals(panel.getBotonDemandante())) {
			if(u == app.getAdmin()) {
				return;
			}
			ventana.getPanelDemandante().iniciar(app);
			ventana.mostrarPanelDemandante();
			
		}else if(event.equals(panel.getBotonVer())) {
			if(list.isSelectionEmpty() == false) {
				int index =  list.getSelectedIndex();
				Oferta o;
				if((o = (Oferta)list.getModel().getElementAt(index)) == null) {
					return;
				}
				ventana.getPanelVerOferta().iniciar(o);
				ventana.mostrarPanelVerOferta();
			}
			
		}else if(event.equals(panel.getBotonVolver())) {
			ventana.mostrarPanelRol();
			
		}else if(event.equals(panel.getBotonFiltrar())) {
			String disp = (String)panel.getComboDisp().getSelectedItem();
			
			for(int i = 0; i < panel.getModelo().getSize(); i++) {
				ofers.add((Oferta)panel.getModelo().getElementAt(i));
			}
			
			if(panel.getCampoCP().getText().isEmpty() == false) {
				ofers = app.filtrar_codigo(ofers, Integer.parseInt(panel.getCampoCP().getText()));
			}
			
			if(panel.getCampoPrecio().getText().isEmpty() == false) {
				ofers = app.filtrar_precio(ofers, Integer.parseInt(panel.getCampoPrecio().getText()));
			}
			
			if(panel.getCampoValoracion().getText().isEmpty() == false) {
				ofers = app.filtrar_valoracion(ofers, Integer.parseInt(panel.getCampoValoracion().getText()));
			}
			
			if(disp == "Disponible") {
				ofers = app.filtrar_disp(ofers, Disponibilidad.DISPONIBLE);
			}else if(disp == "Reservada") {
				ofers = app.filtrar_disp(ofers, Disponibilidad.RESERVADA);
			}else if(disp == "Contratada") {
				ofers = app.filtrar_disp(ofers, Disponibilidad.CONTRATADA);
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
			
			
		}else if(event.equals(panel.getBotonOrdenar())) {
			
			for(int i = 0; i < panel.getModelo().getSize(); i++) {
				ofers.add((Oferta)panel.getModelo().getElementAt(i));
			}
			if(panel.getComboOrdenes().getSelectedItem() == "Más caras primero") {
				app.ordenar_precio(ofers, 1);
			}else if(panel.getComboOrdenes().getSelectedItem() == "Más baratas primero") {
				app.ordenar_precio(ofers, 0);
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
