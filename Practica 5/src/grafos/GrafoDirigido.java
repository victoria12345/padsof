package grafos;


import java.util.*;

public class GrafoDirigido<T> extends Grafo<T>{
	private HashMap<List<Vertice<T>>, Double> aristas = new HashMap<>();

	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		List<Vertice<T>> aux = new ArrayList<>();
		
		aux.add(v1);
		aux.add(v2);
		
		if(aristas.containsKey(aux) == true) {
			double valor = aristas.get(aux);
			
			aristas.put(aux, peso+valor);
		}
		aristas.put(aux, peso);
	}

	@Override
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		List<Vertice<T>> aux = new ArrayList<>();
		
		aux.add(v1);
		aux.add(v2);
		
		if(aristas.containsKey(aux) == true) {
			return aristas.get(aux);
		}
		
		return 0;
	}

	@Override
	public List<Vertice<T>> getVecinosDe(Vertice<T> v) {
		List<Vertice<T>> vecinos = new ArrayList<>();
		
		for(int i = 0; i < this.getVertices().size(); i++) {
			List<Vertice<T>> aux = new ArrayList<>();
			
			aux.add(v);
			aux.add(this.getVertices().get(i));
			
			if(aristas.containsKey(aux) == true) {
				vecinos.add(this.getVertices().get(i));
			}
		}
		
		return vecinos;
	}
}
