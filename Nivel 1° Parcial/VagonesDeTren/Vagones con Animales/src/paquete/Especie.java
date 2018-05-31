package paquete;

public class Especie {

	private String nombre;
	private int agresividad;
	private int cantidad;
	
	public Especie(String nombre, int agresividad, int cantidad) {
		this.nombre = nombre;
		this.agresividad = agresividad;
		this.cantidad = cantidad;
	}
	
	public int difAgresividad(Especie otra) {
		return this.agresividad > otra.agresividad ? this.agresividad - otra.agresividad : otra.agresividad - this.agresividad;
	}
	
	public int getAgresividad() {
		return this.agresividad;
	}

	@Override
	public String toString() {
		return "Especie [ nombre = " + this.nombre + ", agresividad = " + this.agresividad + ", cantidad = " + this.cantidad + " ]";
	}
	
}
