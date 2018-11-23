package P06_JAXB;

import javax.xml.bind.annotation.XmlType; 

/*anotacion para establecer rl orden en el que se introducirán 
 * los elementos en el mfichero xml*/
@XmlType(propOrder = {"autor", "nombre", "editorial", "isbn"})

public class EJ_1_1_Libro { 
    private String nombre;
    private String autor;
    private String editorial;
    private String isbn;
    public EJ_1_1_Libro(String nombre, String autor, String editorial, String isbn) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.editorial = editorial;
		this.isbn = isbn;
	}   
	public EJ_1_1_Libro() {}
    public String getNombre() { return nombre; }
    public String getAutor() { return autor;  }
    public String getEditorial() {return editorial; }
    public String getIsbn() { return isbn;}
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setEditorial(String editorial) { this.editorial = editorial;  }
    public void setIsbn(String isbn) {  this.isbn = isbn;  }
}