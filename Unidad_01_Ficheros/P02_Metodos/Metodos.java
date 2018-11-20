package P02_Metodos;

import java.io.File;
import java.io.IOException;

public class Metodos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "Unidad_01_Ficheros\\P02_Metodos\\fichero_prueba.txt";
		File f1 = new File(path);		
		
		if(f1.exists()) {
			//mostrar nombre del fichero
			System.out.println(f1.getName());
			//mostrar la ruta del fichero
			System.out.println(f1.getPath());
			//mostrar la ruta absoluta del fichero
			System.out.println(f1.getAbsolutePath());
			//mostrar si existe el fichero
			System.out.println(f1.exists());
			//mostrar si es File el fichero
			System.out.println(f1.isFile());
			//mostrar si el fichero es un directorio o un fichero
			System.out.println(f1.isDirectory());
			//mostrar el tamano del fichero (lo que ocupa)
			System.out.println(f1.length());
			//mostrar el directorio(carpeta) padre en la que se encuentra el fichero
			System.out.println(f1.getParent());
			
			System.out.println("Se puede leer             : " + f1.canRead());
			System.out.println("Se puede escribir         : " + f1.canWrite());
			/*crear un fichero
			f1.createNewFile();*/
			
			
			//mostrar los nombre de los ficheros y directorios(carpeta) contenidos en el directorio actual
			String dir = "Unidad_01_Ficheros\\P02_Metodos";
			File f2 = new File(dir);
			String[] listaNombres = f2.list();//metemos todos los ficheros en una lista String
			System.out.println("\n");
			for(int i=0;i<listaNombres.length;i++) {
				System.out.println(listaNombres[i]);
			}
			
			
			//diferenciar si los archivos anteriores son ficheros o directorios	
			System.out.println("\n");
			for(int i=0;i<listaNombres.length;i++) {
				File f3 = new File(f2,listaNombres[i]);
				if(f3.isFile()) {
					System.out.println("Este archivo es un fichero");
				}else {
					System.out.println("Este archivo es una carpeta");
				}
			}
			
			
			//otra manera de hacer el ejercicio anterior
			System.out.println("\n");
			for(int i=0;i<listaNombres.length;i++) {
				File f4 = new File(f2,listaNombres[i]);
				System.out.println("El archivo "+listaNombres[i]+" Es un fichero? "+f4.isFile()+" Es un directorio? "+f4.isDirectory());		
			}
			
			
			//realizar los mismo, pero utilizando listFiles(File[]), en vez de list(String[])
			System.out.println("\n");
			File[] listaFicheros = f2.listFiles();
			for(int i=0;i<listaFicheros.length;i++) {
				System.out.println("El archivo "+listaFicheros[i].getName()+" Es un fichero? "+listaFicheros[i].isFile()+" Es un directorio? "+listaFicheros[i].isDirectory());		
			}		
			
			
			//Crear un directorio
			System.out.println("\n");
			File f5= new File("Unidad_01_Ficheros\\P02_Metodos\\nuevoDirectorio");
			if(f5.mkdir()) {//te dice si el directorio se ha creado o no, a partir de un boolean
				System.out.println("El directorio se ha creado");
			}else {
				System.out.println("El directorio no se ha creado");
			}
			
			
			//Crear directorio que se llame TBBT y dentro de ese directorio vamos a crear 
			//4 archivos (Sheldom.text, Penny.txt, Leonard.text, Howard.txt)
			File f6= new File("Unidad_01_Ficheros\\P02_Metodos\\TBBT");
			if(f6.mkdir()) {//si el directorio se creada
				File personaje1=new File(f6,"Sheldom.txt");
				File personaje2=new File(f6,"Penny.txt");
				File personaje3=new File(f6,"Leonard.txt");
				File personaje4=new File(f6,"Howard.txt");
				try {
					personaje1.createNewFile();
					personaje2.createNewFile();
					personaje3.createNewFile();
					personaje4.createNewFile();
				}catch(IOException e){
					System.out.println(e.getMessage());
				}
			}else {
				System.out.println("\n");
				System.out.println("El directorio no se ha creado");
			}	
			
			
			//Vamos a renombrar el fichero Howard de la actividad anterior
			File f7= new File("Unidad_01_Ficheros\\P02_Metodos\\TBBT\\Howard.txt");
			f7.renameTo(new File(f6,"Bernadet.txt"));
			
			
			//Borrar un fichero
			System.out.println("\n");
			File f8= new File("Unidad_01_Ficheros\\P02_Metodos\\TBBT\\Leonard.txt");
			if(f8.delete()){
				System.out.println("El fichero se ha borrado");
			}else {
				System.out.println("El fichero no se ha borrado");
			}			
		}else {
			System.out.println("La ruta al fichero es invalida");		
		}
	}
}