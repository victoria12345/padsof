package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import app.Sistema;
import excepciones.ArgumentoNoValido;
import gui.CustomFrame;
import ofertas.*;
import paneles.RectificarPanel;

/**
 * Descripcion de la clase ControladorRectificar
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class ControladorRectificar implements ActionListener{
	private Sistema app;
	private CustomFrame ventana;
	
	/**
	 * Constructor del controlador
	 * @param ventana ventana personalizada que contiene a los paneles
	 * @param app sistema con los datos y funciones pertinentes
	 */
	public ControladorRectificar(CustomFrame ventana, Sistema app) {
		this.ventana = ventana;
		this.app = app;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		RectificarPanel panel = ventana.getPanelRectificar();
		String trozos[];
		
		if(event.equals(panel.getRectificar())) {
			Oferta o = panel.getOferta();
			
			if(panel.getCampoPrecio().getText().isEmpty() == false) {
				try {
					o.setPrecio(Double.parseDouble(panel.getCampoPrecio().getText()));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Oooops");
				} catch (ArgumentoNoValido e) {
					JOptionPane.showMessageDialog(null, "Introduce un precio válido");
				}
			}
			
			if(panel.getCampoFianza().getText().isEmpty() == false) {
				try {
					((OfertaVacacional)o).setFianza(Double.parseDouble(panel.getCampoFianza().getText()));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Oooops");
				} catch (ArgumentoNoValido e) {
					JOptionPane.showMessageDialog(null, "Introduce una fianza válida");
				}
			}
			
			if(panel.getCampoIni().getText().isEmpty() == false) {
				trozos = panel.getCampoIni().getText().split("-");
			
				if(trozos.length < 3) {
					JOptionPane.showMessageDialog(null, "La fecha tienen que estar en el formato dd-mm-aaaa");
					return;
				}
				
				o.setIni(LocalDate.of(Integer.parseInt(trozos[2]), Integer.parseInt(trozos[1]), Integer.parseInt(trozos[0])));
			}

			if(panel.getCampoFin().getText().isEmpty() == false) {
				trozos = panel.getCampoFin().getText().split("-");
				
				if(trozos.length < 3) {
					JOptionPane.showMessageDialog(null, "La fecha tienen que estar en el formato dd-mm-aaaa");
					return;
				}
				
				((OfertaVacacional)o).setFin(LocalDate.of(Integer.parseInt(trozos[2]), Integer.parseInt(trozos[1]), Integer.parseInt(trozos[0])));
			}

			if(panel.getCampoDesc().getText().isEmpty() == false) {
				try {
					o.setDesc(panel.getCampoDesc().getText());
				} catch (ArgumentoNoValido e) {
					JOptionPane.showMessageDialog(null, "Introduce una descripción válida");
				}
			}

			if(panel.getCampoNmeses().getText().isEmpty() == false) {
				try {
					((OfertaResidencial)o).setNmeses(Integer.parseInt(panel.getCampoNmeses().getText()));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Oooops");
				} catch (ArgumentoNoValido e) {
					JOptionPane.showMessageDialog(null, "Introduce un número de meses válido");
				}
			}
			o.setEstado(Estado.RECTIFICADA);
			app.addPendiente(o);

			
		}if(event.equals(panel.getVolver())) {
			ventana.mostrarPendientesUsuario();
		}
	}

}
