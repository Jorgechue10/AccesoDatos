/*Ejemplo de cómo crear una vista*/

package P01_MySQL;

import java.sql.*;

public class EJ_06_CrearVista {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://www.db4free.net:3306/tubalcain",
					"tubalcain_dam", "12345678" ); 

			StringBuilder sql = new StringBuilder();
	        sql.append("CREATE OR REPLACE VIEW totales ");
	        sql.append("(dep, dnombre, nemp, media) AS ");
	        sql.append("SELECT d.dept_no, dnombre, COUNT(emp_no), AVG(salario) ");
	        sql.append("FROM departamentos d LEFT JOIN empleados e " );
	        sql.append("ON e.dept_no = d.dept_no ");
	        sql.append("GROUP BY d.dept_no, dnombre ");
			System.out.println(sql);
			
			Statement sentencia = conexion.createStatement();
			int filas = sentencia.executeUpdate(sql.toString());
			System.out.printf("Resultado  de la ejecución: %d %n", filas);
	
			sentencia.close();
			conexion.close(); 
	}
}