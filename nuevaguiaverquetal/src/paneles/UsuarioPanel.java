package paneles;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	
	public void setControlador(ActionListener a1) {
		bloquear.addActionListener(a1);
		desbloquear.addActionListener(a1);
		cambiarCard.addActionListener(a1);
	}

}
