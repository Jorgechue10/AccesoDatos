package P04_FicherosBytes;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MovimientoBancario_lectura {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		File f = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P04_FicherosBytes\\Ficheros\\movimientosBancarios.dat");
		
		FileInputStream filein = new FileInputStream(f);
		ObjectInputStream objectin = new ObjectInputStream(filein);
		
		MovimientoBancario m;
		int cantidad_total=0;
		
		try {
			while(true){
					m=(MovimientoBancario)objectin.readObject();
					System.out.println("Fehca: "+m.getFecha()+", Concepto: "+m.getConcepto()+", Cantidad: "+m.getCantidad()+", Tipo: "+m.getTipo());
					
					if(m.getTipo()) {
						cantidad_total = cantidad_total + m.getCantidad();
					}else {
						cantidad_total = cantidad_total - m.getCantidad();
					}
			}
		}catch (EOFException eo) {
			System.out.println("");
		}
		System.out.println("La cantidad total es: "+cantidad_total);
	}
}