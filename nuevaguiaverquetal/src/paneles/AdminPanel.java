package paneles;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;


import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import app.Sistema;

import usuarios.Usuario;

/**
 * Descripcion de la clase AdminPanel
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
@SuppressWarnings("rawtypes")
public class AdminPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private JList users = new JList();
	private DefaultListModel modelo = new DefaultListModel();
	private JScrollPane listaUser;
	private JButton botonMostrarBloq = new JButton("Mostrar bloqueados");
	private JButton botonMostrarTodos = new JButton("Mostrar todos");
	private JButton botVerUser = new JButton("Ver usuario");
	
	private JButton botOfertas = new JButton("Ver ofertas bloqueadas");
	private JButton botVolver = new JButton("Volver");
	
	private Sistema sist;
	
	/**
	 * Constructor del panel de administrador
	 * @param sist sistema con los datos y funciones pertinentes
	 */
	@SuppressWarnings("unchecked")
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
		
		
		JPanel botones = new JPanel();
		botones.setLayout(new FlowLayout());
		botones.add(botOfertas);
		botones.add(botVolver);
		panelLista.add(botones);
		
		this.add(panelLista, BorderLayout.CENTER);
	}


	/**
	 * @return the botonMostrarBloq
	 */
	public JButton getBotonMostrarBloq() {
		return botonMostrarBloq;
	}

	/**
	 * @return the botonMostrarTodos
	 */
	public JButton getBotonMostrarTodos() {
		return botonMostrarTodos;
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
	
	/**
	 * Establece un controlador para el panel
	 * @param a1 controlador del panel
	 */
	public void setControlador(ActionListener a1) {
		this.botonMostrarBloq.addActionListener(a1);
		this.botonMostrarTodos.addActionListener(a1);
		this.botVerUser.addActionListener(a1);
		this.botOfertas.addActionListener(a1);
		this.botVolver.addActionListener(a1);
	}

	/**
	 * @return the botVerUser
	 */
	public JButton getBotVerUser() {
		return botVerUser;
	}

	/**
	 * @return the botOfertas
	 */
	public JButton getBotOfertas() {
		return botOfertas;
	}

	/**
	 * @return the sist
	 */
	public Sistema getSist() {
		return sist;
	}


	/**
	 * @return the botVolver
	 */
	public JButton getBotVolver() {
		return botVolver;
	}






}
