package driver_MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnection {
	
	public static Connection conectar() {
		Connection con = null;
		
		String user = "root";
		String pass = "1234";
		
		try {
			
			// se envía la cadena y los datos de usuario y password por separado
			Properties datos = new Properties();
			
			datos.put("user", user);
			datos.put("password", pass);
			
			String url = "jdbc:mysql://localhost:3308/futbol?serverTimezone=UTC";
			
			con = DriverManager.getConnection(url, datos);
			if (con != null) {
				System.out.println("Conexión a equipos satisfactoria");
			}
						
		} catch (SQLException e) {
			System.out.println(
					"Error en la conexión, verificar usuario y password o nombre de la base de datos");
			e.printStackTrace();
		}
		
		return con;
	}

}
