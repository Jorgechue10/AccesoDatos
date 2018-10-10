package P04_FicherosBytes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class escritura_de_objetos {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File f = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P04_FicherosBytes\\personas.dat");
		f.createNewFile();
		FileOutputStream fileout = new FileOutputStream(f);
		ObjectOutputStream objectout = new ObjectOutputStream(fileout);
		
		Persona p;
		
		
		Scanner teclado = new Scanner (System.in);				
		String[] nombres = new String[5];
		System.out.println("Introduce los nombres de 5 personas");		
		for (int i=0;i<5;i++) {			
			nombres[i]=teclado.nextLine();
		}
		
		int[] edades = new int[5];
		System.out.println("Introduce las edades de las 5 personas anteriores");	
		for (int i=0;i<5;i++) {
			edades[i]=teclado.nextInt();
		}
		
		int i;
		for(i=0;i<5;i++) {
			//inicializar persona
			p = new Persona(edades[i],nombres[i]);
			//escribir un objeto en un fichero
			objectout.writeObject(p);
		}
		objectout.close();		
	}
}