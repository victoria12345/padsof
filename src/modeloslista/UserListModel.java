package modeloslista;

import java.util.List;

import javax.swing.AbstractListModel;

import usuarios.Usuario;

public class UserListModel extends AbstractListModel<Usuario>{
	private static final long serialVersionUID = 1L;
	
	private List<Usuario> lista;
	
	public UserListModel(List<Usuario> lista) {
		this.lista = lista;
	}
	
	@Override
	public Usuario getElementAt(int index) {
		Usuario u = lista.get(index);
		return u;
	}

	@Override
	public int getSize() {
		return lista.size();
	}
	
	public void addUsuario(Usuario u){
		  lista.add(u);
		  this.fireIntervalAdded(this, getSize(), getSize()+1);
	}
	
	public void eliminarUsuario(int index){
		   lista.remove(index);
		   this.fireIntervalRemoved(index, getSize(), getSize()+1);
	}
	
	public Usuario getUsuario(int index){
		  return lista.get(index);
	}

}
