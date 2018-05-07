package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.Sistema;
import excepciones.ArgumentoNoValido;
import gui.CustomFrame;
import paneles.AdminPanel;
import paneles.UsuarioPanel;
import usuarios.Demandante;
import usuarios.Ofertante;
import usuarios.Rol;
import usuarios.Usuario;

public class ControladorUsuario implements ActionListener{
	private CustomFrame ventana;
	private Sistema app;
		
	public ControladorUsuario(CustomFrame ventana, Sistema app) {
		this.ventana = ventana; 
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		UsuarioPanel panel = ventana.getPanelUsuario();
		Object event = arg0.getSource();
		Usuario u = panel.getUsuario();
		
		if(event.equals(panel.getBloquear())) {
			
			for(Rol r: u.getRoles()) {
				if(r.isOfertante()) {
					Ofertante ofer = (Ofertante)r;
					ofer.setBloqueado(true);
				}else if (r.isDemandante()) {
					Demandante deman = (Demandante)r;
					deman.setBloqueado(true);
				}
			}
			panel.getuBloq().setText("Bloqueado:" + u.isBloqueado());
			
		}else if(event.equals(panel.getDesbloquear())) {
			String pass;
			pass = JOptionPane.showInputDialog("Introduzca la nueva contraseña del usuario");
			try {
				u.setContrasenia(pass);
				for(Rol r: u.getRoles()) {
					if(r.isOfertante()) {
						Ofertante ofer = (Ofertante)r;
						ofer.setBloqueado(false);
					}else if (r.isDemandante()) {
						Demandante deman = (Demandante)r;
						deman.setBloqueado(false);
					}
					
				}
				panel.getuBloq().setText("Bloqueado:" + u.isBloqueado());
			}catch(ArgumentoNoValido e) {
				JOptionPane.showMessageDialog(null, "Contraseña no válida");
			}
			
		}else if(event.equals(panel.getCambiarCard())) {
			String tarjeta;
			tarjeta = JOptionPane.showInputDialog("Introduzca la nueva tarjeta");
			for(Rol r: u.getRoles()) {
				if(r.isOfertante()) {
					Ofertante ofer = (Ofertante)r;
					ofer.setTarjeta(tarjeta);
				}else if(r.isDemandante()) {
					Demandante deman = (Demandante)r;
					deman.setTarjeta(tarjeta);
				}
			}
			
		}else if(event.equals(panel.getVolver())) {
			AdminPanel admin = ventana.getPanelAdmin();
			admin.getUsers().clearSelection();
			ventana.mostrarPanelAdmin();
		}
			
		
		
	}

}
