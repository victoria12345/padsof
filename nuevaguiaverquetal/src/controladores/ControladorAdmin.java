package controladores;

import app.Sistema;
import excepciones.ArgumentoNoValido;
import gui.*;
import paneles.AdminPanel;
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



public class ControladorAdmin implements ActionListener{
	private CustomFrame ventana;
	private Sistema app;
		
	public ControladorAdmin(CustomFrame ventana, Sistema app) {
		this.ventana = ventana; 
		this.app = app;
	}

	public List<Usuario> obtenerUsuarios(){
		return app.getUsuarios();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object event = arg0.getSource();
		AdminPanel panel = ventana.getPanelAdmin();
		JList list = panel.getUsers();

			if(event.equals(panel.getBotonMostrarBloq())) {
				for(Usuario u: app.getUsuarios()) {
					if(u.isBloqueado() == false) {
						panel.getModelo().removeElement(u);
					}
				}
			
			}else if(event.equals(panel.getBotonMostrarTodos())) {
				panel.getModelo().clear();
				for(Usuario u: app.getUsuarios()) {
					panel.getModelo().addElement(u);
				}

				
			
				
				
			}else if(event.equals(panel.getBotVerUser())) {
				
				int index =  list.getSelectedIndex();
				Usuario u;
				if((u = (Usuario)list.getModel().getElementAt(index)) == null) {
					return;
				}
				
				JPanel datos = new JPanel();
				datos.setLayout(new BoxLayout(datos, BoxLayout.Y_AXIS));
				JLabel nombre = new JLabel("Nombre: " + u.getNombre());
				JLabel apellido = new JLabel("Apellidos: " + u.getApellido());
				JLabel nick = new JLabel("Nick: " + u.getNick());
				JLabel bloq = new JLabel("Bloqueado: " + u.isBloqueado());
				datos.add(nombre);
				datos.add(apellido);
				datos.add(nick);
				datos.add(bloq);
				
				
				JButton bloquear = new JButton("Bloquear");
				bloquear.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						for(Rol r: u.getRoles()) {
							if(r.isOfertante()) {
								Ofertante ofer = (Ofertante)r;
								ofer.setBloqueado(true);
							}else if (r.isDemandante()) {
								Demandante deman = (Demandante)r;
								deman.setBloqueado(true);
							}
						}
						bloq.setText("Bloqueado:" + u.isBloqueado());
					}
				});
				
				JButton desbloquear = new JButton("Desbloquear");
				desbloquear.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
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
							bloq.setText("Bloqueado:" + u.isBloqueado());
						} catch (ArgumentoNoValido e) {
							JOptionPane.showMessageDialog(null, "Contraseña no válida");
						}
					}
				});
				
				
				JButton cambiarCard = new JButton("Cambiar tarjeta");
				cambiarCard.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
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
						
					}
					
				});
				
				
				
				
				
			
			
			}
	}



	
}
