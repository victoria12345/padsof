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

public class AdminPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JLabel uNombre = new JLabel();
	private JLabel uApellido = new JLabel();
	private JLabel uNick = new JLabel();
	private JLabel uBloq = new JLabel();
	
	private JList users = new JList();
	private DefaultListModel modelo = new DefaultListModel();
	private JScrollPane listaUser;
	private JButton botonMostrarBloq = new JButton("Mostrar bloqueados");
	private JButton botonMostrarTodos = new JButton("Mostrar todos");
	private JButton bBloquear = new JButton("Bloquear");
	private JButton bDesbloquear = new JButton("Desbloquear");
	private JButton bCambiar = new JButton("Cambiar tarjeta");
	private JLabel labelUser = new JLabel("Usuario:");
	private JButton botVerUser = new JButton("Ver usuario");
	
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
		
		JPanel botones = new JPanel();
		botones.setLayout(new FlowLayout());
		botones.add(bBloquear);
		botones.add(bDesbloquear);
		botones.add(bCambiar);
		
		/*JPanel panelDatos = new JPanel();
		panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
		panelDatos.add(uNombre);
		panelDatos.add(uApellido);
		panelDatos.add(uNick);
		panelDatos.add(uBloq);*/
		
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(new BorderLayout());
		panelUsuario.add(labelUser, BorderLayout.NORTH);
		//panelUsuario.add(panelDatos, BorderLayout.CENTER);
		panelUsuario.add(botones, BorderLayout.SOUTH);
		
		this.add(panelLista, BorderLayout.EAST);
		this.add(panelUsuario, BorderLayout.WEST);
	}
	
	public void actionPerformed(ActionEvent evento) {
	
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
	 * @return the bBloquear
	 */
	public JButton getbBloquear() {
		return bBloquear;
	}

	/**
	 * @param bBloquear the bBloquear to set
	 */
	public void setbBloquear(JButton bBloquear) {
		this.bBloquear = bBloquear;
	}

	/**
	 * @return the bDesbloquear
	 */
	public JButton getbDesbloquear() {
		return bDesbloquear;
	}

	/**
	 * @param bDesbloquear the bDesbloquear to set
	 */
	public void setbDesbloquear(JButton bDesbloquear) {
		this.bDesbloquear = bDesbloquear;
	}

	/**
	 * @return the bCambiar
	 */
	public JButton getbCambiar() {
		return bCambiar;
	}

	/**
	 * @param bCambiar the bCambiar to set
	 */
	public void setbCambiar(JButton bCambiar) {
		this.bCambiar = bCambiar;
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
	
	public void setControlador(ActionListener a1, ListSelectionListener l1) {
		this.botonMostrarBloq.addActionListener(a1);
		this.botonMostrarTodos.addActionListener(a1);
		this.bBloquear.addActionListener(a1);
		this.bCambiar.addActionListener(a1);
		this.bDesbloquear.addActionListener(a1);
		this.botVerUser.addActionListener(a1);
		this.users.addListSelectionListener(l1);
	}

	/**
	 * @return the uNombre
	 */
	public JLabel getuNombre() {
		return uNombre;
	}

	/**
	 * @param uNombre the uNombre to set
	 */
	public void setuNombre(JLabel uNombre) {
		this.uNombre = uNombre;
	}

	/**
	 * @return the uApellido
	 */
	public JLabel getuApellido() {
		return uApellido;
	}

	/**
	 * @param uApellido the uApellido to set
	 */
	public void setuApellido(JLabel uApellido) {
		this.uApellido = uApellido;
	}

	/**
	 * @return the uNick
	 */
	public JLabel getuNick() {
		return uNick;
	}

	/**
	 * @param uNick the uNick to set
	 */
	public void setuNick(JLabel uNick) {
		this.uNick = uNick;
	}

	/**
	 * @return the uBloq
	 */
	public JLabel getuBloq() {
		return uBloq;
	}

	/**
	 * @param uBloq the uBloq to set
	 */
	public void setuBloq(JLabel uBloq) {
		this.uBloq = uBloq;
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





}
