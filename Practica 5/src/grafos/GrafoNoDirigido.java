package grafos;

import java.util.*;

public class GrafoNoDirigido<T> extends Grafo<T>{
	
	private HashMap<Set<Vertice<T>>, Double> aristas = new HashMap<>();
	
	public void addArco(Vertice<T>v1, Vertice<T>v2, double peso) {
		Set<Vertice<T>> aux = new TreeSet<>();
		
		if(existeArco(v1,v2) == true) {
			double valor;
			Set<Vertice<T>> tmp = new TreeSet<>();
			
			tmp.add(v1);
			tmp.add(v2);
			
			valor = this.getPesoDe(v1, v2);
			aristas.put(tmp, valor + peso);
		}
		
		aux.add(v1);
		aux.add(v2);
		
		if(aristas.containsKey(aux) == true) {
			return;
		}
		
		aristas.put(aux, peso);
	}

	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		Set<Vertice<T>> aux = new TreeSet<>();
		
		aux.add(v1);
		aux.add(v2);
		
		return aristas.get(aux);
	}

	
	public List<Vertice<T>> getVecinosDe(Vertice<T> v) {
		List<Vertice<T>> vertices = new ArrayList<>();
		
		for(int i = 0; i < this.getVertices().size(); i++) {
			Set<Vertice<T>> tmp = new TreeSet<>();
			
			tmp.add(v);
			tmp.add(this.getVertices().get(i));
			
			if(aristas.containsKey(tmp) == true) {
				vertices.add(this.getVertices().get(i));
			}
		}
		return vertices;
	}
}
