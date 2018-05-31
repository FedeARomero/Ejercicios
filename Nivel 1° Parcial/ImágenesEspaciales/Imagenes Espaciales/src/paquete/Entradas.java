package paquete;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Entradas {

	public static void main(String[] args) throws IOException {

		PrintWriter salida = new PrintWriter(new FileWriter("imagenes.in"));
		char[] letras = {'B','N','R','V','A'};
		
		for (int i = 0; i < 83; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				salida.println(letras[i%5]);
			}
		}
		salida.close();
	
	}

}
