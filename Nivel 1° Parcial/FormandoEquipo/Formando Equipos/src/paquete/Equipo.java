package paquete;

import java.util.ArrayList;

public class Equipo {
	
	private ArrayList<Colaborador> integrantes;
	private int respuestasIguales;
	private int afinidad;
	
	public Equipo() {
		this.respuestasIguales = 0;
		this.afinidad = 0;
		this.integrantes = new ArrayList<>();
	}
	
	public void agregarIntegrante(Colaborador integrante) {
		this.integrantes.add(integrante);
	}
	
	public String respuestasIguales() {
		if( this.integrantes.size() > 1 ) {
			Colaborador c1 = this.integrantes.get(0);
			
			return c1.respuestas().substring(0, this.respuestasIguales);
		}
		return "";
	}
	
	public boolean consultarIntegrante(Colaborador integrante) {
		return this.integrantes.contains(integrante);
	}
	
	public int afinidad() {
		if( this.integrantes.size() > 1 ) {
			Colaborador c1 = this.integrantes.get(0);
			Colaborador c2 = this.integrantes.get(1);
			
			this.respuestasIguales = c1.respuestasIguales(c2);
			this.afinidad = this.integrantes.size() * this.respuestasIguales * this.respuestasIguales;
		}
		return this.afinidad;
	}
	
	public Equipo cloanr() {
		Equipo nuevo = new Equipo();
		
		for (int i = 0; i < this.integrantes.size(); i++)
			nuevo.agregarIntegrante(this.integrantes.get(i));
		
		return nuevo;
	}

	@Override
	public String toString() {
		return "Equipo: \tintegrantes = " + this.integrantes + "\n\t\trespuestasIguales = [" + respuestasIguales() + "] \n\t\tafinidad = " + this.afinidad;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
