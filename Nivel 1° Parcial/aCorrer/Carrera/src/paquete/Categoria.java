package paquete;

import java.util.ArrayList;

public class Categoria {
	
	private int edadInferior;
	private int edadSuperior;
	private ArrayList<Competidor> competidores;
	
	public Categoria( int eInf, int eSup) {
		this.edadInferior = eInf;
		this.edadSuperior = eSup;
		this.competidores = new ArrayList<>();
	}
	
	public boolean agregar(int edad, Competidor competidor) {
		boolean consulto = this.edadInferior <= edad && edad <= this.edadSuperior;
		if( consulto )
			this.competidores.add(competidor);
		return consulto;
	}

	public void ordenar() {
		if( this.competidores.size() > 1 )
			this.competidores.sort(new CompararCompetidor());
	}
	
	public int[] getPodio() {
		ordenar();
		int[] podio = new int[3];
		
		if( this.competidores.size() > 0 && this.competidores.get(0).getOrden() != Integer.MAX_VALUE) podio[0] = this.competidores.get(0).getNumero();
		if( this.competidores.size() > 1 && this.competidores.get(1).getOrden() != Integer.MAX_VALUE) podio[1] = this.competidores.get(1).getNumero();
		if( this.competidores.size() > 2 && this.competidores.get(2).getOrden() != Integer.MAX_VALUE) podio[2] = this.competidores.get(2).getNumero();
		
		return podio;
	}
}
