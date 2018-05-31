package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class NegocioDeMesadas {
	
	private ArrayList<Mesada> mesadas;
	private ArrayList<PilaDeMesadas> pilas;
	
	public NegocioDeMesadas(String entrada) throws FileNotFoundException {
		mesadas = new ArrayList<Mesada>();
		pilas = new ArrayList<PilaDeMesadas>();
		Scanner in = new Scanner(new File(entrada));
		int cantidadMesadas = in.nextInt();
		
		for (int i = 0 ; i < cantidadMesadas; i++)
			mesadas.add(new Mesada(in.nextInt(), in.nextInt()));

		in.close();
	}
	
	public void formarPilas(String salida) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(salida));
		
		while( !mesadas.isEmpty() ) {
			Mesada abajo = mesadas.remove(0);
			PilaDeMesadas pila = new PilaDeMesadas();
			int i = 0;
			
			while(!mesadas.isEmpty() && i < mesadas.size())
				if( mesadas.get(i).puedoApilarSobre(abajo) || mesadas.get(i).rotar().puedoApilarSobre(abajo)) {
					pila.apliar(mesadas.remove(i));
					i = 0;
				}
				else if( abajo.puedoApilarSobre(mesadas.get(i)) || abajo.rotar().puedoApilarSobre(mesadas.get(i)) ) {
					pila.apliar(abajo);
					abajo = mesadas.remove(i);
					i = 0;
				}
				else
					i++;	
			
			pila.apliar(abajo);
			pilas.add(pila);
		}
		out.print(pilas.size());
		out.close();
	}

	public static void main(String[] args) {
	
		try {
			NegocioDeMesadas n = new NegocioDeMesadas("mesadas.in");
			n.formarPilas("mesadas.out");
			System.out.println("Fin del procesamiento");
		} catch (IOException evento) {
			System.out.println(evento.getMessage());
			evento.printStackTrace();
		}

	}

}
