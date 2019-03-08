package Ejercicio_3_DAOS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import Ejercicio_3_Driver_MySQL.MySQLConnection;
import Ejercicio_3_Interfaz_DAOS.EquipoDao;
import Ejercicio_3_Modelo.Equipo;


public class EquipoDaoMySQLI implements EquipoDao {

	@Override
	public boolean create(Equipo equipo) {
		
	boolean created = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO equipos (nombre, ligas, copas, fundacion, temp_primera)"
				+ "values ('"+equipo.getNombre()+"',"+equipo.getLigas()+","+
		equipo.getCopas()+","+equipo.getFundacion()+","+equipo.getEnPrimera()+")";
		
		try {			
			con=MySQLConnection.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			created=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase EquipoDaoMySQLI, método create");
			e.printStackTrace();
		}
		return created;
	}

	@Override
	public List<Equipo> read() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM equipos ORDER BY ligas desc";
		
		List<Equipo> listaEquipos= new ArrayList<Equipo>();
		
		try {			
			co= MySQLConnection.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				
				Equipo e = new Equipo();
				//e.setCodigo(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setLigas(rs.getInt(3));
				e.setCopas(rs.getInt(4));
				e.setFundacion(rs.getInt(5));
				e.setEnPrimera(rs.getInt(6));
				listaEquipos.add(e);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase JugadorDaoMySQLImp, método read");
			e.printStackTrace();
		}
		
		return listaEquipos;
	}

	@Override
	public boolean update(Equipo equipo) {
		
		Connection connect= null;
		Statement stm= null;
		
		boolean updated=false;
		
		String sql="UPDATE equipos SET nombre='"+equipo.getNombre()+"', ligas ="+equipo.getLigas()+
				", copas="+equipo.getCopas()+", fundacion=" + equipo.getFundacion()+", temp_primera=" + 
				equipo.getEnPrimera() +" WHERE nombre='"+equipo.getNombre()+"'";
		
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
	public boolean delete(Equipo equipo) {
		Connection con = null;
		Statement stm = null;
		
		boolean removed = false;
		
		String sql = "DELETE FROM equipos WHERE nombre = '"+equipo.getNombre()+"'";
		
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
