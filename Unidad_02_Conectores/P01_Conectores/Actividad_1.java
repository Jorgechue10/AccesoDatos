package P01_Conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Actividad_1
{
	
	private static Statement statement;
	private static ResultSet rs;
	
  public static void main(String[] args)
  {
    Connection connection = null;
    try
    {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:Unidad_02_Conectores\\P01_Conectores\\actividad1.db");
      statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      statement.executeUpdate("drop table if exists person");
      statement.executeUpdate("create table person (id integer, name string)");
      
      
      
      insertar(1,"Jorge");
      mostrar();
      actualizar(1,"Juan");
      mostrar();
      //borrar(1);
      
    }
    catch(SQLException e)
    {
      // if the error message is "out of memory",
      // it probably means no database file is found
      System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println(e.getMessage());
      }
    }
  }
  public static void insertar(int id, String n) throws SQLException { 
	  statement.executeUpdate("insert into person values("+id+", '"+n+"')");
  }
  public static void mostrar() throws SQLException { 
	  rs = statement.executeQuery("select * from person");
      while(rs.next())
      {
        // read the result set
        System.out.println("name = " + rs.getString("name"));
        System.out.println("id = " + rs.getInt("id"));
      }
  }
  public static void actualizar(int id, String n) throws SQLException { 
	  statement.executeUpdate("update person set name='"+n+"' where id="+id+"");	   
 }
  public static void borrar(int id) throws SQLException { 
	  statement.executeUpdate("delete from person where id="+id+"");	   
 }
}