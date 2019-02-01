-----ACTIVIDADES: TABLAS ANIDADAS-----

--1. Obtener el número de direcciones que tiene cada ciudad en los 
--identificadores 1 y 2.

SELECT ID, APELLIDOS, CIUDAD, COUNT(*) AS NUMERO FROM EJEMPLO_TABLA_CONTENEDORA, TABLE(DIREC) TD
GROUP BY ID, CIUDAD, APELLIDOS ORDER BY ID;

--Obtener la ciudad con más direcciones para el identificador 1.
SELECT MAX(D.CIUDAD) FROM EJEMPLO_TABLA_CONTENEDORA, TABLE(DIREC) D WHERE ID = 1;

--Realizar un bloque PL/SQL para mostrar el nombre de las calles asociadas a cada apellido.
CREATE OR REPLACE PROCEDURE MOSTRAR_CALLES (APE VARCHAR2)
SELECT APELLIDOS, CALLE FROM EJEMPLO_TABLA_CONTENEDORA, TABLE(DIREC) TD WHERE APELLIDO = APE; 