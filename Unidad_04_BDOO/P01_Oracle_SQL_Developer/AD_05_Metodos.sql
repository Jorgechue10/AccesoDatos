-----ACTIVIDADES: MÉTODOS-----

/*ACTIVIDAD 1. Crear un método y el cuerpo correspondiente para calcular la nota 
media de un alumno, ponderando las tres evaluaciones en los siguientes porcentajes:
15% primera ev.      35% segunda ev.      50% tercera ev.*/

--Primero voy a crear un objeto alumno_ejercicio, ya que no me deja reemplazar
--el TYPE ALUMNO porque se está usando en otras tablas
CREATE OR REPLACE TYPE ALUMNO_EJERCICIO AS OBJECT (
  CODIGO NUMBER,
  EVA1 NUMBER,
  EVA2 NUMBER,
  EVA3 NUMBER,
  MEMBER FUNCTION CALCULAR_MEDIA RETURN NUMBER
);

--
CREATE OR REPLACE TYPE BODY ALUMNO_EJERCICIO AS

  MEMBER FUNCTION CALCULAR_MEDIA RETURN NUMBER IS
  MEDIA NUMBER;
  BEGIN
    MEDIA := EVA1 * 0.15 + EVA2 * 0.35 + EVA3 * 0.5;
    MEDIA := MEDIA/3;
    RETURN MEDIA;
  END;
END;

DROP TYPE ALUMNO_EJERCICIO;

--ACTIVIDAD 2. Crear un método MAP asociado que establezca el orden de los alumnos 
--por su nota media (sin ponderación).