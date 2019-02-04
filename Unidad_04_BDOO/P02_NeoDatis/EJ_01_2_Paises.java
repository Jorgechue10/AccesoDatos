package P02_NeoDatis;

public class EJ_01_2_Paises {

	private int idPais;
	private String nombrePais;
	
    public EJ_01_2_Paises(){};
   
    public EJ_01_2_Paises(int id, String nombre) {
          super();
          this.idPais = id;
          this.nombrePais = nombre;          
    }
    
    public int getIdPais() {
		return idPais;
	}
	public String getNombrePais() {
		return nombrePais;
	}
		public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}	
}