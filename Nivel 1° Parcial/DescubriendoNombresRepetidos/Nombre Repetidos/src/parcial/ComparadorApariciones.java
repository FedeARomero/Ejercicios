package parcial;

import java.util.Comparator;

public class ComparadorApariciones implements Comparator <CuentaPersona> {

	@Override
	public int compare(CuentaPersona cp1, CuentaPersona cp2) {
		return cp2.getCant() - cp1.getCant();
	}

}
