package P04_FicherosBytes;

public class MovimientoBancario {
	String fecha;
	String concepto;
	int cantidad;
	boolean tipo;
	
	public MovimientoBancario(String f, String c, int cant, boolean t) {
		fecha=f;
		concepto=c;
		cantidad=cant;
		tipo=t;
	}	
}