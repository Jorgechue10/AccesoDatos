/*Ejemplo de uso de una sentencia preparada, en este caso
 * va a insertar datos en la tabla departamentos*/

package P01_MySQL;

import java.sql.*;

public class EJ_07_SentenciaPreparada {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://www.db4free.net:3306/tubalcain",
					"tubalcain_dam", "12345678" );  
										
			// recuperar argumentos de main
			String dnombre = "RRHH"; // nombre
			String dep = "7"; // num. departamento
			String loc = "Novallas"; // localidad
			
			// construir orden INSERT
			String sql = "INSERT INTO departamentos VALUES "
					+ "( ?, ?, ? )";
		    
			System.out.println(sql);  			    
			PreparedStatement sentencia = 
					conexion.prepareStatement(sql);				
			sentencia.setString(1, dnombre);
			sentencia.setInt(2, Integer.parseInt(dep));
			sentencia.setString(3, loc);
			
			int filas;//
			try {
			
				filas = sentencia.executeUpdate();
				System.out.println("Filas afectadas: " + filas);
			} catch (SQLException e) {
				System.out.println("HA OCURRIDO UNA EXCEPCIÓN:"); 
			    System.out.println("Mensaje:    "+ e.getMessage()); 
			    System.out.println("SQL estado: "+ e.getSQLState()); 
		    	System.out.println("Código error:  "+ e.getErrorCode());  
			}
			
			sentencia.close();
			conexion.close();

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}