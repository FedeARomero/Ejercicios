package paquete;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ContarLatas {

	private int cantLatas;
	private int secuenciaMax1;
	private int secuenciaMax2;
	private int distancia;

	public void resolver(String entrada, String salida) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(salida));
		Scanner in = new Scanner(new File(entrada));
		String[] etiquetas = in.nextLine().split(" ");
		int finSecuenciaMax1 = 0;
		int finSecuenciaMax2 = 0;
		int i = 0;
		int cantG;
		while (!etiquetas[i].equals("F")) {
			for (cantG = 0; !etiquetas[i].equals("F") && etiquetas[i].equals("G"); cantG++, i++) ;
			if (cantG > this.secuenciaMax1) {
				this.secuenciaMax2 = this.secuenciaMax1;
				this.secuenciaMax1 = cantG;
				finSecuenciaMax2 = finSecuenciaMax1;
				finSecuenciaMax1 = i - 1;
			} else if (cantG > this.secuenciaMax2) {
				this.secuenciaMax2 = cantG;
				finSecuenciaMax2 = i - 1;
			}
			for (; !etiquetas[i].equals("F") && !etiquetas[i].equals("G"); i++) ;
		}
		this.cantLatas = etiquetas.length;
		if (this.secuenciaMax2 != 0) {
				this.distancia = finSecuenciaMax1 < finSecuenciaMax2 ? finSecuenciaMax2 - this.secuenciaMax2 - finSecuenciaMax1 : finSecuenciaMax1 - this.secuenciaMax1 - finSecuenciaMax2;
		}
		out.println("Cantidad de la hilera: " + this.cantLatas);
		out.println("Numero de latas bien etiquetadas de la primera secuencia mas larga: " + this.secuenciaMax1);
		out.println("Numero de latas bien etiquetadas de la segunda secuencia mas larga: " + this.secuenciaMax2);
		out.println("Distancia entre ambas secuencias: " + this.distancia);
		out.close();
		in.close();
	}

	public static void main(String[] args) {

		try {
			new ContarLatas().resolver("latas.in","latas.out");
		} catch (IOException evento) {
			System.out.println(evento.getMessage());
			evento.printStackTrace();
		}

	}

}
