/*Clase que hace una llamada al procedimiento subida_sal_jorge,
 * que trata de subir el salario a los empleados, para ello
 * se pasa por parámetro el dpto_no y la cantidad de dinero
 * que le quieres subir*/

package P01_MySQL;

import java.sql.*;

public class EJ_08_Procedimiento_subida_sal {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://www.db4free.net:3306/tubalcain",
					"tubalcain_dam", "12345678" ); 

			// Declarar parámetros
			String dep = "5";   //""; // departamento
			String subida = "1000";//"1000"; // subida
			
			// construir orden DE LLAMADA
			String sql = "{ call subida_sal_jorge (?, ?) } ";

			// Preparamos la llamada
			CallableStatement llamada = conexion.prepareCall(sql);
			// Damos valor a los argumentos
			llamada.setInt(1, Integer.parseInt(dep)); // primer argumento-dep
			llamada.setFloat(2, Float.parseFloat(subida)); // segundo arg
															
			llamada.executeUpdate(); // ejecutar el procedimiento
			System.out.println("Subida realizada....");
			llamada.close();
			conexion.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}