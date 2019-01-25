package NeoDatis;

public class EJ_01_1_Jugadores {
    
    // Propiedades
    private String nombre;
    private String deporte;
    private String ciudad;
    private int edad;
    EJ_01_3_Paises pais;
   
    // Constructores
    public EJ_01_1_Jugadores(){};
   
    public EJ_01_1_Jugadores(String nombre, String deporte, String ciudad, int edad, EJ_01_3_Paises pais) {
          super();
          this.nombre = nombre;
          this.deporte = deporte;
          this.ciudad = ciudad;
          this.edad = edad;
          this.pais = pais;
    }
   
    // Métodos
    public String getNombre() {
          return nombre;
    }
    public void setNombre(String nombre) {
          this.nombre = nombre;
    }
    public String getDeporte() {
          return deporte;
    }
    public void setDeporte(String deporte) {
          this.deporte = deporte;
    }
    public String getCiudad() {
          return ciudad;
    }
    public void setCiudad(String ciudad) {
          this.ciudad = ciudad;
    }
    public int getEdad() {
          return edad;
    }
    public void setEdad(int edad) {
          this.edad = edad;
    }
} // Fin clase Jugadores