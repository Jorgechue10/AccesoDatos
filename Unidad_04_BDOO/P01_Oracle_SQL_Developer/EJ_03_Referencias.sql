-----REFERENCIAS-----

/*Mediante el operador REF asociado a un atributo se pueden definir referencias 
a otros objetos. Un atributo de este tipo almacena una referencia al objeto del 
tipo definido e implementa una relación de asociación entre los dos tipos de 
objetos. Así, una columna de tipo REF guarda un puntero a una fila de la otra 
tabla, contiene el OID (identificador del objeto fila) de dicha fila.*/

-- Inserción y acceso con referencias

--Creamos un tipo EMPLEADO_T donde uno de los atributos es una referencia 
--a un objeto EMPLEADO_T.
CREATE TYPE EMPLEADO_T AS OBJECT (
  NOMBRE VARCHAR2(50),
  JEFE REF EMPLEADO_T
);

--Posteriormente se crea una tabla de objetos EMPLEADO_T.
CREATE TABLE EMPLEADO OF EMPLEADO_T;

--Inserción de filas en la tabla.
--Primero insertamos un empleado que será el jefe.
INSERT INTO EMPLEADO VALUES (EMPLEADO_T ('PEREZ', NULL));

--Ahora insertamos dos empleados que tiene como jefe el empleado anterior.
--Se inserta como atributo JEFE la referencia al empleado insertado previamente
--con el apellido PEREZ
INSERT INTO EMPLEADO SELECT EMPLEADO_T ('LOPEZ', REF(E))
FROM EMPLEADO E WHERE E.NOMBRE = 'PEREZ';

INSERT INTO EMPLEADO SELECT EMPLEADO_T ('MARTINEZ', REF(E))
FROM EMPLEADO E WHERE E.NOMBRE = 'PEREZ';

--Para poder acceder al objeto referido por un REF se utiliza DEREF.
--Se visualiza el nombre del empleado y los datos del jefe correspondiente
SELECT NOMBRE, DEREF(P.JEFE) FROM EMPLEADO P;

--Devuelve el identificador del objeto cuyo nombre es PEREZ
SELECT REF(P) FROM EMPLEADO P WHERE NOMBRE='PEREZ';

--Devuelve el nombre del empleado y el del jefe
SELECT NOMBRE, DEREF(P.JEFE).NOMBRE FROM EMPLEADO P;

--Se modifica el jefe de Martinez, que pasa a ser Lopez
UPDATE EMPLEADO SET JEFE = (SELECT REF(E) FROM EMPLEADO E WHERE NOMBRE = 'LOPEZ')
WHERE NOMBRE = 'MARTINEZ';