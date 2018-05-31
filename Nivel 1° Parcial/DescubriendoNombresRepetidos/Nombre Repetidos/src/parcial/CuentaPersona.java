package parcial;

public class CuentaPersona {

	private String nombre;
	private Integer cant;
	
	CuentaPersona(String key, Integer c) {
		this.nombre = key;
		this.cant = c;
	}
	
	public Integer getCant() {
		return this.cant;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
}
