package paquete;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Entradas {

	public static void main(String[] args) throws IOException {

		PrintWriter salida = new PrintWriter(new FileWriter("latas2.in"));
		char[] etiquetas = { 'A', 'C', 'T' };
		char etiqueta = 'G';
		int[] secuencias = { 5, 4, 2, 1 };
		int k = 0;
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < (int) (Math.random() * 20 + 1); j++) {
				salida.print(etiquetas[(int) (Math.random() * 3)] + " ");
			}
			if (k < secuencias.length) {
				for (int j = 0; j < secuencias[k]; j++) {
					salida.print(etiqueta + " ");
				}
				k++;
			}
		}
		salida.print('F');

		salida.close();
	}

}
