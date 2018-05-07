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
	
	private JLabel labelOrden = new JLabel("Orden:");
	private String[] ordenes = {"Más caras primero", "Más baratas primero"};
	private JComboBox comboOrdenes = new JComboBox(ordenes);
	private JButton botonOrdenar = new JButton("Ordenar");
	
	private Sistema sist;
	
	
	public OferPanel(Sistema sist) {
		this.sist = sist;
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
		
		
		FiltrarPanel pFiltrar = new FiltrarPanel(sist);
		
		
		JList ofers = new JList();
		DefaultListModel modelo = new DefaultListModel();
		
		ofers.setModel(modelo);
		
		for(Oferta o: sist.getOfertas()) {
			modelo.addElement(o);
		}
		
		listaOfer = new JScrollPane(ofers);
		
		JPanel panelOrdenar = new JPanel();
		panelOrdenar.setLayout(new FlowLayout());
		panelOrdenar.add(labelOrden);
		panelOrdenar.add(comboOrdenes);
		
		
		panelLista.add(listaOfer);
		panelLista.add(pFiltrar);
		panelLista.add(panelOrdenar);
		panelLista.add(botonOrdenar);
		
		
		this.add(panelLista, BorderLayout.EAST);
		
		this.add(panelOferta, BorderLayout.WEST);
		
		
		
		
		
	}

}
