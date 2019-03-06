-----ACTIVIDADES: MÉTODOS-----

/*ACTIVIDAD 1. Crear un método y el cuerpo correspondiente para calcular la nota 
media de un alumno, ponderando las tres evaluaciones en los siguientes porcentajes:
15% primera ev.      35% segunda ev.      50% tercera ev.*/

--Primero voy a borrar la tabla alumnos para poder reemplazar el type ALUMNO,
--después lo reemplazo haciendo un llamamiento a la función en la declaración del type
--y por último creo la función para el type ALUMNO
DROP TABLE ALUMNOS;

CREATE OR REPLACE TYPE ALUMNO AS OBJECT (
  CODIGO NUMBER,
  PER PERSONA,
  EVA1 NUMBER,
  EVA2 NUMBER,
  EVA3 NUMBER,
  MEMBER FUNCTION CALCULAR_MEDIA RETURN NUMBER
);

--
CREATE OR REPLACE TYPE BODY ALUMNO AS

  MEMBER FUNCTION CALCULAR_MEDIA RETURN NUMBER IS
  MEDIA NUMBER;
  BEGIN
    MEDIA := EVA1 * 0.15 + EVA2 * 0.35 + EVA3 * 0.5;
    MEDIA := MEDIA/3;
    RETURN MEDIA;
  END;
END;

--Vuelvo a crear la tabla alumnos que he eliminado anteriormente para que ahora
--los objetos de esa tabla si que dispongan de la función CALCULAR_MEDIA
--Crea la tabla *ALUMNOS* del tipo *ALUMNO* creado previamente e inserta objetos
--en ella. 
CREATE TABLE ALUMNOS OF ALUMNO (
  CODIGO PRIMARY KEY
);

INSERT INTO ALUMNOS VALUES( 
  1, PERSONA(1, 'Juan Pérez ', DIRECCION ('C/Los manantiales 5', 'GUADALAJARA', 19005),
  '18/12/1991'), 10, 9, 10
);

INSERT INTO ALUMNOS VALUES( 
  2, PERSONA(2, 'Jorge Chueca ', DIRECCION ('C/Mayor 7', 'TARAZONA', 50500),
  '18/12/1999'), 10, 8, 9
);

INSERT INTO ALUMNOS VALUES( 
  3, PERSONA(3, 'Oscar Tutor ', DIRECCION ('C/Visconti 21', 'TUDELA', 31500),
  '18/12/1997'), 9, 10, 9
);

INSERT INTO ALUMNOS VALUES( 
  4, PERSONA(4, 'Alex San Esteban ', DIRECCION ('C/Los laureles 31', 'NOVALLAS', 50510),
  '18/12/1997'), 9, 9, 8
);

INSERT INTO ALUMNOS VALUES( 
  5, PERSONA(5, 'Antonio Bruna', DIRECCION ('C/Tudela 12', 'NOVALLAS', 50510),
  '18/12/1997'), 8, 9, 9
);

SELECT * FROM ALUMNOS;

--Posteriormente realiza:
  -- Nombre del alumno y la nota media.
	--Alumnos cuya ciudad sea Tarazona y la nota media mayor que 7.
	--Nombre del alumno con la nota media más alta.
	--Nombre del alumno con la nota más alta (en cualquiera de sus notas).

--ACTIVIDAD 2. Crear un procedimiento que establezca el orden de los alumnos 
--por su nota media (sin ponderación). 
--¡¡¡¡¡¡¡¡¡(NO FUNCIONA)!!!!!
CREATE OR REPLACE PROCEDURE ORDENAR_ALUMNOS_POR_NOTA AS
BEGIN
  SELECT A.PER.NOMBRE, (A.EVA1 + A.EVA2 + A.EVA3)/3 AS NOTA_MEDIA FROM ALUMNOS A;
END;