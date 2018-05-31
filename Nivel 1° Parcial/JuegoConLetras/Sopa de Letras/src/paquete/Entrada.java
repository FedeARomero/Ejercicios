package paquete;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Entrada {

	public static void main(String[] args) throws IOException {
		
		PrintWriter entrada = new PrintWriter(new FileWriter("rapigrama.in"));
		
		entrada.print(	"8 4\n"		+
						"xabldfcu\n"+
						"ntcartem\n"+
						"nnnnbbam\n"+
						"fntoiago\n"+
						"viviinic\n"+
						"tvucuebb\n"+
						"nematrec\n"+
						"zlvnybnm\n"+
						"oia\n"		+
						"certamen\n"+
						"nivel\n"	+
						"nacional\n");
		
		entrada.close();
	}

}
