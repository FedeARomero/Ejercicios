package paquete;

import java.util.Comparator;

public class ComparePais implements Comparator<Pais>{

	@Override
	public int compare(Pais pais1, Pais pais2) {
		// TODO Auto-generated method stub
		return pais1.toString().compareTo(pais2.toString());
	}

}
