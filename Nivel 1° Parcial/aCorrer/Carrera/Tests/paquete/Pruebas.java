package paquete;

import java.io.IOException;

import org.junit.Test;

public class Pruebas {

	@Test
	public void Test() {
		
		try {
			Carrera carrera = new Carrera("carrera.in");
			carrera.resolver("carrera.out");
			System.out.println("Fin del procesamiento");
		} catch (IOException evento) {
			System.out.println(evento.getMessage());
//			evento.printStackTrace();
		}
	}

}
