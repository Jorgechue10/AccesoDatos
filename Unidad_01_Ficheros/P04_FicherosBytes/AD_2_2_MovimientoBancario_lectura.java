/*Clase que lee los movimientos bancarios de una cuenta corriente*/

package P04_FicherosBytes;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AD_2_2_MovimientoBancario_lectura {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		File f = new File("Unidad_01_Ficheros\\P04_FicherosBytes\\Ficheros\\movimientosBancarios.dat");
		
		FileInputStream filein = new FileInputStream(f);
		ObjectInputStream objectin = new ObjectInputStream(filein);
		
		AD_2_0_MovimientoBancario m;
		int cantidad_total=0;
		int i = 1;
		
		try {
			while(true){
					m=(AD_2_0_MovimientoBancario)objectin.readObject();
					System.out.println("Movimiento Bancario: "+ i++ +", Fecha: "+m.getFecha()+", Concepto: "+m.getConcepto()+", Cantidad: "+m.getCantidad()+", Tipo: "+m.getTipo());
					
					if(m.getTipo())
						cantidad_total += m.getCantidad();
					else
						cantidad_total -= m.getCantidad();					
			}
		}catch (EOFException eo) {
			System.out.println("No se encuentra ningún movimiento más");
		}		
		objectin.close();
		
		System.out.println("La cantidad total es: "+cantidad_total);
	}
}