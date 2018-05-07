package gui;

import paneles.*;
import controladores.*;

import java.awt.CardLayout;
import java.awt.Container;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import app.Sistema;


public class CustomFrame  extends JFrame implements ChangeListener{
	private static final long serialVersionUID = 1L;
	
	private String ventanas[] = {"login", "admin", "ofertas", "inmuebles" , "associarOferta", "subirinmueble", "Elegir rol", "invitado", "demandante", "usuario", "pendientes", "oferpendiente"};
	
	private CardLayout cards;
	private JPanel principal;
	private Sistema app;
	private LocalDate fecha;
	
	
	private LoginPanel panelLogin;
	private AdminPanel panelAdmin;
	private OferPanel panelOfertas;
	private InmueblesPanel panelInmuebles;
	private AsociarOfertaPanel panelAsociarOfer;
	private SubirInmueblePanel panelSubirInmu;
	private ElegirRolPanel panelRol;
	private InvitadoPanel panelInvitado;
	private DemandantePanel panelDemandante;
	private UsuarioPanel panelUsuario;
	private PendientesPanel panelPendientes;
	private OferPendientePanel panelOferPendiente;
	
	private ControladorLogin cLogin;
	private ControladorAdmin cAdmin;
	private ControladorSubirInmueble cSubirInmu;
	private ControladorRol cRol;
	private ControladorInvitado cInvitado;
	private ControladorDemandante cDeman;
	private ControladorOfertas cOfer;
	private ControladorUsuario cUser;
	private ControladorOferPendiente cOferPen;
	private ControladorPendientes cPendientes;
	
	
	
	
	public CustomFrame(Sistema app, String titulo, LocalDate fecha) {
		super(titulo);
		this.fecha = fecha;
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
		panelRol = new ElegirRolPanel(app);
		panelInvitado = new InvitadoPanel(app);
		panelDemandante = new DemandantePanel();
		panelUsuario = new UsuarioPanel();
		panelPendientes = new PendientesPanel(app);
		panelOferPendiente = new OferPendientePanel();
		
		cLogin = new ControladorLogin(this, app);
		cAdmin = new ControladorAdmin(this, app);
		cSubirInmu = new ControladorSubirInmueble(this,app);
		cRol = new ControladorRol(this,app);
		cInvitado = new ControladorInvitado(this, app);
		cOfer = new ControladorOfertas(this, app);
		cDeman = new ControladorDemandante(this, app);
		cUser = new ControladorUsuario(this, app);
		cOferPen = new ControladorOferPendiente(this, app);
		cPendientes = new ControladorPendientes(this, app);
		
		
		
		panelLogin.setControlador(cLogin);
		panelAdmin.setControlador(cAdmin);
		panelSubirInmu.setControlador(cSubirInmu);
		panelRol.setControlador(cRol);
		panelInvitado.setControlador(cInvitado, cInvitado);
		panelDemandante.setControlador(cDeman);
		panelOfertas.setControlador(cOfer, cOfer);
		panelUsuario.setControlador(cUser);
		panelPendientes.setControlador(cPendientes);
		panelOferPendiente.setControlador(cOferPen);
		
		principal.add(panelLogin, ventanas[0]);
		principal.add(panelAdmin, ventanas[1]);
		principal.add(panelOfertas, ventanas[2]);
		principal.add(panelInmuebles, ventanas[3]);
		principal.add(panelAsociarOfer, ventanas[4]);
		principal.add(panelSubirInmu, ventanas[5]);
		principal.add(panelRol, ventanas[6]);
		principal.add(panelInvitado, ventanas[7]);
		principal.add(panelDemandante, ventanas[8]);
		principal.add(panelUsuario, ventanas[9]);
		principal.add(panelPendientes, ventanas[10]);
		principal.add(panelOferPendiente, ventanas[11]);
	
		cards.show(principal, ventanas[0]);
		
		Container contenedor = this.getContentPane();
		contenedor.add(principal);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1050, 400); 
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
	
	public SubirInmueblePanel getSubirInmuPanel() {
		return panelSubirInmu;
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
	
	public InmueblesPanel getPanelInmuebles() {
		return panelInmuebles;
	}

	public void setPanelInmuebles(InmueblesPanel panelInmuebles) {
		this.panelInmuebles = panelInmuebles;
	}

	public AsociarOfertaPanel getPanelAsociarOfer() {
		return panelAsociarOfer;
	}

	public void setPanelAsociarOfer(AsociarOfertaPanel panelAsociarOfer) {
		this.panelAsociarOfer = panelAsociarOfer;
	}

	public SubirInmueblePanel getPanelSubirInmu() {
		return panelSubirInmu;
	}

	public void setPanelSubirInmu(SubirInmueblePanel panelSubirInmu) {
		this.panelSubirInmu = panelSubirInmu;
	}

	public ElegirRolPanel getPanelRol() {
		return panelRol;
	}

	public void setPanelRol(ElegirRolPanel panelRol) {
		this.panelRol = panelRol;
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
	
	public void mostrarPanelRol() {
		cards.show(principal, ventanas[6]);
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
	
	public void mostrarPanelInvitado() {
		cards.show(principal, ventanas[7]);
	}
	
	public void mostrarPanelDemandante() {
		cards.show(principal, ventanas[8]);
	}
	
	public void mostrarPanelUsuario() {
		cards.show(principal, ventanas[9]);
	}
	
	public void mostrarPanelPendientes(){
		cards.show(principal, ventanas[10]);
	}
	
	public void mostrarPanelOferPendiente() {
		cards.show(principal, ventanas[11]);
	}

	/**
	 * @return the panelInvitado
	 */
	public InvitadoPanel getPanelInvitado() {
		return panelInvitado;
	}

	/**
	 * @param panelInvitado the panelInvitado to set
	 */
	public void setPanelInvitado(InvitadoPanel panelInvitado) {
		this.panelInvitado = panelInvitado;
	}

	/**
	 * @return the panelDemandante
	 */
	public DemandantePanel getPanelDemandante() {
		return panelDemandante;
	}

	/**
	 * @param panelDemandante the panelDemandante to set
	 */
	public void setPanelDemandante(DemandantePanel panelDemandante) {
		this.panelDemandante = panelDemandante;
	}

	/**
	 * @return the panelUsuario
	 */
	public UsuarioPanel getPanelUsuario() {
		return panelUsuario;
	}

	/**
	 * @param panelUsuario the panelUsuario to set
	 */
	public void setPanelUsuario(UsuarioPanel panelUsuario) {
		this.panelUsuario = panelUsuario;
	}

	/**
	 * @return the panelPendientes
	 */
	public PendientesPanel getPanelPendientes() {
		return panelPendientes;
	}

	/**
	 * @param panelPendientes the panelPendientes to set
	 */
	public void setPanelPendientes(PendientesPanel panelPendientes) {
		this.panelPendientes = panelPendientes;
	}

	/**
	 * @return the panelOferPendiente
	 */
	public OferPendientePanel getPanelOferPendiente() {
		return panelOferPendiente;
	}

	/**
	 * @param panelOferPendiente the panelOferPendiente to set
	 */
	public void setPanelOferPendiente(OferPendientePanel panelOferPendiente) {
		this.panelOferPendiente = panelOferPendiente;
	}

	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
}
