package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Limitrofes {

	private ArrayList<Pais> paises = new ArrayList<Pais>();
	private ArrayList<String> tranlimitrofes = new ArrayList<>();

	public Limitrofes(String entrada) throws FileNotFoundException {
		Scanner in = new Scanner(new File(entrada));
		
		int cantidad = in.nextInt();
		in.nextLine();

		for (int i = 0; i < cantidad; i++) {
			Pais pais = new Pais(in.next());
			Pais limitrofe = new Pais(in.next());

			if (paises.contains(pais))
				paises.get(paises.indexOf(pais)).agregarLimitrofe(limitrofe);
			else 
				paises.add(pais.agregarLimitrofe(limitrofe));

			if (paises.contains(limitrofe))
				paises.get(paises.indexOf(limitrofe)).agregarLimitrofe(pais);
			else
				paises.add(limitrofe.agregarLimitrofe(pais));
		}
		paises.sort(new ComparePais());

		in.close();
	}

	public void translimitrofes(String salida) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(salida));
		
		for (Pais paisX : paises) {
			out.println(paisX + " " + paisX.cantidadLimitrofes());
			for (Pais paisY : paises)
				if (!paisX.equals(paisY))
					for (Pais paisZ : paises)
						if (!paisY.equals(paisZ) && !paisX.equals(paisZ) && paisX.limitaCon(paisY) && paisY.limitaCon(paisZ) && !paisX.limitaCon(paisZ)) {
							String cadena = paisX + " " + paisZ;
							String invertida = paisZ + " " + paisX;
							if (!this.tranlimitrofes.contains(cadena) && !this.tranlimitrofes.contains(invertida))
								this.tranlimitrofes.add(cadena);
						}
		}

		if (this.tranlimitrofes.size() > 0)
			for (String string : tranlimitrofes)
				out.println(string);
		else
			out.println("No hay paises translimitrofes");
		
		out.close();
	}

	public static void main(String[] args) {

		Limitrofes l;
		try {
			l = new Limitrofes("paises.in");
			l.translimitrofes("paises.out");
			System.out.println("Fin del procesamiento");
		} catch (IOException evento) {
			System.out.println(evento.getMessage());
			evento.printStackTrace();
		}
	}

}
