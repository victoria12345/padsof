package paneles;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import usuarios.Usuario;

public class UsuarioPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel uNombre = new JLabel();
	private JLabel uApellido = new JLabel();
	private JLabel uNick = new JLabel();
	private JLabel uBloq = new JLabel();
	
	private JButton bloquear = new JButton("Bloquear");
	private JButton desbloquear = new JButton("Desbloquear");
	private JButton cambiarCard = new JButton("Cambiar Tarjeta");
	private JButton volver = new JButton("Volver");
	
	private Usuario usuario;
	
	public UsuarioPanel() {
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		
		JPanel botonera = new JPanel();
		botonera.setLayout(new FlowLayout());
		botonera.add(bloquear);
		botonera.add(desbloquear);
		botonera.add(cambiarCard);
		
		
		
		
		
		this.add(uNombre);
		this.add(uApellido);
		this.add(uNick);
		this.add(uBloq);
		this.add(botonera);
		this.add(volver);
		
		
	}
	
	public void iniciar(Usuario u) {
		this.usuario = u;
		if(u != null) {
			uNombre.setText("Nombre:" + u.getNombre());
			uApellido.setText("Apellido:" + u.getApellido());
			uNick.setText("Nick:" + u.getNick());
			uBloq.setText("Bloqueado:" + u.isBloqueado());
		}
	}
	
	public void setControlador(ActionListener a1) {
		bloquear.addActionListener(a1);
		desbloquear.addActionListener(a1);
		cambiarCard.addActionListener(a1);
		volver.addActionListener(a1);
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
	 * @return the bloquear
	 */
	public JButton getBloquear() {
		return bloquear;
	}

	/**
	 * @param bloquear the bloquear to set
	 */
	public void setBloquear(JButton bloquear) {
		this.bloquear = bloquear;
	}

	/**
	 * @return the desbloquear
	 */
	public JButton getDesbloquear() {
		return desbloquear;
	}

	/**
	 * @param desbloquear the desbloquear to set
	 */
	public void setDesbloquear(JButton desbloquear) {
		this.desbloquear = desbloquear;
	}

	/**
	 * @return the cambiarCard
	 */
	public JButton getCambiarCard() {
		return cambiarCard;
	}

	/**
	 * @param cambiarCard the cambiarCard to set
	 */
	public void setCambiarCard(JButton cambiarCard) {
		this.cambiarCard = cambiarCard;
	}

	/**
	 * @return the volver
	 */
	public JButton getVolver() {
		return volver;
	}

	/**
	 * @param volver the volver to set
	 */
	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	/**
	 * @return the u
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param u the u to set
	 */
	public void setUsuario(Usuario u) {
		this.usuario = u;
	}

}
