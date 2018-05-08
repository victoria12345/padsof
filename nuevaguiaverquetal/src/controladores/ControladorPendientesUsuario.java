package controladores;

import app.Sistema;
import excepciones.ArgumentoNoValido;
import gui.*;
import ofertas.Oferta;
import paneles.AdminPanel;
import paneles.OfertasPendientesPanel;
import usuarios.Demandante;
import usuarios.Ofertante;
import usuarios.Rol;
import usuarios.Usuario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JLabel;


public class ControladorPendientesUsuario implements ActionListener{

	private CustomFrame ventana;
	private Sistema app;
		
	public ControladorPendientesUsuario(Sistema app, CustomFrame ventana) {
		this.ventana = ventana; 
		this.app = app;
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		Object event = arg0.getSource();
		OfertasPendientesPanel panel = ventana.getPanelPendientesUser();
		JList lista = panel.getOfertas();

		if(event.equals(panel.getbAtras())){
			ventana.mostrarPanelInmuebles();
		
		}else if(event.equals(panel.getbRectificar())) {
			if(lista.isSelectionEmpty() == false) {
				int index = lista.getSelectedIndex();
				Oferta o = (Oferta)lista.getModel().getElementAt(index);
				ventana.getPanelRectificar().iniciar(o);
				ventana.mostrarPanelRectificar();
			}
		}
		
	}

}
