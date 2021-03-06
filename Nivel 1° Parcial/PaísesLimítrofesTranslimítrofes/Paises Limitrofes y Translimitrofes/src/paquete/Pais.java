package paquete;

import java.util.TreeSet;

public class Pais {
	
	private String nombre;
	private TreeSet<String> limitrofes;
	
	public Pais(String nombre) {
		this.limitrofes = new TreeSet<String>();
		this.nombre = nombre;
	}
	
	public Pais agregarLimitrofe(Pais limitrofe) {
		this.limitrofes.add(limitrofe.nombre);
		return this;
	}
	
	public boolean limitaCon(Pais otro) {
		return this.limitrofes.contains(otro.nombre);
	}
	
	public int cantidadLimitrofes() {
		return this.limitrofes.size();
	}

	@Override
	public String toString() {
		return this.nombre;
	}

	@Override
	public boolean equals(Object otro) {
		if (this == otro)
			return true;
		if (otro == null)
			return false;
		if (getClass() != otro.getClass())
			return false;
		Pais other = (Pais) otro;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}
