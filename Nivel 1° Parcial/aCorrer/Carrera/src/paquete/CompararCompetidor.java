package paquete;

import java.util.Comparator;

public class CompararCompetidor implements Comparator<Competidor>{

	@Override
	public int compare(Competidor o1, Competidor o2) {
		// TODO Auto-generated method stub
		return o1.ordenDeLlegada()-o2.ordenDeLlegada();
	}

}
