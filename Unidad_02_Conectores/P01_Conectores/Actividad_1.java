package P01_Conectores;

import java.sql.*;

public class Actividad_1 {

   public static void main( String args[] ) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:Unidad_02_Conectores\\P01_Conectores\\actividad1.db");
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "CREATE TABLE PRUEBA " +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " NOMBRE           TEXT    NOT NULL, " + 
                        " EDAD            INT     NOT NULL, " + 
                        " DIRECCION        CHAR(50), " + 
                        " CIUDAD         CHAR(50))"; 
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
   }
}