package paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

import app.Sistema;
import inmuebles.Inmueble;
import ofertas.Oferta;
import usuarios.Ofertante;
import usuarios.Rol;
import usuarios.Usuario;

public class InmueblesPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JScrollPane listaInmu;
	
	private JButton bAñadir = new JButton("Nuevo inmueble");
	private JButton bBorrar = new JButton("Borrar inmueble");
	private JButton bAsociar = new JButton("Asociar oferta");
	
	private JLabel rotulo = new JLabel("Inmueble:");

	
	public InmueblesPanel(Sistema app) {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		JPanel panelInmu = new JPanel();
		JPanel panelLista = new JPanel();
				
		
		
		panelInmu.setLayout(new BorderLayout());
		panelInmu.add(rotulo, BorderLayout.NORTH);
		panelInmu.add(bAsociar, BorderLayout.SOUTH);
		
		JPanel botones = new JPanel();
		botones.setLayout(new FlowLayout());
		botones.add(bAñadir);
		botones.add(bBorrar);
		
		panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));
		
		
		/*Usuario u = app.getUsuarioActual();
		Ofertante ofer = null;
		
		for(Rol r: u.getRoles()) {
			if(r.isOfertante()) {
				ofer = (Ofertante)r;
			}
		}
		
		JList<Inmueble> inmus = new JList(ofer.getInmuebles().toArray());
		listaInmu = new JScrollPane(inmus);
		
		panelLista.add(listaInmu);*/
		panelLista.add(botones);
		
		this.add(panelLista, BorderLayout.EAST);
		this.add(panelInmu, BorderLayout.WEST);
		
		
		
	}

}
