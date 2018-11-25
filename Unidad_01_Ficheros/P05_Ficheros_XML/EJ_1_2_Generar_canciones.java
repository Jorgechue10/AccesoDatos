/*Clase que recibe 5 objetos Cancion y las mete en el fichero de bytes ej_1_canciones.dat*/

package P05_Ficheros_XML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EJ_1_2_Generar_canciones {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File f = new File("Unidad_01_Ficheros\\P05_Ficheros_XML\\Ficheros\\ej_1_canciones.dat");
		f.createNewFile();
		FileOutputStream fileout = new FileOutputStream(f);
		ObjectOutputStream objectout = new ObjectOutputStream(fileout);
		
		EJ_1_1_Cancion canciones[] = new EJ_1_1_Cancion[5];
		canciones[0] = new EJ_1_1_Cancion(1,2008,"Hola","Miguel","3 Minutos",true);
		canciones[1] = new EJ_1_1_Cancion(2,2010,"Que","Alex","4 Minutos",false);	
		canciones[2] = new EJ_1_1_Cancion(3,2014,"Tal","David","5 Minutos",false);	
		canciones[3] = new EJ_1_1_Cancion(4,2017,"Estás","Pablo","3 Minutos",true);	
		canciones[4] = new EJ_1_1_Cancion(5,2018,"Juan","Daniel","2 Minutos",true);				
		
		for(int i=0;i<5;i++) {
			objectout.writeObject(canciones[i]);
		}
		objectout.close();	
	}
}
