package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
			escuelas[i] = new Escuela(i+1, retazo);
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
				if( escuelas[i].retazoEsperado() <= this.carretel ) {
					this.carretel = this.carretel - escuelas[i].retazoEsperado();
					escuelas[i].darRetazo();
					corteRetazo = true;
				}
			}
		} while (corteRetazo);
		
		for (int i = 0; i < escuelas.length; i++) {
			System.out.println(escuelas[i]);
			maximasCosturas = Math.max(maximasCosturas, escuelas[i].catidadDeCosturas());
			banderaMasGrande = Math.max(banderaMasGrande, escuelas[i].largoDeLaBandera());
			escuelaConMayorBandera = banderaMasGrande == escuelas[i].largoDeLaBandera() ? i+1 : escuelaConMayorBandera;
		}
//		System.out.println(escuelaConMayorBandera + " " + banderaMasGrande);
//		System.out.println(maximasCosturas);
//		System.out.println(this.carretel);
		out.println(escuelaConMayorBandera + " " + banderaMasGrande);
		out.println(maximasCosturas);
		out.println(this.carretel);
		out.close();
	}
}
