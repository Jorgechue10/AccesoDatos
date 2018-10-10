package P04_FicherosBytes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class escritura_de_objetos {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File f = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P04_FicherosBytes\\personas.dat");
		f.createNewFile();
		FileOutputStream fileout = new FileOutputStream(f);
		ObjectOutputStream objectout = new ObjectOutputStream(fileout);
		
		Persona p;
		
		String[] nombres = new String[10];
		nombres[0]="Isabel";
		nombres[1]="Pepe";
		nombres[2]="Juan";
		nombres[3]="Alex";
		nombres[4]="Oscar";
		nombres[5]="Tono";
		nombres[6]="Fran";
		nombres[7]="Jorge";
		nombres[8]="Marisa";
		nombres[9]="Elena";
		
		int[] edades = new int[10];
		edades[0]=20;
		edades[1]=19;
		edades[2]=18;
		edades[3]=17;
		edades[4]=16;
		edades[5]=15;
		edades[6]=14;
		edades[7]=13;
		edades[8]=12;
		edades[9]=11;
		
		int i;
		for(i=0;i<10;i++) {
			//inicializar persona
			p = new Persona(edades[i],nombres[i]);
			//escribir un objeto en un fichero
			objectout.writeObject(p);
		}
		objectout.close();		
	}
}