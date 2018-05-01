package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Grupo {
	private int cantNombres;
	private int cantRepetidos;
	private Map<String, Integer> repeticiones;

	public Grupo(String arch) throws FileNotFoundException {
		Scanner sc = new Scanner( new File(arch) );		//APERTURA DEL ARCHIVO DE ENTRADA
		String[] aux = sc.nextLine().split(" ");		//LA PRIMERA LINEA CONTIENE LA CANTIDAD DE NOMBRES Y LA CANTIDAD DE REPETIDOS QUE SE QUIERE HALLAR
		String nombre;

		cantNombres   = Integer.parseInt(aux[0]);
		cantRepetidos = Integer.parseInt(aux[1]);
		repeticiones = new HashMap<String, Integer>();	//DICCIONARO1 ( KEY: NOMBRE, CLAVE: CANTIDAD DE REPETICIONES )

		//EN EL FOR SE RECORRE EL ARCHIVO Y SE GUARDAN LOS NOMBRES Y LA CANTIDAD DE REPETICIONES DE CADA UNO EN EL DICCIONARIO1
		for (int i = 0; i < cantNombres; i++)
			repeticiones.put( nombre = sc.nextLine(), repeticiones.containsKey(nombre) ? repeticiones.get(nombre) + 1 : 1);
		sc.close();
	}

	public void nombresRepetidos(String arch) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter( new File(arch) );					//APERTURA DEL ARCHIVO DE SALIDA

		//DICICONARIO2 ( KEY: CANT DE REPETICIONES, CLAVE: NOMBRE ) CON KEY ORDENADAS DE MAYOR A MENOR
		SortedMap<Integer, String> cantRepeticiones = new TreeMap<Integer, String>(java.util.Collections.reverseOrder());  
		Iterator<String> iterador1 = repeticiones.keySet().iterator();		//ITERADOR DEL DICCIONARIO1

		//EN EL WHILE SE ITERA EL DICCIONARIO1 Y SE GUARDAN EN EL DICCIONARIO2 LOS NOMBRES CON MAS DE 1 REPETICION (KEY)
		while (iterador1.hasNext()) {
			String key = (String) iterador1.next();
			if (repeticiones.get(key) > 1)
				cantRepeticiones.put(repeticiones.get(key), key);
		}

		if (cantRepeticiones.size() > 0) {//SI EL DICCIONARIO2 NO ESTA VACIO...
			Iterator<Integer> iterador2 = cantRepeticiones.keySet().iterator();	//ITERADOR DEL DICCIONARIO2
			//EN EL FOR SE GRABAN EN EL ARCHIVO DE SALIDA LOS NOMBRES Y SUS REPETICIONES
			for (int n = 0; n < cantRepetidos && iterador2.hasNext(); n++) {
				int key = iterador2.next();
				pw.println(cantRepeticiones.get(key) + " " + key);
			}
		}

		pw.close();
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

	}
}
