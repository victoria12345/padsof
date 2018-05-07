package controladores;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app.Sistema;
import gui.CustomFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import paneles.AdminPanel;
import usuarios.Usuario;

public class ControlListUsers implements ListSelectionListener{
	private CustomFrame ventana;
	private Sistema app;
	
	public ControlListUsers(CustomFrame ventana, Sistema app) {
		this.ventana = ventana;
		this.app = app;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList)e.getSource();
		AdminPanel panel = ventana.getPanelAdmin();
		int index = list.getSelectedIndex();

	
		Usuario u = (Usuario)list.getModel().getElementAt(index);
		
		panel.getuNombre().setText("Nombre:" + u.getNombre());
		panel.getuApellido().setText("Apellidos:" + u.getApellido());
		panel.getuNick().setText("Nick:" + u.getNick());
		panel.getuBloq().setText("Bloqueado:" + u.isBloqueado());
			


		
		
		
		

	}

}
