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

public class VerOfertaPanel extends JPanel{
	
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
	
	private Oferta oferta;
	
	public VerOfertaPanel() {
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		
		JPanel botonera = new JPanel();
		botonera.setLayout(new FlowLayout());
		botonera.add(botonContratar);
		botonera.add(botonComentar);
		botonera.add(botonValorar);
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
	
	public void setControlador(ActionListener a1) {
		botonContratar.addActionListener(a1);
		botonReservar.addActionListener(a1);
		botonComentar.addActionListener(a1);
		botonValorar.addActionListener(a1);
		botonVolver.addActionListener(a1);
	}

	/**
	 * @return the oPrecio
	 */
	public JLabel getoPrecio() {
		return oPrecio;
	}

	/**
	 * @param oPrecio the oPrecio to set
	 */
	public void setoPrecio(JLabel oPrecio) {
		this.oPrecio = oPrecio;
	}

	/**
	 * @return the oIni
	 */
	public JLabel getoIni() {
		return oIni;
	}

	/**
	 * @param oIni the oIni to set
	 */
	public void setoIni(JLabel oIni) {
		this.oIni = oIni;
	}

	/**
	 * @return the oDesc
	 */
	public JLabel getoDesc() {
		return oDesc;
	}

	/**
	 * @param oDesc the oDesc to set
	 */
	public void setoDesc(JLabel oDesc) {
		this.oDesc = oDesc;
	}

	/**
	 * @return the oDisp
	 */
	public JLabel getoDisp() {
		return oDisp;
	}

	/**
	 * @param oDisp the oDisp to set
	 */
	public void setoDisp(JLabel oDisp) {
		this.oDisp = oDisp;
	}

	/**
	 * @return the precioTotal
	 */
	public JLabel getPrecioTotal() {
		return precioTotal;
	}

	/**
	 * @param precioTotal the precioTotal to set
	 */
	public void setPrecioTotal(JLabel precioTotal) {
		this.precioTotal = precioTotal;
	}

	/**
	 * @return the nmeses
	 */
	public JLabel getNmeses() {
		return nmeses;
	}

	/**
	 * @param nmeses the nmeses to set
	 */
	public void setNmeses(JLabel nmeses) {
		this.nmeses = nmeses;
	}

	/**
	 * @return the fin
	 */
	public JLabel getFin() {
		return fin;
	}

	/**
	 * @param fin the fin to set
	 */
	public void setFin(JLabel fin) {
		this.fin = fin;
	}

	/**
	 * @return the fianza
	 */
	public JLabel getFianza() {
		return fianza;
	}

	/**
	 * @param fianza the fianza to set
	 */
	public void setFianza(JLabel fianza) {
		this.fianza = fianza;
	}

	/**
	 * @return the botonContratar
	 */
	public JButton getBotonContratar() {
		return botonContratar;
	}

	/**
	 * @param botonContratar the botonContratar to set
	 */
	public void setBotonContratar(JButton botonContratar) {
		this.botonContratar = botonContratar;
	}

	/**
	 * @return the botonReservar
	 */
	public JButton getBotonReservar() {
		return botonReservar;
	}

	/**
	 * @param botonReservar the botonReservar to set
	 */
	public void setBotonReservar(JButton botonReservar) {
		this.botonReservar = botonReservar;
	}

	/**
	 * @return the botonComentar
	 */
	public JButton getBotonComentar() {
		return botonComentar;
	}

	/**
	 * @param botonComentar the botonComentar to set
	 */
	public void setBotonComentar(JButton botonComentar) {
		this.botonComentar = botonComentar;
	}

	/**
	 * @return the botonValorar
	 */
	public JButton getBotonValorar() {
		return botonValorar;
	}

	/**
	 * @param botonValorar the botonValorar to set
	 */
	public void setBotonValorar(JButton botonValorar) {
		this.botonValorar = botonValorar;
	}

	/**
	 * @return the botonVolver
	 */
	public JButton getBotonVolver() {
		return botonVolver;
	}

	/**
	 * @param botonVolver the botonVolver to set
	 */
	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
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

}
