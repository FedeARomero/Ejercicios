package paquete;

public class Pruebas {

	public static void main(String[] args) {

		
		Retazo retazo = new Retazo(25);
		
		System.out.println(retazo);
		System.out.println(retazo.retazoEsperado());
		
		Escuela escuela = new Escuela(1, 17);
		
		System.out.println(escuela);
		System.out.println(escuela.retazoEsperado());
		
		escuela.darRetazo();
		
		System.out.println(escuela);
		System.out.println(escuela.retazoEsperado());
		System.out.println(escuela.catidadDeCosturas());
		System.out.println(escuela.largoDeLaBandera());
	}

}
