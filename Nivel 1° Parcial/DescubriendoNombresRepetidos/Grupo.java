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
	private String[] ninios;
	private int nomrepetidos;
	private Map<String, Integer> nrepetidos;

	public Grupo(String arch) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(arch));
		ninios = new String[sc.nextInt()];
		nomrepetidos = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < ninios.length; i++)
			ninios[i] = sc.nextLine();
		sc.close();
	}

	public void nombresRepetidos(String arch) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(arch));

		nrepetidos = new HashMap<String, Integer>();

		for (int i = 0; i < ninios.length; i++)
			nrepetidos.put(ninios[i], nrepetidos.containsKey(ninios[i]) ? nrepetidos.get(ninios[i]) + 1 : 1);

		SortedMap<Integer, String> cantrep = new TreeMap<Integer, String>(java.util.Collections.reverseOrder());

		Iterator<String> iterador1 = nrepetidos.keySet().iterator();
		while (iterador1.hasNext()) {
			String key = (String) iterador1.next();
			if (nrepetidos.get(key) > 1)
				cantrep.put(nrepetidos.get(key), key);
		}

		if (cantrep.size() > 0) {
			Iterator<Integer> iterador2 = cantrep.keySet().iterator();
			for (int n = 0; n < nomrepetidos && iterador2.hasNext(); n++) {
				int key = iterador2.next();
				System.out.println(cantrep.get(key) + " " + key);
				pw.println(cantrep.get(key) + " " + key);
			}
		}

		pw.close();
	}

	public static void main(String[] args) throws FileNotFoundException {

		Grupo exploradores = new Grupo("nombres.in");
		exploradores.nombresRepetidos("nombres.out");
	}
}
