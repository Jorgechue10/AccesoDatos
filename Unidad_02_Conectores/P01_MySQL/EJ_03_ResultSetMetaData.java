/*Clase que muestra información de una sentencia*/

package P01_MySQL;

import java.sql.*;

public class EJ_03_ResultSetMetaData {

	public static void main(String[] args) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://www.db4free.net:3306/tubalcain",
					"tubalcain_dam", "12345678" ); 
             
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia
					.executeQuery("SELECT * FROM departamentos");
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int nColumnas = rsmd.getColumnCount();
			String nula;
			System.out.printf("Número de columnas recuperadas: %d%n", nColumnas);
			for (int i = 1; i <= nColumnas; i++) {
				System.out.printf("Columna %d: %n ", i);
				System.out.printf("  Nombre: %s %n   Tipo: %s %n ",
						 rsmd.getColumnName(i),  rsmd.getColumnTypeName(i));
				if (rsmd.isNullable(i) == 0)
					nula = "NO";
				else
					nula = "SI";
				
				System.out.printf("  Puede ser nula?: %s %n ", nula);			
				System.out.printf("  Máximo ancho de la columna: %d %n",
						 rsmd.getColumnDisplaySize(i));
			}
			
			sentencia.close();
			rs.close();
			conexion.close();

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}