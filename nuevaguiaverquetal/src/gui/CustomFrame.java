package gui;

import paneles.*;
import controladores.*;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import app.Sistema;

/**
 * Descripcion de la clase CustomFrame, extension de JFrame
 * donde contendremos todos los paneles de nuestra app
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class CustomFrame  extends JFrame implements WindowListener{
	private static final long serialVersionUID = 1L;
	
	private String ventanas[] = {"login", "admin", "ofertas", "inmuebles" , "associarOferta", "subirinmueble", "Elegir rol", "invitado", "demandante", "usuario", "pendientes", "oferpendiente", "eleccion", "residencial", "vacacional", "veroferta", "comentario", "asociadas", "pendientesuser", "rectificar"};
	
	private CardLayout cards;
	private JPanel principal;
	private Sistema app;
	private LocalDate fecha;
	
	
	private LoginPanel panelLogin;
	private AdminPanel panelAdmin;
	private OferPanel panelOfertas;
	private InmueblesPanel panelInmuebles;
	private SubirInmueblePanel panelSubirInmu;
	private ElegirRolPanel panelRol;
	private InvitadoPanel panelInvitado;
	private DemandantePanel panelDemandante;
	private UsuarioPanel panelUsuario;
	private PendientesPanel panelPendientes;
	private OferPendientePanel panelOferPendiente;
	private EleccionOfertaPanel panelEleccion;
	private OfertaResidencialPanel panelOfertaRes;
	private OfertaVacacionalPanel panelOfertaVac;
	private VerOfertaPanel panelVerOferta;
	private ComentarioPanel panelComentario;
	private OfertasAsociadasPanel panelAsociadas;
	private OfertasPendientesPanel panelPendientesUser;
	private RectificarPanel panelRectificar;
	
	private ControladorLogin cLogin;
	private ControladorAdmin cAdmin;
	private ControladorInmuebles cInmu;
	private ControladorSubirInmueble cSubirInmu;
	private ControladorRol cRol;
	private ControladorInvitado cInvitado;
	private ControladorDemandante cDeman;
	private ControladorOfertas cOfer;
	private ControladorUsuario cUser;
	private ControladorOferPendiente cOferPen;
	private ControladorPendientes cPendientes;
	private ControladorEleccion cEleccion;
	private ControladorResidencial cRes;
	private ControladorVacacional cVac;
	private ControladorVerOferta cVerOfer;
	private ControladorComentario cComent;
	private ControladorAsociadas cAsociadas;
	private ControladorPendientesUsuario cPenUser;
	private ControladorRectificar cRect;
	
	
	
	/**
	 * Constructor de la clase
	 * @param titulo String con el nombre de nuestra app
	 * @param fecha fecha de inicio de la app
	 * @param app sistema con los datos y funciones pertinentes
	 */
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
		panelInmuebles = new InmueblesPanel();
		panelSubirInmu = new SubirInmueblePanel();
		panelRol = new ElegirRolPanel(app);
		panelInvitado = new InvitadoPanel(app);
		panelDemandante = new DemandantePanel();
		panelUsuario = new UsuarioPanel();
		panelPendientes = new PendientesPanel(app);
		panelOferPendiente = new OferPendientePanel();
		panelEleccion = new EleccionOfertaPanel(app);
		panelOfertaRes = new OfertaResidencialPanel();
		panelOfertaVac = new OfertaVacacionalPanel(app);
		panelVerOferta = new VerOfertaPanel();
		panelComentario = new ComentarioPanel();
		panelAsociadas = new OfertasAsociadasPanel();
		panelPendientesUser = new OfertasPendientesPanel(app);
		panelRectificar = new RectificarPanel();
		
		cLogin = new ControladorLogin(this, app);
		cAdmin = new ControladorAdmin(this, app);
		cSubirInmu = new ControladorSubirInmueble(this,app);
		cRol = new ControladorRol(this,app);
		cInvitado = new ControladorInvitado(this, app);
		cOfer = new ControladorOfertas(this, app);
		cDeman = new ControladorDemandante(this);
		cUser = new ControladorUsuario(this);
		cOferPen = new ControladorOferPendiente(this, app);
		cPendientes = new ControladorPendientes(this);
		cEleccion = new ControladorEleccion(this);
		cRes = new ControladorResidencial(this, app);
		cVac = new ControladorVacacional(this, app);
		cVerOfer = new ControladorVerOferta(this, app);
		cComent = new ControladorComentario(this, app);
		cAsociadas = new ControladorAsociadas(app, this);
		cPenUser = new ControladorPendientesUsuario(this);
		cInmu = new ControladorInmuebles(this);
		cRect = new ControladorRectificar(this, app);
		
		
		
		panelLogin.setControlador(cLogin);
		panelAdmin.setControlador(cAdmin);
		panelSubirInmu.setControlador(cSubirInmu);
		panelRol.setControlador(cRol);
		panelInvitado.setControlador(cInvitado);
		panelDemandante.setControlador(cDeman);
		panelOfertas.setControlador(cOfer);
		panelUsuario.setControlador(cUser);
		panelPendientes.setControlador(cPendientes);
		panelOferPendiente.setControlador(cOferPen);
		panelEleccion.setControlador(cEleccion);
		panelOfertaRes.setControlador(cRes);
		panelOfertaVac.setControlador(cVac);
		panelVerOferta.setControlador(cVerOfer);
		panelComentario.setControlador(cComent);
		panelAsociadas.setControlador(cAsociadas);
		panelPendientesUser.setControlador(cPenUser);
		panelInmuebles.setControlador(cInmu);
		panelRectificar.setControlador(cRect);
		
		principal.add(panelLogin, ventanas[0]);
		principal.add(panelAdmin, ventanas[1]);
		principal.add(panelOfertas, ventanas[2]);
		principal.add(panelInmuebles, ventanas[3]);
		principal.add(panelSubirInmu, ventanas[5]);
		principal.add(panelRol, ventanas[6]);
		principal.add(panelInvitado, ventanas[7]);
		principal.add(panelDemandante, ventanas[8]);
		principal.add(panelUsuario, ventanas[9]);
		principal.add(panelPendientes, ventanas[10]);
		principal.add(panelOferPendiente, ventanas[11]);
		principal.add(panelEleccion, ventanas[12]);
		principal.add(panelOfertaRes, ventanas[13]);
		principal.add(panelOfertaVac, ventanas[14]);
		principal.add(panelVerOferta, ventanas[15]);
		principal.add(panelComentario, ventanas[16]);
		principal.add(panelAsociadas, ventanas[17]);
		principal.add(panelPendientesUser, ventanas[18]);
		principal.add(panelRectificar, ventanas[19]);
		
		cards.show(principal, ventanas[0]);
		
		Container contenedor = this.getContentPane();
		contenedor.add(principal);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1050, 400); 
		this.setVisible(true);
		this.setResizable(false);
		this.addWindowListener(this);
		
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
	
	public void mostrarPanelSubirInmu() {
		cards.show(principal,  ventanas[5]);
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
	
	public void mostrarPanelEleccion() {
		cards.show(principal, ventanas[12]);
	}
	public void mostrarPanelOfertaRes() {
		cards.show(principal, ventanas[13]);
	}
	public void mostrarPanelOfertaVac() {
		cards.show(principal, ventanas[14]);
	}

	public void mostrarPanelVerOferta() {
		cards.show(principal, ventanas[15]);
	}
	
	public void mostrarPanelComentario() {
		cards.show(principal, ventanas[16]);
	}
	
	public void mostrarPanelAsociadas() {
		cards.show(principal, ventanas[17]);
	}
	
	public void mostrarPendientesUsuario() {
		cards.show(principal, ventanas[18]);
	}
	
	public void mostrarPanelRectificar() {
		cards.show(principal, ventanas[19]);
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

	/**
	 * @return the panelEleccion
	 */
	public EleccionOfertaPanel getPanelEleccion() {
		return panelEleccion;
	}

	/**
	 * @param panelEleccion the panelEleccion to set
	 */
	public void setPanelEleccion(EleccionOfertaPanel panelEleccion) {
		this.panelEleccion = panelEleccion;
	}

	/**
	 * @return the panelOfertaRes
	 */
	public OfertaResidencialPanel getPanelOfertaRes() {
		return panelOfertaRes;
	}

	/**
	 * @param panelOfertaRes the panelOfertaRes to set
	 */
	public void setPanelOfertaRes(OfertaResidencialPanel panelOfertaRes) {
		this.panelOfertaRes = panelOfertaRes;
	}

	/**
	 * @return the panelOfertaVac
	 */
	public OfertaVacacionalPanel getPanelOfertaVac() {
		return panelOfertaVac;
	}

	/**
	 * @param panelOfertaVac the panelOfertaVac to set
	 */
	public void setPanelOfertaVac(OfertaVacacionalPanel panelOfertaVac) {
		this.panelOfertaVac = panelOfertaVac;
	}

	/**
	 * @return the panelVerOferta
	 */
	public VerOfertaPanel getPanelVerOferta() {
		return panelVerOferta;
	}

	/**
	 * @param panelVerOferta the panelVerOferta to set
	 */
	public void setPanelVerOferta(VerOfertaPanel panelVerOferta) {
		this.panelVerOferta = panelVerOferta;
	}

	/**
	 * @return the panelComentario
	 */
	public ComentarioPanel getPanelComentario() {
		return panelComentario;
	}

	/**
	 * @param panelComentario the panelComentario to set
	 */
	public void setPanelComentario(ComentarioPanel panelComentario) {
		this.panelComentario = panelComentario;
	}

	/**
	 * @return the panelOfertasAsociadas
	 */
	public OfertasAsociadasPanel getPanelAsociadas() {
		return panelAsociadas;
	}

	/**
	 * @param panelOfertasAsociadas the panelOfertasAsociadas to set
	 */
	public void setPanelAsociadas(OfertasAsociadasPanel panelOfertasAsociadas) {
		this.panelAsociadas = panelOfertasAsociadas;
	}

	/**
	 * @return the panelPendientesUser
	 */
	public OfertasPendientesPanel getPanelPendientesUser() {
		return panelPendientesUser;
	}

	/**
	 * @param panelPendientesUser the panelPendientesUser to set
	 */
	public void setPanelPendientesUser(OfertasPendientesPanel panelPendientesUser) {
		this.panelPendientesUser = panelPendientesUser;
	}
	
	/**
	 * @return the panelRectificar
	 */
	public RectificarPanel getPanelRectificar() {
		return panelRectificar;
	}

	/**
	 * @param panelRectificar the panelRectificar to set
	 */
	public void setPanelRectificar(RectificarPanel panelRectificar) {
		this.panelRectificar = panelRectificar;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		app.logout();
		try {
			app.serializar();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "error en la serializacion");
		}
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
