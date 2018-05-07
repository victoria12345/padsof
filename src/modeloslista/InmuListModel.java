package modeloslista;

import java.util.List;

import javax.swing.AbstractListModel;

import inmuebles.Inmueble;


public class InmuListModel extends AbstractListModel<Inmueble>{
	private static final long serialVersionUID = 1L;
	
	private List<Inmueble> lista;
	
	public InmuListModel(List<Inmueble> lista) {
		this.lista = lista;
	}
	
	@Override
	public Inmueble getElementAt(int index) {
		Inmueble i = lista.get(index);
		return i;
	}

	@Override
	public int getSize() {
		return lista.size();
	}
	
	public void addInmueble(Inmueble i){
		  lista.add(i);
		  this.fireIntervalAdded(this, getSize(), getSize()+1);
	}
	
	public void eliminarInmueble(int index){
		   lista.remove(index);
		   this.fireIntervalRemoved(index, getSize(), getSize()+1);
	}
	
	public Inmueble getInmueble(int index){
		  return lista.get(index);
	}
}
