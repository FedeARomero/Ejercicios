package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Empresa {

	private Colaborador[] colaboradores;
	private Equipo equipoConMayorAfinidad;
	private int[][] respuestasIguales;

	public Empresa(String entrada) throws FileNotFoundException {
		Scanner in = new Scanner(new File(entrada));

		in.nextInt();
		colaboradores = new Colaborador[in.nextInt()];
		in.nextLine();

		for (int i = 0; i < colaboradores.length; i++) {
			colaboradores[i] = new Colaborador(i, in.nextLine());
//			 System.out.println(colaboradores[i]);
		}
		cargarMatrizDeRespuestas();
		in.close();
	}
	
	void cargarMatrizDeRespuestas() {
		this.respuestasIguales = new int[colaboradores.length][colaboradores.length];
		
		for (int i = 0; i < respuestasIguales.length; i++) {
			for (int j = 0; j < respuestasIguales.length; j++) {
				Colaborador[] par = {colaboradores[i],colaboradores[j]};
				respuestasIguales[i][j] = par[0].respuestasIguales(par[1]);
			}
		}
	}

	public void definirEquipos(String salida) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(salida));
		int afinidadMaxima = 0;
		
		for(int i = 0 ; i < this.colaboradores.length -1; i++ ) {
			Equipo equipo = new Equipo();
			int maximo = 0;
			
			for(int j = i+1 ; j < this.colaboradores.length ; j++)
				if( this.respuestasIguales[i][j] > maximo )
					maximo = this.respuestasIguales[i][j];
			
			for(int j = i+1 ; j < this.colaboradores.length ; j++)
				if( this.respuestasIguales[i][j] == maximo )
					equipo.agregarIntegrante(this.colaboradores[j]);
			
			equipo.agregarIntegrante(this.colaboradores[i]);
			
			if( equipo.afinidad() > afinidadMaxima ) {
				this.equipoConMayorAfinidad = equipo.cloanr();
				afinidadMaxima = this.equipoConMayorAfinidad.afinidad();
			}
		}
		
		System.out.println(this.equipoConMayorAfinidad);
		out.println(this.equipoConMayorAfinidad.afinidad());
		out.println(this.equipoConMayorAfinidad.respuestasIguales());
		
		out.close();
	}

	public static void main(String[] args) {
		try {
			Empresa e = new Empresa("equipo.in");
			e.definirEquipos("equipo.out");
		} catch (IOException evento) {
			System.out.println(evento.getMessage());
			evento.printStackTrace();
		}
	}

}
