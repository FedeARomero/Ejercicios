package parcial;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		int top = 0;
		Map<String, Integer> apariciones = new HashMap<String, Integer>();
		List<String> nombres = new ArrayList<String>();
		List<CuentaPersona> entradas = new ArrayList<CuentaPersona>();
		File arch = new File("C:\\Users\\Daniel\\eclipse-workspace\\DescubriendoNombresRepetidos\\nombres.txt");
		
		//Cargo en la lista de Strings los nombres que vienen del archivo
		try {
			Scanner sc = new Scanner(arch);
			String[] aux;

			aux = sc.nextLine().split(" ");
			//Guardo el top que quiero mostrar
			top = Integer.parseInt(aux[1]);
			
			while(sc.hasNextLine()) {
				nombres.add(sc.nextLine());
			}
			
			sc.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		//Voy guardando los nombres y la cantidad en un HashMap. Si no esta, el valor=1, si esta, lo piso con valor=valor+1
		for(String n : nombres) {
			if(!apariciones.containsKey(n)) {
				apariciones.put(n, 1);
			} else {
				apariciones.put(n, apariciones.get(n) + 1);
			}
		}
		
		//Paso el HashMap a una lista de objetos CuentaPersona, para despues ordenarla por valor
		for(Object key : apariciones.keySet()) {
			entradas.add(new CuentaPersona((String)key, apariciones.get(key)));
		}
		//Ordeno la lista
		Collections.sort(entradas, new ComparadorApariciones());		
		//Collections.sort(entradas, (cp1, cp2) -> cp2.getCant().compareTo(cp1.getCant()));
		
		//Muestro el top pedido
		for(int i = 0 ; i < top; i++) {
			CuentaPersona e = entradas.get(i);
			System.out.println(e.getNombre() + " - " + e.getCant());
		}
	}

}
