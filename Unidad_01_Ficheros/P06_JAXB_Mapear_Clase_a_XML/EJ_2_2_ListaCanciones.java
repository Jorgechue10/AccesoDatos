package P06_JAXB_Mapear_Clase_a_XML;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
//Esto significa que la clases "Libreria.java" es el elemento raiz
// namespace es opcional
//@XmlRootElement(namespace = "ejemplo1.xml")
//@XmlRootElement(namespace = "")
@XmlRootElement(name = "listaCanciones")
public class EJ_2_2_ListaCanciones {
	
	private ArrayList<EJ_2_1_Cancion> lista = new ArrayList<EJ_2_1_Cancion>();
	    
	public EJ_2_2_ListaCanciones(){    	
	}

	public void add(EJ_2_1_Cancion c) {
		lista.add(c);
	}
	 
	//Wrapper, envoltura alrededor la representación XML
    //Anotaciones para atributos que son colecciones
    //@XmlElementWrapper(name = "listaCanciones") // 
    @XmlElement(name = "cancion")
	public ArrayList<EJ_2_1_Cancion> getListaCanciones() {
		return lista;
	}	
	public void setListaCanciones(ArrayList<EJ_2_1_Cancion> listaCancion) {
        this.lista = listaCancion;  
	}
}