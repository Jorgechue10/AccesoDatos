/*Clase que muestra a través de un Select todos los departamentos,
 * para ello se utiliza el método execute*/

package P01_MySQL;

import java.sql.*;

public class EJ_04_Execute {   
	
	public static void main(String[] args) throws 
				ClassNotFoundException, SQLException {
	  
		//CONEXION A MYSQL  	       
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection(
				"jdbc:mysql://www.db4free.net:3306/tubalcain",
				"tubalcain_dam", "12345678" );     		   
	   
		   String sql="SELECT * FROM departamentos";
		   Statement sentencia = conexion.createStatement();		   
		   boolean valor = sentencia.execute(sql);  
	   		   
		   if(valor){
			   ResultSet rs = sentencia.getResultSet();
			   while (rs.next())
				   System.out.printf("%s, %d, %s %n",
						   rs.getString(1), rs.getInt(2), rs.getString(3));
			   rs.close();
		   } else {
			   int f = sentencia.getUpdateCount();
			   System.out.printf("Filas afectadas:%d %n", f);
		   }
	   
		   sentencia.close();
		   conexion.close();
	}//main
}//