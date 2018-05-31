package paquete;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Grupo {
	private int cantNombres;
	private int cantRepetidos;
	private Map<String, Integer> repeticiones;

	public Grupo(String arch) throws FileNotFoundException {
		Scanner sc = new Scanner( new File(arch) );
		String[] aux = sc.nextLine().split(" ");
		String nombre;

		this.cantNombres   = Integer.parseInt(aux[0]);
		this.cantRepetidos = Integer.parseInt(aux[1]);
		this.repeticiones = new HashMap<String, Integer>();

		for (int i = 0; i < this.cantNombres; i++)
			this.repeticiones.put( nombre = sc.nextLine(), this.repeticiones.containsKey(nombre) ? this.repeticiones.get(nombre) + 1 : 1);
		sc.close();
	}

	public void nombresRepetidos(String arch) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter( new File(arch) );

		SortedMap<Integer, String> nrepeticiones = new TreeMap<Integer, String>(java.util.Collections.reverseOrder());  

		for (String key : this.repeticiones.keySet())
			if (this.repeticiones.get(key) > 1)
				nrepeticiones.put(this.repeticiones.get(key), key);

		if (nrepeticiones.size() > 0)
			for (int key : nrepeticiones.keySet())
				if( 0 < this.cantRepetidos-- )
					pw.println(nrepeticiones.get(key) + " " + key);
				else 
					break;

		this.repeticiones.clear();
		nrepeticiones.clear();
		pw.close();
	}
	
	public static int f(int i) {
		return i+1;
	}

	public static void main(String[] args) {

		Grupo exploradores;
		try {
			exploradores = new Grupo("nombres.in");
			exploradores.nombresRepetidos("nombres.out");
			System.out.println("Fin del procesamiento");
		} catch (FileNotFoundException evento) {
			System.out.println(evento.getMessage());
			evento.printStackTrace();
		}
		
//		int sum = 0, i;
//		for (i = 1; i < 893; sum += f(i++)) {
//			System.out.println("Nombre " + i + " se repite " + f(i) + " veces");
//			
//		}
//		System.out.println("Cant de nombres " + --i);
//		System.out.println("Cant de registros " + sum);

	}
}
