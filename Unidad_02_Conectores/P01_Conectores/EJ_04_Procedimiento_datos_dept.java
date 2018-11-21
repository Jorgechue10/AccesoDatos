package P01_Conectores;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class EJ_04_Procedimiento_datos_dept {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver
			 Connection conexion = DriverManager.getConnection(
     				"jdbc:mysql://www.db4free.net:3306/tubalcain",
     				"tubalcain_dam",
     				"12345678"
     				); 

			// recuperar parametros de main
			int dep = 7;  // departamento
			
			// construir orden DE LLAMADA
			String sql = "{ call datos_dep_jorge (?, ?, ?) } ";

			// Preparamos la llamada
			CallableStatement llamada = conexion.prepareCall(sql);
			// Damos valor a los argumentos
			
			//Registramos el parametro de salida que esta en la posicion 1
			llamada.registerOutParameter(2, Types.VARCHAR);
			llamada.registerOutParameter(3, Types.VARCHAR);
			
			//Doy valor al parametro de entrada (posicion 2)
			llamada.setInt(1, dep);
															
			llamada.execute(); // ejecutar el procedimiento
			
			//Mostrar parametro de salida
			System.out.println("Número de departamento: "+dep+" Nombre: "
			+llamada.getString(2)+" Localidad: "+llamada.getString(3));
			
			llamada.close();
			conexion.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}