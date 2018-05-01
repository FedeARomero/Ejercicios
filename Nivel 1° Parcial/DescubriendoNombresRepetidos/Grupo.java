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
	private String[] nombres;
	private int nomrepetidos;
	private Map<String, Integer> repeticiones;

	public Grupo(String arch) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(arch));
		String[] aux = sc.nextLine().split(" ");
		nombres = new String[Integer.parseInt(aux[0])];
		nomrepetidos = Integer.parseInt(aux[1]);
		for (int i = 0; i < nombres.length; i++)
			nombres[i] = sc.nextLine();
		sc.close();
	}

	public void nombresRepetidos(String arch) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(arch));

		repeticiones = new HashMap<String, Integer>();

		for (int i = 0; i < nombres.length; i++)
			repeticiones.put(nombres[i], repeticiones.containsKey(nombres[i]) ? repeticiones.get(nombres[i]) + 1 : 1);

		SortedMap<Integer, String> nrepeticiones = new TreeMap<Integer, String>(java.util.Collections.reverseOrder());
		Iterator<String> iterador1 = repeticiones.keySet().iterator();
		
		while (iterador1.hasNext()) {
			String key = (String) iterador1.next();
			if (repeticiones.get(key) > 1)
				nrepeticiones.put(repeticiones.get(key), key);
		}

		if (nrepeticiones.size() > 0) {
			Iterator<Integer> iterador2 = nrepeticiones.keySet().iterator();
			for (int n = 0; n < nomrepetidos && iterador2.hasNext(); n++) {
				int key = iterador2.next();
				System.out.println(nrepeticiones.get(key) + " " + key);
				pw.println(nrepeticiones.get(key) + " " + key);
			}
		}

		pw.close();
	}

	public static void main(String[] args) throws FileNotFoundException {

		Grupo exploradores = new Grupo("nombres.in");
		exploradores.nombresRepetidos("nombres.out");
	}
}
