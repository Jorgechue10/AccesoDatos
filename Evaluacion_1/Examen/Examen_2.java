package Examen;

import java.sql.*;

public class Examen_2 {

	static Connection conexion;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Iniciando\n");	    
	    try {	    	
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conexion = DriverManager.getConnection(
	        				"jdbc:mysql://www.db4free.net:3306/jorgedam",
	        				"jorgedam",	"12345678");     
	       
	        //////////--------MÉTODOS--------------///////////////////
	        
	       // insertarDepartamento(3,"3","3");
	        //consultaDepar(1);	     
	        mostrarBD();
	        
	        /*departamento dept = new departamento(2,"Jorge","Tarazona");
	        actualizarDepartamento(dept);
	        darDeBajaDepartamento(2);
	        darDeBajaYMostrarFilasAfectadas(2);
	        actualizarLocalidad(2,"Tarazona");
	        mostrarDepartamentos();*/
	        
	       //////////////////////////////////////////// 
	       conexion.close();
	       System.out.println("Se ha cerrado la conexión");
	    }	    
	    catch ( Exception e){
	        e.printStackTrace();
	    }
	}
	
	/*Método que inserta un departamento. El método recibe tres argumentos (número, nombre y localidad).*/
	public static void insertarDepartamento(int numero,String nombre, String localidad) {
		String query = "INSERT INTO `DEPT`(`DEPTNO`, `DNAME`, `LOC`) "
				+ "VALUES ("+numero+","+nombre+","+localidad+")";
		Statement stmt = null;
        try {
            stmt = conexion.createStatement();        
            stmt.execute(query);
            stmt.close();
        }
        catch (SQLException e){
            e.printStackTrace();        
        } 
	}
	
	public static departamento consultaDepar(int numero) {
		String sql = "{ call consultaDepar (?, ?, ?) } ";		
		departamento dept = new departamento();
		try {
			// Preparamos la llamada
			CallableStatement llamada = conexion.prepareCall(sql);
			// Damos valor a los argumentos
				
			//Registramos el parametro de salida
			llamada.registerOutParameter(2, Types.VARCHAR);
			llamada.registerOutParameter(3, Types.VARCHAR);
				
			
			llamada.setInt(1, numero);
																
			llamada.executeUpdate(); // ejecutar el procedimiento
					
			dept = new departamento(numero,llamada.getString(2),llamada.getString(3));  
					
			/*System.out.println("Número de departamento: "+numero+" Nombre: "
					+llamada.getString(2)+" Localidad: "+llamada.getString(3));*/
			
			llamada.close();
		} catch (SQLException e){
			e.printStackTrace();        
		} 
		return dept;
	}
	
	public static void mostrarBD() {
		
        try {
        	DatabaseMetaData dbmd = conexion.getMetaData();
		 
	  		 String nombre  = dbmd.getDatabaseProductName();
	  		 String driver  = dbmd.getDriverName();
	  		 String url     = dbmd.getURL(); 
	  		 String usuario = dbmd.getUserName() ;
			 		 
	  		 System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:");
	  		 System.out.println("===================================");
	  		 System.out.printf("Nombre : %s %n", nombre );
	  		 System.out.printf("Driver : %s %n", driver );
	  		 System.out.printf("URL    : %s %n", url );
	  		 System.out.printf("Usuario: %s %n", usuario );
        }
        catch (SQLException e){
            e.printStackTrace();        
        } 
	}
	
	public static void mostrarEsquema() {
		
        try {
        	DatabaseMetaData dbmd = conexion.getMetaData();
		 
	  		 String nombre  = dbmd.getDatabaseProductName();
	  		 String driver  = dbmd.getDriverName();
	  		 String url     = dbmd.getURL(); 
	  		 String usuario = dbmd.getUserName() ;
			 		 
	  		 System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:");
	  		 System.out.println("===================================");
	  		 System.out.printf("Nombre : %s %n", nombre );
	  		 System.out.printf("Driver : %s %n", driver );
	  		 System.out.printf("URL    : %s %n", url );
	  		 System.out.printf("Usuario: %s %n", usuario );
        }
        catch (SQLException e){
            e.printStackTrace();        
        } 
	}	
	
	
}

class departamento{
	int numero;
	String nombre;
	String localidad;
	
	public departamento() {
		 
	 }
	
	public departamento(int num, String nom, String loca) {
		this.numero=num;
		this.nombre=nom;
		this.localidad=loca;
	}
	 
	 
	 public int getNumero() {
		 return numero;
	 }
	 public String getNombre() {
		 return nombre;
	 }
	 public String getLocalidad() {
		 return localidad;
	 }
	
	 public void setNumero(int numero) {
		 this.numero = numero;
	 }
	 public void setNombre(String nombre) {
		 this.nombre = nombre;
	 }
	 public void setLocalidad(String localidad) {
		 this.localidad = localidad;
	 }	
	 
	 public String mostrarDepartamento() {
		 return "Numero: " + numero + " Nombre: " + nombre+" Localidad: " + localidad;
	 }
}
