package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Concurso {

	private int carretel;
	private Escuela[] escuelas;

	public Concurso(String entrada) throws FileNotFoundException {

		Scanner in = new Scanner(new File(entrada));

		this.carretel = in.nextInt();
		this.escuelas = new Escuela[in.nextInt()];
		for (int i = 0; i < escuelas.length; i++) {
			int retazo = in.nextInt();
			this.carretel -= retazo;
			escuelas[i] = new Escuela(i + 1, retazo);
		}
		in.close();
	}

	public void resolver(String salida) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(salida));
		int escuelaConMayorBandera = 0;
		int banderaMasGrande = 0;
		int maximasCosturas = 0;
		boolean corteRetazo;
		do {
			corteRetazo = false;
			for (int i = 0; i < escuelas.length; i++) {
				if (escuelas[i].retazoEsperado() <= this.carretel) {
					this.carretel = this.carretel - escuelas[i].retazoEsperado();
					escuelas[i].darRetazo();
					corteRetazo = true;
				}
			}
		} while (corteRetazo);

		for (int i = 0; i < escuelas.length; i++) {
//			System.out.println(escuelas[i]);
			maximasCosturas = Math.max(maximasCosturas, escuelas[i].catidadDeCosturas());
			banderaMasGrande = Math.max(banderaMasGrande, escuelas[i].largoDeLaBandera());
			escuelaConMayorBandera = banderaMasGrande == escuelas[i].largoDeLaBandera() ? i + 1
					: escuelaConMayorBandera;
		}
		// System.out.println(escuelaConMayorBandera + " " + banderaMasGrande);
		// System.out.println(maximasCosturas);
		// System.out.println(this.carretel);
		out.println(escuelaConMayorBandera + " " + banderaMasGrande);
		out.println(maximasCosturas);
		out.println(this.carretel);
		out.close();
	}

	public void subSecuencia() {
		int[][] secuencias = new int[this.escuelas.length][];

		int escuela1 = 0, escuela2 = 0;
		int maxSecuencia = 0;
		
		for (int i = 0; i < secuencias.length; i++) {
			secuencias[i] = escuelas[i].secuencia();
//			System.out.println(Arrays.toString(secuencias[i]));
		}

		for (int i = 0; i < secuencias.length; i++) {
			int inicial = secuencias[i][0];
//			System.out.println(inicial);
			for (int j = 0; j < secuencias.length; j++) {
				if (j != i) {
					for (int k = 1; k < secuencias[j].length; k++) {
						if( inicial < secuencias[j][k] )
							break;
//						System.out.println("Comparo " + inicial + " con " + secuencias[j][k]);
						if(inicial == secuencias[j][k]) {
							System.out.println("Encontre "  + inicial + " es " + " [" + (i+1) + "]["+ 1 + "] y [" + (j+1) + "][" + (k+1) + "]");
							System.out.println("Largo de la subsecuencia " + (secuencias[j].length - k));
							maxSecuencia = Math.max(maxSecuencia, secuencias[j].length - k);
							escuela1 = maxSecuencia == (secuencias[j].length - k) ? i + 1 : escuela1;
							escuela2 = maxSecuencia == (secuencias[j].length - k) ? j + 1 : escuela2;
							
						}
//						System.out.print(secuencias[j][k] + " ");
					}
//					System.out.println();
				}
			}
//			System.out.println();
		}
		System.out.println();
		System.out.println("Largo de la subsecuencia maxima " + maxSecuencia);
		System.out.println("Escuela1: " + escuela1);
		System.out.println("Escuela2: " + escuela2);
	}
}
