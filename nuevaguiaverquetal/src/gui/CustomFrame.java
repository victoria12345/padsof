package gui;

import paneles.*;
import controladores.*;

import java.awt.CardLayout;
import java.awt.Container;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import app.Sistema;


public class CustomFrame  extends JFrame implements ChangeListener{
	private static final long serialVersionUID = 1L;
	
	private String ventanas[] = {"login", "admin", "ofertas", "inmuebles" , "associarOferta", "subirinmueble"};
	
	private CardLayout cards;
	private JPanel principal;
	private Sistema app;
	
	private LoginPanel panelLogin;
	private AdminPanel panelAdmin;
	private OferPanel panelOfertas;
	private InmueblesPanel panelInmuebles;
	private AsociarOfertaPanel panelAsociarOfer;
	private SubirInmueblePanel panelSubirInmu;


	private ControladorLogin cLogin;
	private ControladorAdmin cAdmin;
	private ControlListUsers cListUsers;
	
	
	
	public CustomFrame(Sistema app, String titulo) {
		super(titulo);
		cards = new CardLayout();
		principal = new JPanel();
		principal.setLayout(cards);
		this.app = app;
		
		
		panelLogin = new LoginPanel();
		panelAdmin = new AdminPanel(app);
		panelOfertas = new OferPanel(app);
		panelInmuebles = new InmueblesPanel(app);
		panelAsociarOfer = new AsociarOfertaPanel(app);
		panelSubirInmu = new SubirInmueblePanel(app);
		
		cLogin = new ControladorLogin(this, app);
		cAdmin = new ControladorAdmin(this, app);
		cListUsers = new ControlListUsers(this, app);
		
		
		panelLogin.setControlador(cLogin);
		panelAdmin.setControlador(cAdmin, cListUsers);
		
		principal.add(panelLogin, ventanas[0]);
		principal.add(panelAdmin, ventanas[1]);
		principal.add(panelOfertas, ventanas[2]);
		principal.add(panelInmuebles, ventanas[3]);
		principal.add(panelAsociarOfer, ventanas[4]);
		principal.add(panelSubirInmu, ventanas[5]);
	
		cards.show(principal, ventanas[1]);
		
		Container contenedor = this.getContentPane();
		contenedor.add(principal);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(950, 400); 
		this.setVisible(true);
		this.setResizable(false);
		
	}
	
	public void setControladorLogin(ControladorLogin c) {
		this.cLogin = c;
	}
	
	public ControladorLogin getControladorLogin() {
		return cLogin;
	}
	
	public LoginPanel getPanelLogin() {
		return panelLogin;
	}
	
	
	
	public void setControladorAdmin(ControladorAdmin c) {
		this.cAdmin = c;
	}
	
	public ControladorAdmin getControladorAdmin() {
		return cAdmin;
	}
	
	
	public OferPanel getPanelOfertas() {
		return panelOfertas;
	}
	
	
	
	public CardLayout getCards() {
		return cards;
	}
	@Override
	public void stateChanged(ChangeEvent arg0) {
		 // solamente a efectos de seguimiento del programa
		
	   	 /*System.out.println( pestañas.getSelectedIndex() );
	   	 System.out.println( pestañas.getSelectedComponent() );*/
		
	   	// this.panelPares.limpiaCampo();
	   	//this.panelPalindromos.limpiaCampo();
		
	}

	public String[] getVentanas() {
		return ventanas;
	}

	public void setVentanas(String[] ventanas) {
		this.ventanas = ventanas;
	}

	public JPanel getPrincipal() {
		return principal;
	}

	public void setPrincipal(JPanel principal) {
		this.principal = principal;
	}

	public Sistema getApp() {
		return app;
	}

	public void setApp(Sistema app) {
		this.app = app;
	}

	public AdminPanel getPanelAdmin() {
		return panelAdmin;
	}

	public void setPanelAdmin(AdminPanel panelAdmin) {
		this.panelAdmin = panelAdmin;
	}

	public ControladorLogin getcLogin() {
		return cLogin;
	}

	public void setcLogin(ControladorLogin cLogin) {
		this.cLogin = cLogin;
	}

	public ControladorAdmin getcAdmin() {
		return cAdmin;
	}

	public void setcAdmin(ControladorAdmin cAdmin) {
		this.cAdmin = cAdmin;
	}

	public void setCards(CardLayout cards) {
		this.cards = cards;
	}

	public void setPanelLogin(LoginPanel panelLogin) {
		this.panelLogin = panelLogin;
	}

	public void setPanelOfertas(OferPanel panelOfertas) {
		this.panelOfertas = panelOfertas;
	}
	
	
	public void mostrarPanelLogin() {
		cards.show(principal, ventanas[0]);
	}
	
	public void mostrarPanelAdmin() {
		cards.show(principal, ventanas[1]);
	}
	
	public void mostrarPanelOfertas() {
		cards.show(principal, ventanas[2]);
	}
	
	public void mostrarPanelInmuebles() {
		cards.show(principal,  ventanas[3]);
	}
}
