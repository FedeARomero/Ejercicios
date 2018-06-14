package paquete;

public class Competidor {

	private int numero;
	private Sexo sexo;
	private int edad;
	private int categoria;
	private int ordenDeLlegada;
	
	public Competidor(int n,int edad, char s) {
		this.numero = n;
		this.edad = edad;
		this.sexo = s == 'F' ? Sexo.FEMENINO : Sexo.MASCULIMO;
		this.ordenDeLlegada = Integer.MAX_VALUE;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public int getOrden() {
		return this.ordenDeLlegada;
	}
	
	public void setOrden(int orden) {
		this.ordenDeLlegada = orden;
	}
	
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Competidor [numero = " + numero + ", edad = " + edad + " años, sexo = " + sexo + ", categoria = " + categoria
				+ ", ordenDeLlegada = " + ordenDeLlegada + "°]";
	}
}
