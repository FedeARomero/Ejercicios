package paquete;

public class Palabra {
	
	private String palabra;
	private int tamanio;
	
	public Palabra(String palabra) {
		this.palabra = palabra;
		this.tamanio = palabra.length();
	}
	
	public char letraInicial() {
		char[] aux = this.palabra.toCharArray();
		return aux[0];
	}
	
	public char letraFianl() {
		char[] aux = this.palabra.toCharArray();
		return aux[this.palabra.length()-1];
	}
	
	public int getTamanio() {
		return this.tamanio;
	}
	
	public boolean buscar(String palabra) {
		return palabra.contains(this.palabra);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Palabra " + palabra;
	}

}
