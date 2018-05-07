package modeloslista;

import java.util.List;

import javax.swing.AbstractListModel;


import ofertas.*;

public class OferListModel extends AbstractListModel<Oferta>{
	private static final long serialVersionUID = 1L;
	
	private List<Oferta> lista;
	
	public OferListModel(List<Oferta> lista) {
		this.lista = lista;
	}
	
	@Override
	public Oferta getElementAt(int index) {
		Oferta o = lista.get(index);
		return o;
	}

	@Override
	public int getSize() {
		return lista.size();
	}
	
	public void addOferta(Oferta o){
		  lista.add(o);
		  this.fireIntervalAdded(this, getSize(), getSize()+1);
	}
	
	public void eliminarOferta(int index){
		   lista.remove(index);
		   this.fireIntervalRemoved(index, getSize(), getSize()+1);
	}
	
	public Oferta getInmueble(int index){
		  return lista.get(index);
	}
}

