package P01_Introduccion_JavaBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/*import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;*/

/**
 * Pequeño ejemplo de uso de acceso a base de datos con Spring DAO
 * 
 * @author chuidiang
 */
public class EJ_2_2_SpringDAO {
    /**
     * Consulta una tabla de base de datos y escribe en pantalla los registros
     * leídos.
     * 
     * @param args
     */
    /*public static void main(String[] args) {
        // Datos de conexion con la base de datos
        DriverManagerDataSource dataSource = new DriverManagerDataSource();  
        dataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/prueba");
        dataSource.setUsername("root");
        dataSource.setPassword("la-password");

        // La clase Spring con la Connection
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // Realizacmos la consulta
        Collection personas = jdbcTemplate.query(
                "select id,nombre,nacimiento from persona", new RowMapper() {

                    @Override
                    public Object mapRow(ResultSet rs, int arg1)
                            throws SQLException {
                        // Se rellena un bean Persona a partir de la fila actual
                        // del ResultSet
                        Persona persona = new Persona();
                        persona.setId(rs.getInt("id"));
                        persona.setNombre(rs.getString("nombre"));
                        persona.setFechaNacimiento(rs.getDate("nacimiento"));
                        return persona;
                    }
                });

        // Escribimos en pantalla los datos leidos
        for (Object persona : personas) {
            System.out.println(persona.toString());
        }
    }*/
}