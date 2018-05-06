package paneles;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JPanel;

import gui.CustomFrame;
import usuarios.Usuario;

public class AdminPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JList<Usuario> userList = new JList<Usuario>();
	private JPanel panelLista = new JPanel(); 
	private JPanel panelDatos = new JPanel();
	
	private CustomFrame frame;
	
	public AdminPanel(CustomFrame frame) {
		this.frame = frame;
		this.setLayout(new BorderLayout());
		
		
		
		panelLista.add(userList);

	}
	
	public void actionPerformed(ActionEvent evento) {
	
    }




}
