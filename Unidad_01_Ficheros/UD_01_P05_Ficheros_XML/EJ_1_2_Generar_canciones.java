package UD_01_P05_Ficheros_XML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EJ_1_2_Generar_canciones {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File f = new File("D:\\eclipse-workspace\\AD_01_Fciheros\\src\\P05_Ficheros_XML\\Ficheros\\canciones.dat");
		f.createNewFile();
		FileOutputStream fileout = new FileOutputStream(f);
		ObjectOutputStream objectout = new ObjectOutputStream(fileout);
		
		Cancion canciones[] = new Cancion[5];
		canciones[0] = new Cancion(1,2008,"Hola","Miguel","3 Minutos",true);
		canciones[1] = new Cancion(2,2010,"Que","Alex","4 Minutos",false);	
		canciones[2] = new Cancion(3,2014,"Tal","David","5 Minutos",false);	
		canciones[3] = new Cancion(4,2017,"Est�s","Pablo","3 Minutos",true);	
		canciones[4] = new Cancion(5,2018,"Juan","Daniel","2 Minutos",true);				
		
		for(int i=0;i<5;i++) {
			objectout.writeObject(canciones[i]);
		}
		objectout.close();	
	}
}
