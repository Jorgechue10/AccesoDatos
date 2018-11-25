/*Clase que inserta datos en la tabla departamentos,
 * utilizando el método executeUpdate*/

package P01_MySQL;

import java.sql.*;

public class EJ_05_ExecuteUpdate {
	public static void main(String[] args) {
		try {
			
			//CONEXION A MYSQL  	       
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://www.db4free.net:3306/tubalcain",
					"tubalcain_dam", "12345678" ); 
			
			//construir orden INSERT	        
	        String sql = String.format("INSERT INTO departamentos VALUES ('RRHH', 7, 'Novallas')");
	        	        
			System.out.println(sql);
			Statement sentencia = conexion.createStatement();
			int filas=0;
			try {
			  filas = sentencia.executeUpdate(sql.toString());
			  System.out.println("Filas afectadas: " + filas);
			} catch (SQLException e) {
				//e.printStackTrace();
				   System.out.printf("HA OCURRIDO UNA EXCEPCIÓN:%n"); 
				   System.out.printf("Mensaje   : %s %n", e.getMessage()); 
				   System.out.printf("SQL estado: %s %n", e.getSQLState()); 
				   System.out.printf("Cód error : %s %n", e.getErrorCode());	    	
			}			

			sentencia.close(); // Cerrar Statement
			conexion.close(); // Cerrar conexión

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}