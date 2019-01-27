---------MÉTODOS------- SIN ACABAR

--De forma habitual, en programación orientada a objetos, cuando se define una 
--clase también se establecen los métodos que modelan su comportamiento. En el 
--contexto que nos ocupa, los métodos son procedimientos y funciones que se 
--especifican después de los atributos del objeto. Pueden ser de varios tipos: 
--MEMBER, CONSTRUCTOR Y STATIC.

--Primero se crea el tipo de objeto.
CREATE OR REPLACE TYPE RECTANGULO AS OBJECT(
  BASE NUMBER,
  ALTURA NUMBER,
  AREA NUMBER,
  STATIC PROCEDURE PROC1 (ANCHO INTEGER, ALTO INTEGER),
  MEMBER PROCEDURE PROC2 (ANCHO INTEGER, ALTO INTEGER),
  CONSTRUCTOR FUNCTION RECTANGULO (BASE NUMBER, ALTURA NUMBER)
        RETURN SELF AS RESULT
);