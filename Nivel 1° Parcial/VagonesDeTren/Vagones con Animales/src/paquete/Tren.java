package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Tren {

	private int agresividad;
	private int agresividadPermisible;
	private Map<Integer, Especie> especies;
	private ArrayList<Vagon> vagones;
	
	public Tren(String entrada) throws FileNotFoundException {
		Scanner in = new Scanner(new File(entrada));
		especies = new TreeMap<Integer,Especie>();
		vagones = new ArrayList<>();
		
		String[] aux = in.nextLine().split(" ");
		int cantidadEspecies = Integer.parseInt(aux[0]);
		this.agresividadPermisible = Integer.parseInt(aux[1]);
		
		for( int i = 0 ; i < cantidadEspecies ; i++ ) {
			Especie especie = new Especie(in.next(), in.nextInt(), in.nextInt());
			this.especies.put(especie.getAgresividad(), especie);
		}
		
		in.close();
	}
	
	public void cargarVagones(String salida) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(salida));
		
		Integer[] claves = especies.keySet().toArray(new Integer[especies.keySet().size()]);
		int i = 0;

		while( !especies.isEmpty() ) {
			Especie especie = especies.remove(claves[i]);
			Vagon vagon = new Vagon();
			vagon.agregarEspecie(especie);
			
			while( !especies.isEmpty() && especie.difAgresividad( especies.get(claves[++i]) ) < this.agresividadPermisible )
				vagon.agregarEspecie( especies.remove(claves[i]) );
			
			this.agresividad += vagon.calcularAgresividad();
			vagones.add(vagon);
		}
		
		out.println(vagones.size() + " " + this.agresividad);
		out.close();
	}
	
	public static void main(String args[]) {
		Tren t;
		try {
			t = new Tren("vagones.in");
			t.cargarVagones("vagones.out");
			System.out.println("Fin del procesamiento");
		} catch (IOException  evento) {
			System.out.println(evento.getMessage());
			evento.printStackTrace();
		}
	}
}
