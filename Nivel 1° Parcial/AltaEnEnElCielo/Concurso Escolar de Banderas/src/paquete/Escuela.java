package paquete;

import java.util.ArrayList;

public class Escuela {
	
	private int numero;
	private int bandera;
	private ArrayList<Retazo> retazos;
	
	public Escuela(int n, int r) {
		this.numero = n;
		this.bandera = r;
		this.retazos = new ArrayList<>();
		Retazo retazoInicial = new Retazo(r);
		this.retazos.add(retazoInicial);
	}
	
	public int retazoEsperado() {
		return this.retazos.get(this.retazos.size()-1).retazoEsperado();
	}
	
	public void darRetazo() {
		int retazo = retazoEsperado();
		Retazo nuevo = new Retazo(retazo);
		this.retazos.add(nuevo);
		this.bandera += retazo;
	}
	
	public int catidadDeCosturas() {
		return this.retazos.size() - 1;
	}
	
	public int largoDeLaBandera() {
		return this.bandera;
	}

	@Override
	public String toString() {
		return "Escuela [numero=" + numero + ", bandera=" + bandera + ", retazos=" + retazos + "]";
	}
}
