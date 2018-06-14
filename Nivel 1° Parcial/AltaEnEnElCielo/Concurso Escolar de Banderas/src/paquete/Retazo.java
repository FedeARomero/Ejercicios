package paquete;

public class Retazo {
	
	private int longitud;
	
	public Retazo(int largo) {

		this.longitud = largo;
	}
	
	public int retazoEsperado() {
		String numero = String.valueOf(this.longitud);
		int retazoEsperado = this.longitud;
		for (int i = 0; i < numero.length(); i++) {
			retazoEsperado += Integer.parseInt(String.valueOf(numero.charAt(i)));
		}
		return retazoEsperado;
	}

	@Override
	public boolean equals(Object otro) {
		if (this == otro)
			return true;
		if (otro == null)
			return false;
		if (getClass() != otro.getClass())
			return false;
		Retazo other = (Retazo) otro;
		if (longitud != other.longitud)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Retazo [longitud=" + longitud + "]";
	}
}
