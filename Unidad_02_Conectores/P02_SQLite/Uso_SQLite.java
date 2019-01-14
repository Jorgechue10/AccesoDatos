/*Clase que se conecta con una base de datos SQLite (local), crea una tabla llamda persona
 * que contiene 6 campos e implementa métodos diferentes para realizar las operaciones 
 * básicas sobre una BD (CRUD)*/

package P02_SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Uso_SQLite {
	
	private static Statement statement;
	private static ResultSet rs;
	
	public static void main(String[] args) {
		  Connection connection = null;
		  try {
    	
			  // create a database connection
		      connection = DriverManager.getConnection("jdbc:sqlite:Unidad_02_Conectores\\P02_SQLite\\ejemplo.db");
		      statement = connection.createStatement();
		      statement.setQueryTimeout(30);  // set timeout to 30 sec.
		
		      statement.executeUpdate("drop table if exists persona");
		      statement.executeUpdate("create table persona (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre string, "
		      		+ "edad integer, telefono integer, direccion String, ciudad string)");
		      
		      /*statement.executeUpdate("insert into persona (nombre, edad, telefono, direccion, ciudad)"
		      		+ "values('Jorge', 19, 976, 'Calle Mayor', 'Tarazona')");*/
	      
		      insertar("Jorge", 19, 976, "Calle Mayor", "Tarazona");
		      insertar("Oscar", 22, 948, "Calle Visconti", "Tudela");
		      insertar("Alex", 21, 985, "Calle Marrodán", "Novallas");
		      //mostrar();
		      //actualizar(1,"Juan", 27, 265, "Calle Moncayo", "Torrellas");
		      //mostrar();
		      //borrar(1);
		      //buscar(3);
		      mostrar();
	      
		  } catch(SQLException e) {
			  // if the error message is "out of memory",
			  // it probably means no database file is found
			  System.err.println(e.getMessage());
	      
		  } finally {
			  try {
				  if(connection != null)
					  connection.close();
			  } catch(SQLException e) {
				  // connection close failed.
				  System.err.println(e.getMessage());
			  }
		  }
	}
	
	//Método que inserta los datos que recibe en la tabla persona
	public static void insertar(String n, int e,int t, String d, String c) throws SQLException { 
		statement.executeUpdate("insert into persona (nombre, edad, telefono, direccion, ciudad)"
				+ "values('"+n+"', "+e+", "+t+", '"+d+"', '"+c+"')");
	}
	
	//Método que muetra todos datos de la tabla persona
	public static void mostrar() throws SQLException { 
		rs = statement.executeQuery("select * from persona");
		while(rs.next()) {
			// read the result set
			System.out.print("ID: " + rs.getInt("id"));
			System.out.print("\tNombre: " + rs.getString("nombre"));	
			System.out.print("\tEdad: " + rs.getString("edad"));	
			System.out.print("\tTeléfono: " + rs.getString("telefono"));
			System.out.print("\tDireccion: " + rs.getString("direccion"));
			System.out.println("\tCiudad: " + rs.getString("ciudad"));
		}
	}
	
	//Método que modifica los datos de la persona cuyo id es el que le pasas por parámetro.
	public static void actualizar(int id, String n, int e,int t, String d, String c) throws SQLException { 
		statement.executeUpdate("update persona set nombre='"+n+"', edad="+e+", "
				+ "telefono="+t+", direccion='"+d+"', ciudad='"+c+"' where id="+id+"");	   
	}
	
	//Método que borra los datos de la persona cuyo id es el que le pasas por parámetro.
	public static void borrar(int id) throws SQLException { 
		statement.executeUpdate("delete from persona where id="+id+"");	   
	}
	
	//Método que muetra los datos de la persona cuyo id es el que le pasas por parámetro.
	public static void buscar(int id) throws SQLException { 
		rs = statement.executeQuery("select * from persona where id="+id+"");
		while(rs.next()) {
	        // read the result set
			System.out.print("ID: " + rs.getInt("id"));
			System.out.print("\tNombre: " + rs.getString("nombre"));	
			System.out.print("\tEdad: " + rs.getString("edad"));	
			System.out.print("\tTeléfono: " + rs.getString("telefono"));
			System.out.print("\tDireccion: " + rs.getString("direccion"));
			System.out.println("\tCiudad: " + rs.getString("ciudad"));
		}      	   
	}
}