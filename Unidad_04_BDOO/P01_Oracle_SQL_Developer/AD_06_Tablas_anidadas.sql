-----ACTIVIDADES: TABLAS ANIDADAS-----

--Obtener el número de direcciones que tiene cada ciudad en los identificadores 1 y 2.
SELECT ID, APELLIDOS, CIUDAD, COUNT(*) AS NUMERO FROM EJEMPLO_TABLA_CONTENEDORA, TABLE(DIREC) TD
WHERE ID = 1 OR ID = 2 GROUP BY ID, CIUDAD, APELLIDOS ORDER BY ID;

--Obtener la ciudad con más direcciones para el identificador 1.
SELECT MAX(D.CIUDAD) FROM EJEMPLO_TABLA_CONTENEDORA, TABLE(DIREC) D WHERE ID = 1;

--Realizar un bloque PL/SQL para mostrar el nombre de las calles asociadas a cada apellido.
CREATE OR REPLACE PROCEDURE MOSTRAR_CALLES (APE VARCHAR2) AS
BEGIN
  SELECT APELLIDOS, CALLE FROM EJEMPLO_TABLA_CONTENEDORA, TABLE(DIREC) TD WHERE APELLIDOS = APE; 
END;

/*Realizar un procedimiento pra insertar direcciones en la tabla que contiene la tabla anidada * El
procedimiento debe: * Recibir un identificador y un objeto dirección como parámetros. * Comprobar
si el identificador existe, indicar en un mensaje si no existe. * Comprobar que la tabla anidada no sea
null, si es null debe hacerse update y no insert. * Comprobar que la dirección no exista en la tabla
previamente, si existe, indicar que no se puede insertar.*/