# MySQL

### Conexión

1. [ConnMySQL](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_02_Conectores/P01_MySQL/EJ_01_ConnMySQL.java)
2. [DataBaseMetaData](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_02_Conectores/P01_MySQL/EJ_02_DatabaseMetaData.java)
3. [ResultSetMetaData](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_02_Conectores/P01_MySQL/EJ_03_ResultSetMetaData.java)

### Métodos del objeto Statement

- **executeQuery(String):** Recuperar datos de un único objeto ResulSet. Principalmente bajo la sentencia SELECT
- **executeUpdate(String):** Se utiliza para sentencias INSERT, UPDATE, DELETE, CREATE, DROP, ALTER. Devuelve el número de filas afectadas y para las sentencias DDL devuelve 0.
- **execute(String):** Se pude usar para cualquier sentencia. Devuelve true si devuelve un ResulSet (getResultSet) y false si devuelve un recuento de filas (getUpdateCount)

4. [Execute](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_02_Conectores/P01_MySQL/EJ_04_Execute.java)
5. [ExecuteUpdate](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_02_Conectores/P01_MySQL/EJ_05_ExecuteUpdate.java)
6. [Vista](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_02_Conectores/P01_MySQL/EJ_06_CrearVista.java)
7. [Sentencia Preparada](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_02_Conectores/P01_MySQL/EJ_07_SentenciaPreparada.java)

### Declaración de llamadas a procedimientos y funciones

	- {call nombre_procedimiento}: sin parámetros
	- { ? = call nombre_funcion}: devuelve un valor
	- {call nombre_procedimiento(?,?,...)}: recibe parámetros
	- {? = nombre_funcion(?,?,...)}: devuelve un valor (primer parámetro) y recibe varios parámetros

8. [Procedimiento_subida_sal](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_02_Conectores/P01_MySQL/EJ_08_Procedimiento_subida_sal.java)
9. [Funcion_nombre_dept](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_02_Conectores/P01_MySQL/EJ_09_Funcion_nombre_dept.java)
10. [Procedimiento_datos_dept](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_02_Conectores/P01_MySQL/EJ_10_Procedimiento_datos_dept.java)

### Transacciones

[Canal makigas](https://www.youtube.com/channel/UCQufRmIMRTLdRxTsXCh4-5w) 
- [Transacciones, commits y rollbacks (parte 1)](https://www.youtube.com/watch?v=oDo8Kr9YqE8)
- [Transacciones, commits y rollbacks (parte 2)](https://www.youtube.com/watch?v=v4EBceRzDUE)

![Esquema](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_02_Conectores/P01_MySQL/images/transacciones_jdbc.png)


## ACTIVIDADES

### ACTIVIDAD 1

- Crea un programa que se conecte a una base de datos SQLite (local). El programa creará una tabla con 6 campos de diferentes tipos. Implementa métodos diferentes para realizar las operaciones básicas sobre una BD (CRUD).**Solución:** [SQLite](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_02_Conectores/P01_MySQL/AD_1_SQLite.java) 


### ACTIVIDAD 2
- Añade una interfaz gráfica al ejercicio anterior que permita visualizar cada campo de la tabla en función del ID de la tabla. De contener botones para insertar, eliminar y modificar un registro de la tabla. Un botón para salir y otro para limpiar los datos.


### ACTIVIDAD 3

1. Crea un DB en db4free con las sentencias que aparecen en el fichero [dpto_empleados](https://github.com/franlu/DAM-AD/blob/master/UD2-Conectores/mysql/sql/dpto_empleados.sql)

2. Visualiza el número y nombre de todos los departamentos.
3. Modificar el nombre de un departamento cuyo número (y nombre) se pasen como argumento. No utilizar sentencias preparadas. Visualizar el número de filas afectadas.
4. Realiza el ejercicio anterior con sentencias preparadas.
5. Crea una clase para acceso a la base de datos *empleados* con los siguientes
métodos. Controlar errores y utilizar sentencias preparadas:
	- Conectar a la base de datos (carga del driver y establecimiento de conexión).
	- Insertar un departamento. El método recibirá tres argumentos (número, nombre y localidad).
	- El mismo que el anterior pero recibiendo un solo argumento, un objeto de la clase departamento. Será necesario por 		tanto crear una clase departamento, con sus atributos y métodos getter y setter.
	- Método que devuelva un ArrayList de objetos departamento ante la consulta de todas las columnas de todos los 	departamentos de la tabla dept
	- Método que reciba un número de departamento y devuelva sus datos mediante un objeto.
	- Método que reciba un objeto departamento y actualice la tabla dept.
	- Método que reciba un número de departamento y lo dé de baja.
	- Ídem del anterior pero devolviendo el número de filas afectadas.
	- Método que reciba un número de departamento y actualice su localidad (segundo argumento del método). Utilizar el siguiente procedimiento:
	```
	delimiter $$
	CREATE PROCEDURE actualizaDept(cod INT(2), localidad VARCHAR(13))
	BEGIN
	UPDATE Dept SET loc=localidad WHERE deptno = cod;
	END;
	```
**Solución:** [AD_3_CrearBD_y_Metodos](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_02_Conectores/P01_MySQL/AD_3_CrearBD_y_Metodos.java) 	
