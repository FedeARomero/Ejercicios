package paquete;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Entrdas {

	public static void main(String[] args) throws IOException {

		PrintWriter in = new PrintWriter(new FileWriter("mesadas.in"));
		
		in.print("6\r\n" + 
				"4 5\r\n" + 
				"9 3\r\n" + 
				"2 2\r\n" + 
				"1 2\r\n" + 
				"1 12\r\n" + 
				"2 7");
		
		
		in.close();
	}

}
