package paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;

import app.Sistema;
import gui.CustomFrame;
import ofertas.Oferta;
import usuarios.Usuario;

public class AdminPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private JList users = new JList();
	private DefaultListModel modelo = new DefaultListModel();
	private JScrollPane listaUser;
	private JButton botonMostrarBloq = new JButton("Mostrar bloqueados");
	private JButton botonMostrarTodos = new JButton("Mostrar todos");
	private JButton botVerUser = new JButton("Ver usuario");
	
	private JButton botOfertas = new JButton("Ver ofertas bloqueadas");
	
	private Sistema sist;
	
	public AdminPanel(Sistema sist) {
		this.sist = sist;
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		
		users.setModel(modelo);
		
		for(Usuario u: sist.getUsuarios()) {
			modelo.addElement(u);
		}
		listaUser = new JScrollPane(users);
		
		JPanel panelLista = new JPanel();
		panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));
		panelLista.add(listaUser);
		JPanel botones2 = new JPanel();
		botones2.setLayout(new FlowLayout());
		botones2.add(botonMostrarBloq);
		botones2.add(botonMostrarTodos);
		botones2.add(botVerUser);
		panelLista.add(botones2);
		
		this.add(panelLista, BorderLayout.CENTER);
		this.add(botOfertas, BorderLayout.SOUTH);

	}


	/**
	 * @return the botonMostrarBloq
	 */
	public JButton getBotonMostrarBloq() {
		return botonMostrarBloq;
	}

	/**
	 * @param botonMostrarBloq the botonMostrarBloq to set
	 */
	public void setBotonMostrarBloq(JButton botonMostrarBloq) {
		this.botonMostrarBloq = botonMostrarBloq;
	}

	/**
	 * @return the botonMostrarTodos
	 */
	public JButton getBotonMostrarTodos() {
		return botonMostrarTodos;
	}

	/**
	 * @param botonMostrarTodos the botonMostrarTodos to set
	 */
	public void setBotonMostrarTodos(JButton botonMostrarTodos) {
		this.botonMostrarTodos = botonMostrarTodos;
	}

	
	/**
	 * @return the modelo
	 */
	public DefaultListModel getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(DefaultListModel modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the users
	 */
	public JList getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(JList users) {
		this.users = users;
	}
	
	public void setControlador(ActionListener a1) {
		this.botonMostrarBloq.addActionListener(a1);
		this.botonMostrarTodos.addActionListener(a1);
		this.botVerUser.addActionListener(a1);
		this.botOfertas.addActionListener(a1);
	}

	/**
	 * @return the botVerUser
	 */
	public JButton getBotVerUser() {
		return botVerUser;
	}

	/**
	 * @param botVerUser the botVerUser to set
	 */
	public void setBotVerUser(JButton botVerUser) {
		this.botVerUser = botVerUser;
	}


	/**
	 * @return the botOfertas
	 */
	public JButton getBotOfertas() {
		return botOfertas;
	}


	/**
	 * @param botOfertas the botOfertas to set
	 */
	public void setBotOfertas(JButton botOfertas) {
		this.botOfertas = botOfertas;
	}





}
