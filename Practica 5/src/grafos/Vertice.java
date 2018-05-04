package grafos;

public class Vertice<T>{
	private final int id;
	private T datos;
	
	public Vertice(int id, T datos) {
		this.id = id;
		this.datos = datos;
	}

	public T getDatos() {
		return datos;
	}

	public void setDatos(T datos) {
		this.datos = datos;
	}

	public int getId() {
		return id;
	}
}
