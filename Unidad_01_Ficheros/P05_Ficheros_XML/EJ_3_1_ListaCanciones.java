/*Creamos una lista de tipo canción, para introducir ahí todas las canciones
 * del fichero ej_1_canciones.dat*/

package P05_Ficheros_XML;

import java.util.ArrayList;
import java.util.List;

public class EJ_3_1_ListaCanciones {
	
	private List<EJ_1_1_Cancion> lista = new ArrayList<EJ_1_1_Cancion>();
	    
	public EJ_3_1_ListaCanciones(){    	
	}

	public void add(EJ_1_1_Cancion c) {
		lista.add(c);
	}
	   
	public List<EJ_1_1_Cancion> getListaCanciones() {
		return lista;
	}	
}