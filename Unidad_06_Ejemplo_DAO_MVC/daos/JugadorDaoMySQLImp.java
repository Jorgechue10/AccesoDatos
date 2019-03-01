package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import driverMySQL.MySQLConnection;
import interfaz_daos.JugadorDao;
import modelos.Jugador;


public class JugadorDaoMySQLImp implements JugadorDao {

	@Override
	public boolean create(Jugador jugador) {
		
	boolean created = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO jugadores values ("+jugador.getCodigo()+",'"+jugador.getNombre()+"','"+jugador.getProcedencia()+"','"+jugador.getAltura()+"','"+jugador.getPeso()+"','"+jugador.getPosicion()+"','"+jugador.getNombre_equipo()+"')";
		
		try {			
			con=MySQLConnection.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			created=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase JugadorDaoMySQLImp, método create");
			e.printStackTrace();
		}
		return created;
	}

	@Override
	public List<Jugador> read() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM jugadores ORDER BY codigo";
		
		List<Jugador> listaJugadores= new ArrayList<Jugador>();
		
		try {			
			co= MySQLConnection.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				
				Jugador j = new Jugador();
				j.setCodigo(rs.getInt(1));
				j.setNombre(rs.getString(2));
				j.setProcedencia(rs.getString(3));
				j.setAltura(rs.getString(4));
				j.setPeso(rs.getInt(5));
				j.setPosicion(rs.getString(6));
				j.setNombre_equipo(rs.getString(7));
				listaJugadores.add(j);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase JugadorDaoMySQLImp, método read");
			e.printStackTrace();
		}
		
		return listaJugadores;
	}

	@Override
	public boolean update(Jugador jugador) {
		
		Connection connect= null;
		Statement stm= null;
		
		boolean updated=false;
		
		String sql="UPDATE jugadores SET nombre='"+jugador.getNombre()+"', procedencia='"+jugador.getProcedencia()+"', altura='"+jugador.getAltura()+"', peso=" + jugador.getPeso()+", posicion='" + jugador.getPosicion()+"', nombre_equipo='"+jugador.getNombre_equipo() +"' WHERE codigo="+jugador.getCodigo();
		
		try {
			connect=MySQLConnection.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			updated=true;
		} catch (SQLException e) {
			System.out.println("Error: JugadorDaoMySQLImp, método actualizar");
			e.printStackTrace();
		}		
		return updated;
	}

	@Override
	public boolean delete(Jugador jugador) {
		Connection con = null;
		Statement stm = null;
		
		boolean removed = false;
		String sql = "DELETE FROM jugadores WHERE codigo = "+jugador.getCodigo();
		
		try {
			con = MySQLConnection.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			removed = true;
		} catch (SQLException e) {
			System.out.println("Error: Clase JugadorDaoMySQLImp, método delete");
			e.printStackTrace();
		}
		
		
		return removed;
	}

}
