package paneles;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;



import ofertas.Oferta;
import ofertas.OfertaResidencial;
import ofertas.OfertaVacacional;
/**
 * Descripcion de la clase VerOfertaPanel
 * @author Victoria Pelayo e Ignacio Rabunnal
 *
 */
public class VerOfertaPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JLabel oPrecio = new JLabel();
	private JLabel oIni = new JLabel();
	private JLabel oDesc = new JLabel();
	private JLabel oDisp = new JLabel();
	private JLabel precioTotal = new JLabel();
	private JLabel nmeses = new JLabel();
	private JLabel fin = new JLabel();
	private JLabel fianza = new JLabel();

	private JButton botonContratar = new JButton("Contratar");
	private JButton botonReservar = new JButton("Reservar");
	private JButton botonComentar = new JButton("Comentar");
	private JButton botonValorar = new JButton("Valorar");
	private JButton botonVolver = new JButton("Volver");
	private JButton botonComentarios = new JButton("Ver comentarios");
	
	private Oferta oferta;
	/**
	 * Constructor del panel de ver oferta
	 */
	public VerOfertaPanel() {
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		
		JPanel botonera = new JPanel();
		botonera.setLayout(new FlowLayout());
		botonera.add(botonContratar);
		botonera.add(botonReservar);
		botonera.add(botonComentar);
		botonera.add(botonValorar);
		botonera.add(botonComentarios);
		botonera.add(botonVolver);
		
		
		this.add(oPrecio);
		this.add(oIni);
		this.add(oDesc);
		this.add(oDisp);
		this.add(nmeses);
		this.add(fin);
		this.add(fianza);
		this.add(precioTotal);
		this.add(botonera);
		this.add(botonVolver);

	}
	
	public void iniciar(Oferta o) {
		this.oferta = o;
		
		if(o != null) {
			oPrecio.setText("Precio:" + o.getPrecio());
			oIni.setText("Fecha de inicio:" + o.getIni());
			oDesc.setText("Descripcion:" + o.getDesc());
			oDisp.setText("Disponibilidad:" + o.getDisp());
			precioTotal.setText("Precio total:" + o.calcularPrecio());
			if(o.isResidencial()) {
				OfertaResidencial ores = (OfertaResidencial)o;
				nmeses.setText("Número de meses de alquiler:" + ores.getNmeses());
			}else if(o.isVacacional()) {
				OfertaVacacional ovac = (OfertaVacacional)o;
				fin.setText("Fecha de finalizacion:" + ovac.getFin());
				fianza.setText("Fianza:" + ovac.getFianza());
			}
		}
		
	}
	
	/**
	 * Establece un controlador para el panel
	 * @param a1 controlador del panel
	 */
	public void setControlador(ActionListener a1) {
		botonContratar.addActionListener(a1);
		botonReservar.addActionListener(a1);
		botonComentar.addActionListener(a1);
		botonValorar.addActionListener(a1);
		botonVolver.addActionListener(a1);
		botonComentarios.addActionListener(a1);
	}

	/**
	 * @return the oPrecio
	 */
	public JLabel getoPrecio() {
		return oPrecio;
	}

	/**
	 * @return the oIni
	 */
	public JLabel getoIni() {
		return oIni;
	}

	/**
	 * @return the oDesc
	 */
	public JLabel getoDesc() {
		return oDesc;
	}

	/**
	 * @return the oDisp
	 */
	public JLabel getoDisp() {
		return oDisp;
	}

	/**
	 * @return the precioTotal
	 */
	public JLabel getPrecioTotal() {
		return precioTotal;
	}

	/**
	 * @return the nmeses
	 */
	public JLabel getNmeses() {
		return nmeses;
	}

	/**
	 * @return the fin
	 */
	public JLabel getFin() {
		return fin;
	}

	/**
	 * @return the fianza
	 */
	public JLabel getFianza() {
		return fianza;
	}

	/**
	 * @return the botonContratar
	 */
	public JButton getBotonContratar() {
		return botonContratar;
	}


	/**
	 * @return the botonReservar
	 */
	public JButton getBotonReservar() {
		return botonReservar;
	}


	/**
	 * @return the botonComentar
	 */
	public JButton getBotonComentar() {
		return botonComentar;
	}

	/**
	 * @return the botonValorar
	 */
	public JButton getBotonValorar() {
		return botonValorar;
	}

	/**
	 * @return the botonVolver
	 */
	public JButton getBotonVolver() {
		return botonVolver;
	}

	/**
	 * @return the oferta
	 */
	public Oferta getOferta() {
		return oferta;
	}

	/**
	 * @param oferta the oferta to set
	 */
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	/**
	 * @return the botonComentarios
	 */
	public JButton getBotonComentarios() {
		return botonComentarios;
	}

}
