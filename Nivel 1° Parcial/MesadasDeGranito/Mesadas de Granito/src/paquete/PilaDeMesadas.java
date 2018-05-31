package paquete;

import java.util.ArrayList;

public class PilaDeMesadas {
	
	private ArrayList<Mesada> mesadas;
	
	public PilaDeMesadas() {
		mesadas = new ArrayList<Mesada>();
	}
	
	public void apliar(Mesada mesada) {
		mesadas.add(mesada);
	}
}
