package gui;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Gui extends JFrame implements ChangeListener {
	private static final long serialVersionUID = 1L;
	private LoginPanel panelLogin;	
	private JTabbedPane pesta�as = new JTabbedPane();
	private Controlador controlador;
	
	public Gui(String titulo) {
		super(titulo); // antes: JFrame ventana = new JFrame("Mi GUI");
		
		// obtener contenedor, asignar layout
		Container contenedor = this.getContentPane(); // antes: ventana.getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		// crear componentes
		panelLogin = new LoginPanel(this);

		//pesta�as.addTab("Pares",  panelPares);
		//pesta�as.addTab("Pal�ndromos",  panelPalindromos);
		//pesta�as.setSelectedIndex(1); // 0 means first
		
		// a�adir componentes al contenedor
		contenedor.add(panelLogin);
		contenedor.add(pesta�as);
		// this.pack();
		
		// visibilidad inicial
		panelLogin.setVisible( true );
		pesta�as.setVisible( false );
		
		// Propuesta: PERMITIR REGRESAR A PANEL LOGIN DESDE CUALQUIER PESTA�A
		// Proposed work: ALLOW RETURN TO PANEL LOGIN FROM ANY TAB
		
		// Para realizar acciones al cambiar de pesta�as
		pesta�as.addChangeListener( this );

		// mostrar this, en otros ejemplos era ventana, ahora this
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,400); // remove and uncomment this.pack above
		this.setVisible(true);	
	}

	public void setControlador(Controlador c) {
		this.controlador = c;
	}
	public Controlador getControlador() {
		return this.controlador;
	}
	
	
	@Override
	public void stateChanged(ChangeEvent ev) {
     // solamente a efectos de seguimiento del programa
   	 System.out.println( pesta�as.getSelectedIndex() );
   	 System.out.println( pesta�as.getSelectedComponent() );
   	// this.panelPares.limpiaCampo();
   	//this.panelPalindromos.limpiaCampo();
	}

	public void loginResultANV() {
		this.panelLogin.setError("El nombre o la contrase�a no son v�lidos");
	}
	
	public void loginResultOUL() {
		this.panelLogin.setError("Hay otro usuario logeado");
	}
	
	public void loginResultUNE() {
		this.panelLogin.setError("El usuario o la cntrase�a no existen en el sistema");
	}

	public void loginResultOK() {
		panelLogin.setVisible( false );
		pesta�as.setVisible( true );
	}
	
}