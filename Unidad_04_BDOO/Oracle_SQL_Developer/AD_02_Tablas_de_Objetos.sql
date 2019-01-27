-----ACTIVIDADES: TABLAS DE OBJETOS-----

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

--Posteriormente, realiza consultas que visualicen:
	-- Nombre del alumno y la nota media.
    SELECT A.PER.NOMBRE, (A.EVA1+A.EVA2+A.EVA3)/3 AS NOTA_MEDIA FROM ALUMNOS A;
	--Alumnos cuya ciudad sea Tarazona y la nota media mayor que 7.
	--Nombre del alumno con la nota media más alta.
	--Nombre del alumno con la nota más alta (en cualquiera de sus notas).
  
  --Seleccionar filas cuya *Ciudad* sea TUDELA
  SELECT * FROM ALUMNOS A WHERE A.PER.DIREC.CIUDAD = 'TUDELA';

  --Consulta columnas individuales. Si la columna es un objeto, es necesario definir
  --un *alias* para la tabla; La recomendación es utilizar alias siempre. 
  --Por ejemplo, para el CODIGO y la DIRECCION de los alumnos:
  SELECT CODIGO, A.PER.DIREC FROM ALUMNOS A;

  --Consultas sobre métodos. Se invocan mediante su nombre y los argumentos que
  --reciban entre paréntesis, o los paréntesis vacíos en caso de no haber argumentos. 
  SELECT A.PER.NOMBRE, A.PER.DIREC.GET_CALLE() FROM ALUMNOS A;