package paquete;

//import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		try {
			Concurso concurso = new Concurso("bandera.in");
			concurso.resolver("bandera.out");
		} catch (IOException evento) {
			System.out.println(evento.getMessage());
			evento.printStackTrace();
		}
	}

}
