package paneles;

import java.awt.*;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import app.Sistema;
import ofertas.Oferta;

public class OferPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JScrollPane  listaOfer;
	
	
	
	private JButton botonContratar = new JButton("Contratar");
	private JButton botonReservar = new JButton("Reservar");
	private JButton botonComentar = new JButton("Comentar");
	private JButton botonValorar = new JButton("Valorar");
	private JLabel rotulo = new JLabel("Oferta:"); 
	
	
	
	
	
	public OferPanel(Sistema app) {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		JPanel panelOferta = new JPanel();
		JPanel panelLista = new JPanel();
		panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));
		
		panelOferta.setLayout(new BorderLayout());
		panelOferta.add(rotulo, BorderLayout.NORTH);
		
		JPanel botones = new JPanel();
		botones.setLayout(new FlowLayout());
		botones.add(botonContratar);
		botones.add(botonReservar);
		botones.add(botonComentar);
		botones.add(botonValorar);
		
		
		
		panelOferta.add(botones, BorderLayout.SOUTH);
		
		FiltrarPanel pFiltrar = new FiltrarPanel(app);
		JList<Oferta> ofers = new JList(app.getOfertas().toArray());
		listaOfer = new JScrollPane(ofers);
		
		
		panelLista.add(listaOfer);
		panelLista.add(pFiltrar);
		
		
		
		this.add(panelLista, BorderLayout.EAST);
		
		this.add(panelOferta, BorderLayout.WEST);
		
		
		
		
		
	}

}
