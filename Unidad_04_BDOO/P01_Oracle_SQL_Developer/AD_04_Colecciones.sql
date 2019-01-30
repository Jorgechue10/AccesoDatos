-----ACTIVIDADES: COLECCIONES-----

--Crea un VARRAY de 3 elementos de tipo Persona.
CREATE TYPE ARRAY_PERSONA AS VARRAY(3) OF PERSONA;

--Crea una tabla denominada GRUPOS, con dos columnas:
  --NOMBRE_GRUPO VARCHAR2(25)
  --varray definido previamente
CREATE TABLE GRUPOS(
  NOMBRE_GRUPO VARCHAR2(25),
  PER ARRAY_PERSONA
);

--Inserta datos en la tabla de grupos (3 grupos) mediante un procedimiento.
CREATE OR REPLACE PROCEDURE INSERTAR_GRUPOS (NOMBRE VARCHAR2, PERSONAS ARRAY_PERSONA) AS
BEGIN
  INSERT INTO GRUPOS VALUES(NOMBRE, PERSONAS);
END;

--LLAMADA AL PROCEDIMIENTO
BEGIN
  INSERTAR_GRUPOS('Alumnos', ARRAY_PERSONA(
  PERSONA(10, 'Pedro', DIRECCION ('C/Mayor 12', 'Tarazona', 50500), '18/12/1998'),
  PERSONA(11, 'Juan', DIRECCION ('C/Rafael 14', 'Novallas', 50510), '05/03/1995'),
  PERSONA(12, 'Manuel', DIRECCION ('C/Nueva 27', 'Tudela', 31500), '14/08/1999')));
  
  INSERTAR_GRUPOS('Profesores', ARRAY_PERSONA(
  PERSONA(40, 'Raúl', DIRECCION ('C/Moncayo 2', 'Tarazona', 50500), '18/01/1982'),
  PERSONA(41, 'Eduardo', DIRECCION ('C/San Juan 25', 'Novallas', 50510), '26/03/1984')));
  
  INSERTAR_GRUPOS('Conserjes', ARRAY_PERSONA(
  PERSONA(42, 'Iñaki', DIRECCION ('C/Marrodán 9', 'Tarazona', 50500), '19/11/1979')));
  COMMIT;
END;

SELECT * FROM GRUPOS;

--Recorre la tabla grupos mostrando la información de cada grupo (nombre del
--grupo y datos de sus miembros).
DECLARE
  CURSOR C1 IS SELECT * FROM GRUPOS;
  CAD VARCHAR2(50);
BEGIN
  FOR I IN C1 LOOP
    DBMS_OUTPUT.PUT_LINE('Nombre del grupo: ' || I.NOMBRE_GRUPO || 
    ', Número de personas del grupo: ' || I.PER.COUNT);
    CAD := '';
    
  --Recorrido del VARRAY
  FOR J IN 1 .. I.PER.COUNT LOOP
    CAD := CAD || I.PER(J).NOMBRE || ' (' || I.PER(J).DIREC.CIUDAD || ') ';
  END LOOP;
  DBMS_OUTPUT.PUT_LINE(CAD);
  END LOOP;
END;