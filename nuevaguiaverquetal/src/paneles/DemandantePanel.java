package paneles;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.Sistema;
import usuarios.Demandante;
import usuarios.Rol;
import usuarios.Usuario;

public class DemandantePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Sistema app;
	
	private JLabel rResidencial = new JLabel();
	private JLabel rVacacional = new JLabel();
	private JButton atras = new JButton("Atrás");
	private Demandante deman;
	
	
	public DemandantePanel() {
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		this.add(rResidencial);
		this.add(rVacacional);
		this.add(atras);
		
		
	}
	
	
	public void iniciar(Sistema app) {
		this.app = app;
		Usuario u = app.getUsuarioActual();
		for(Rol r: u.getRoles()) {
			if(r.isDemandante()) {
				deman = (Demandante)r;
			}
		}
		
		if(deman.getResidencial() != null) {
			rResidencial.setText("Reserva residencial:" + deman.getResidencial().toString());
		}
		
		if(deman.getVacacional() != null) {
			rVacacional.setText("Reserva vacacional:" + deman.getVacacional().toString());
		}
		
	}

	
	public void setControlador(ActionListener a1) {
		this.atras.addActionListener(a1);
	}


	/**
	 * @return the atras
	 */
	public JButton getAtras() {
		return atras;
	}


	/**
	 * @param atras the atras to set
	 */
	public void setAtras(JButton atras) {
		this.atras = atras;
	}
}

