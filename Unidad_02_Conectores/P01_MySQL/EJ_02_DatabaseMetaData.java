/*Clase que muestra información sobre la base de datos tubalcain_dam*/

package P01_MySQL;

import java.sql.*;

public class EJ_02_DatabaseMetaData {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //Cargar el driver
		
			//Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://www.db4free.net:3306/tubalcain",
					"tubalcain_dam", "12345678" ); 
  
			DatabaseMetaData dbmd = conexion.getMetaData();
                              
			ResultSet resul = null;
		 
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
			 
	         //Obtener información de las tablas y vistas		       
	         resul = dbmd.getTables(null, "USUARIO", null, null);
			 
	  		 while (resul.next()) {			   
				     String catalogo = resul.getString(1);//columna 1 
				     String esquema = resul.getString(2); //columna 2
				     String tabla = resul.getString(3);   //columna 3
				     String tipo = resul.getString(4);	  //columna 4
	  			     System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", 
	  					   tipo, catalogo, esquema, tabla);
	  		 }   				
	  		 conexion.close(); //Cerrar conexion   	
	  		 
		  } catch (ClassNotFoundException cn) {
			  cn.printStackTrace();
		  } catch (SQLException e) {
			  e.printStackTrace();
		  }		
	}
}