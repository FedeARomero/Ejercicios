package paquete;

public class Mesada {
	
	private int alto;
	private int ancho;
	private int superficie;
	
	public Mesada(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
		this.superficie = alto * ancho;
	}
	
	public Mesada rotar() {
		int aux = this.alto;
		this.alto = this.ancho;
		this.ancho = aux;
		
		return this;
	}
	
	public boolean puedoApilarSobre(Mesada otra) {
		return this.superficie <= otra.superficie && this.alto <= otra.alto && this.ancho <= otra.ancho;
	}
}
