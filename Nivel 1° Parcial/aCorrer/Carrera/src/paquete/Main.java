package paquete;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			Carrera carrera = new Carrera("carrera1.in");
			carrera.resolver("carrera.out");
		} catch (IOException evento) {
			System.out.println(evento.getMessage());
			evento.printStackTrace();
		}
	}
}
