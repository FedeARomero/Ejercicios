package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Carrera {

	private Competidor[] participantes;
	private Categoria[] categoriasFemeninas;
	private Categoria[] categoriasMasculinas;

	public Carrera(String entrada) throws FileNotFoundException {
		Scanner in = new Scanner(new File(entrada));

		participantes = new Competidor[in.nextInt()];
		categoriasFemeninas = new Categoria[in.nextInt()];
		categoriasMasculinas = new Categoria[in.nextInt()];
		int llegaron = in.nextInt();

		for (int i = 0; i < categoriasFemeninas.length; i++) {
			categoriasFemeninas[i] = new Categoria(in.nextInt(), in.nextInt());
		}

		for (int i = 0; i < categoriasMasculinas.length; i++) {
			categoriasMasculinas[i] = new Categoria(in.nextInt(), in.nextInt());
		}
		in.nextLine();
		for (int i = 0; i < participantes.length; i++) {
			String[] linea = in.nextLine().split(" ");
			int edad = Integer.parseInt(linea[0]);
			char sexo = linea[1].charAt(0);
			participantes[i] = new Competidor(i + 1, edad, sexo);

			if (sexo == 'F') {
				for (int j = 0; j < categoriasFemeninas.length; j++)
					if (categoriasFemeninas[j].agregar(edad, participantes[i])) {
						participantes[i].setCategoria(j + 1);
						break;
					}
			} else if (sexo == 'M') {
				for (int j = 0; j < categoriasMasculinas.length; j++)
					if (categoriasMasculinas[j].agregar(edad, participantes[i])) {
						participantes[i].setCategoria(j + 1);
						break;
					}
			}

		}

		for (int i = 0; i < llegaron; i++) {
			participantes[in.nextInt() - 1].setOrden(i + 1);
		}

//		for (int i = 0; i < participantes.length; i++) {
//			System.out.println(participantes[i]);
//
//		}
		in.close();
	}
	
	public void resolver(String salida) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(salida));
		
		for (int i = 0; i < categoriasFemeninas.length; i++) {
			int[] podio = categoriasFemeninas[i].getPodio();
//			System.out.println((i+1) + " " + podio[0] + " " + podio[1] + " " + podio[2]);
			out.println((i+1) + " " + podio[0] + " " + podio[1] + " " + podio[2]);
		}
		
		for (int i = 0; i < categoriasMasculinas.length; i++) {
			int[] podio = categoriasMasculinas[i].getPodio();
//			System.out.println((i+1) + " " + podio[0] + " " + podio[1] + " " + podio[2]);
			out.println((i+1) + " " + podio[0] + " " + podio[1] + " " + podio[2]);
		}
		
		out.close();
	}

}
