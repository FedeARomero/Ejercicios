package paquete;

import java.util.ArrayList;

public class Vagon {
	
	private int agresividad;
	private ArrayList<Especie> especies;
	
	public Vagon() {
		especies = new ArrayList<>();
	}
	
	public void agregarEspecie(Especie especie) {
		this.especies.add(especie);
	}
	
	public int calcularAgresividad() {
		int agresividadMaxima = especies.get(0).getAgresividad();
		int agresividadMinima = especies.get(0).getAgresividad();
		
		for( int i = 1 ; i < especies.size() ; i++ ) {
			agresividadMaxima = Math.max(agresividadMaxima, especies.get(i).getAgresividad());
			agresividadMinima = Math.min(agresividadMinima, especies.get(i).getAgresividad());
		}
		
		this.agresividad = agresividadMaxima - agresividadMinima;
		
		return this.agresividad;
	}

	@Override
	public String toString() {
		return "Vagon [ agresividad = " + this.agresividad + ", especies = " + this.especies + " ]";
	}

}
