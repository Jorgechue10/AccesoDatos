/*Creamos una lista de tipo canci�n, para introducir ah� las canciones*/

package UD_01_P05_Ficheros_XML;

import java.util.ArrayList;
import java.util.List;

public class EJ_3_1_ListaCanciones {
	
	private List<Cancion> lista = new ArrayList<Cancion>();
	    
	public EJ_3_1_ListaCanciones(){    	
	}

	public void add(Cancion c) {
		lista.add(c);
	}
	   
	public List<Cancion> getListaCanciones() {
		return lista;
	}	
}