/*Clase que va a ser el elemento raíz Librería del XML*/

package P06_JAXB_Mapear_Clase_a_XML;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
 
//Esto significa que la clases "Libreria.java" es el elemento raiz
// namespace es opcional
//@XmlRootElement(namespace = "ejemplo1.xml")
//@XmlRootElement(namespace = "")
@XmlRootElement(name = "Libreria")
public class EJ_1_2_Libreria {
	 
    private ArrayList<EJ_1_1_Libro> listaLibro;
    private String nombre;
    private String lugar;
   
    public EJ_1_2_Libreria(ArrayList<EJ_1_1_Libro> listaLibro, String nombre, String lugar) {
		super();
		this.listaLibro = listaLibro;
		this.nombre = nombre;
		this.lugar = lugar;
	}
    public EJ_1_2_Libreria(){}
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setLugar(String lugar) { this.lugar = lugar;    }
    public String getNombre() {return nombre;    }
    public String getLugar() { return lugar;    }

    //Wrapper, envoltura alrededor la representación XML
    //Anotaciones para atributos que son colecciones
    @XmlElementWrapper(name = "ListaLibro") // 
    @XmlElement(name = "Libro")
    public ArrayList<EJ_1_1_Libro> getListaLibro() {
        return listaLibro;    }
 
    public void setListaLibro(ArrayList<EJ_1_1_Libro> listaLibro) {
        this.listaLibro = listaLibro;    }
 }