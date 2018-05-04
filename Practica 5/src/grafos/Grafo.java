package grafos;

import java.util.*;

public abstract class Grafo<T> {
	protected int ids = 0;
	private List<Vertice<T>> vertices = new ArrayList<>();
	private HashMap<Set<Vertice<T>>, Double> aristas = new HashMap<>();
	
	public List<Vertice<T>> getVertices() {
		return vertices;
	}
	public int getNumVertices() {
		return vertices.size();
	}

	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);

	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		Set<Vertice<T>> vs = new TreeSet<>();
		
		vs.add(v1);
		vs.add(v2);
		
		if(aristas.containsKey(vs) == true) {
			return true;
		}
		
		return false;
	}
	
	public int getNumArcos() {
		return aristas.size();
	}

	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2) ;
	
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v);
	
	public Vertice<T> addVertice(T datos){
		Vertice<T> v = addVertice(ids, datos);
		
		return v;
	}
	
	protected Vertice<T> addVertice(int id, T datos){
		Vertice<T> v = new Vertice<T>(ids, datos);
		ids++;
		vertices.add(v);
		
		return v;
	}
	
	public String toString() {
		int min = vertices.get(0).getId();
		Vertice<T> aux = null;
		
		List<Vertice<T>> cadena = new ArrayList<>();
		
		while(cadena.size() < vertices.size()) {
			for(int i = 0; i < vertices.size(); i++) {
				if(vertices.get(i).getId() <min && cadena.contains(vertices.get(i)) == false) {
					aux = vertices.get(i);
				}
			}
			cadena.add(aux);
			min++;
		}
		return cadena.toString();
	}
	
}
