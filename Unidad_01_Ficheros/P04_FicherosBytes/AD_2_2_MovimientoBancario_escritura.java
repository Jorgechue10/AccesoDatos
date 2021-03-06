/*Clase que escribe los movimientos bancarios de una cuenta corriente*/

package P04_FicherosBytes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class AD_2_2_MovimientoBancario_escritura {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File f = new File("Unidad_01_Ficheros\\P04_FicherosBytes\\Ficheros\\ad_2_movimientosBancarios.dat");
		f.createNewFile();
		FileOutputStream fileout = new FileOutputStream(f);
		ObjectOutputStream objectout = new ObjectOutputStream(fileout);
		
		AD_2_1_MovimientoBancario m;		
		
		Scanner teclado = new Scanner (System.in);				
		String[] fechas = new String[5];
		String[] coceptos = new String[5];
		int[] cantidades = new int[5];
		boolean[] tipos = new boolean[5];
		String seguir = "si";
		int i=0;
				
		while(seguir.equals("si")) {
			System.out.println("Introduce la fecha");			
			fechas[i]=teclado.nextLine();
			System.out.println("Introduce el cocepto del movimiento");			
			coceptos[i]=teclado.nextLine();
			System.out.println("Introduce la cantidad");
			cantidades[i]=teclado.nextInt();
			System.out.println("Introduce el tipo si desea sacar dinero (false) y si desea ingresar (true)");
			tipos[i]=teclado.nextBoolean();
			seguir=teclado.nextLine();
			System.out.println("¿Desea realizar otra operación [si/no]?");
			seguir=teclado.nextLine();
			i++;
		}			
		for(int j=0;j<=i-1;j++) {
			//inicializar movimiento bancario
			m = new AD_2_1_MovimientoBancario(fechas[j],coceptos[j],cantidades[j],tipos[j]);
			//escribir un objeto en un fichero
			objectout.writeObject(m);
		}
		objectout.close();
		teclado.close();
	}
}