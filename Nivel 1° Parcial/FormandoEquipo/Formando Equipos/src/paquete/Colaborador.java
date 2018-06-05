package paquete;

public class Colaborador {
	
	private int identidicador;
	private String respuestas;
	
	public Colaborador(int numero, String respuestas) {
		this.identidicador = numero;
		this.respuestas = respuestas;
	}
	
	public int respuestasIguales(Colaborador otro) {
		int cantidad = 0;
		
		if( this.equals(otro) )
			return cantidad;
		
		int cantidadRespuestas = Math.min(this.respuestas.length(), otro.respuestas.length());
		
		for (int i = 0; i < cantidadRespuestas ; i++)
			if( this.respuestas.charAt(i) == otro.respuestas.charAt(i) )
				cantidad++;
			else
				break;
		
		return cantidad;
	}
	
	public String respuestas() {
		return String.valueOf(this.respuestas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Colaborador otro = (Colaborador) obj;
		
		if (this.identidicador != otro.identidicador) return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Colaborador " + this.identidicador + " [" + this.respuestas + "]";
	}

	public static void main(String[] args) {

		Colaborador c1 = new Colaborador(0, "aacd");
		Colaborador c2 = new Colaborador(1, "aadd");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1.respuestasIguales(c2));
	}

}
