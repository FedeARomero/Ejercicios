package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Tablero {

	private Palabra[] palabras;
	private String[] tablero;

	public Tablero(String entrada) throws FileNotFoundException {
		Scanner in = new Scanner(new File(entrada));
		tablero = new String[in.nextInt()];
		palabras = new Palabra[in.nextInt()];
		in.nextLine();

		for (int i = 0; i < tablero.length; i++)
			tablero[i] = in.nextLine();

		for (int i = 0; i < palabras.length; i++)
			palabras[i] = new Palabra(in.nextLine());

		in.close();
	}

	public void buscarPalabras(String salida) throws IOException {

		PrintWriter out = new PrintWriter(new FileWriter(salida));

		for (int i = 0; i < tablero.length; i++) {

			String horizontalEste = new String();
			String horizontalOeste = new String();
			String verticalSur = new String();
			String verticalNorte = new String();

			for (int j = 0; j < tablero.length; j++) {
				horizontalEste += tablero[i].charAt(j);
				horizontalOeste += tablero[i].charAt(tablero.length - j - 1);
				verticalSur += tablero[j].charAt(i);
				verticalNorte += tablero[tablero.length - j - 1].charAt(i);
			}

			for (int j = 0; j < palabras.length; j++) {
				if (palabras[j].buscar(horizontalEste))
					out.println((j + 1) + " E");
				else if (palabras[j].buscar(horizontalOeste))
					out.println((j + 1) + " O");
				else if (palabras[j].buscar(verticalNorte))
					out.println((j + 1) + " N");
				else if (palabras[j].buscar(verticalSur))
					out.println((j + 1) + " S");
			}
		}

		out.close();
	}

	public static void main(String[] args) {

		Tablero t;
		try {
			t = new Tablero("rapigrama.in");
			t.buscarPalabras("rapigrama.out");
			System.out.println("Fin del procesamiento");
		} catch (IOException evento) {
			System.out.println(evento.getMessage());
			evento.printStackTrace();
		}

	}

}
