package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Imagenes {
	
	private String comprimida;
	private String descomprimida;
	
	public Imagenes(String entrada) throws FileNotFoundException {
		Scanner in = new Scanner(new File(entrada));
		this.descomprimida = in.nextLine();
		this.comprimida = in.nextLine();
		in.close();
	}

	public void resolver(String salida) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(salida));
		out.println(comprimir(this.descomprimida));
		out.println(descomprimir(this.comprimida));
		out.close();
	}
	
	public String comprimir(String cadena) {
		String aux = "";
		int repeticiones, i = 0;
		char letra;
		while (i < cadena.length()) {
			for (letra = cadena.charAt(i), repeticiones = 1, i++; i < cadena.length() && letra == cadena.charAt(i); repeticiones++, i++);
			if (repeticiones > 4)
				aux += "(" + letra + repeticiones + ")";
			else
				for (int j = 0; j < repeticiones; j++)
					aux += letra;
		}
		return aux;
	}

	public String descomprimir(String cadena) {
		String aux = "";
		int i = 0;

		while (i < cadena.length()) {
			if (i < cadena.length() && cadena.charAt(i) != '(') {
				aux += cadena.charAt(i);
				i++;
			}
			if (i < cadena.length() && cadena.charAt(i) == '(') {
				char letra = cadena.charAt(i + 1);
				int k;
				for (k = i + 3; cadena.charAt(k) != ')'; k++);
				int cant = Integer.parseInt(cadena.substring(i + 2, k));
				for (int j = 0; j < cant; j++)
					aux += letra;
				i = k + 1;
			}
		}
		return aux;
	}

	public static void main(String[] args) {

		Imagenes i;
			try {
				i = new Imagenes("imagenes.in");
				i.resolver("imagenes.out");
				System.out.println("Fin del procesamiento");
			} catch (IOException evento) {
				System.out.println(evento.getMessage());
				evento.printStackTrace();
			}


	}

}
