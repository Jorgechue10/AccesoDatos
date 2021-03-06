---------TIPOS DE OBJETOS------------------

--CREACI�N DEL TIPO DE OBJETO DIRECCION
CREATE OR REPLACE TYPE DIRECCION AS OBJECT
(
  CALLE  VARCHAR2(25),
  CIUDAD VARCHAR2(20),
  CODIGO_POST NUMBER(5),
  MEMBER PROCEDURE SET_CALLE(C VARCHAR2),
  MEMBER FUNCTION GET_CALLE RETURN VARCHAR2  
);

--CREACI�N DE M�TODOS GETTERS Y SETTERS 
CREATE OR REPLACE TYPE BODY DIRECCION AS
  MEMBER PROCEDURE SET_CALLE(C VARCHAR2) IS
  BEGIN
    CALLE := C;
  END;
  --
  MEMBER FUNCTION GET_CALLE RETURN VARCHAR2 IS
  BEGIN
    RETURN CALLE;
  END;
END;

----USO DEL TIPO DIRECCION
DECLARE
  DIR DIRECCION := DIRECCION(NULL,NULL,NULL);
BEGIN
  DIR.SET_CALLE('La Mina, 3');
  DBMS_OUTPUT.PUT_LINE(DIR.GET_CALLE); 
  
  DIR := NEW DIRECCION ('C/Madrid 10','Toledo',45002);
  DBMS_OUTPUT.PUT_LINE(DIR.GET_CALLE); 
END;

--CREACI�N DEL TIPO DE OBJETO PERSONA
CREATE OR REPLACE TYPE PERSONA AS OBJECT
(
  CODIGO NUMBER,
  NOMBRE VARCHAR2(35),
  DIREC  DIRECCION,
  FECHA_NAC DATE
);

--PROBANDO TIPOS
DECLARE
  DIR DIRECCION := DIRECCION(NULL,NULL,NULL);
  P PERSONA     := PERSONA(NULL,NULL,NULL,NULL);
  DIR2 DIRECCION;  -- SE INICIA CON NEW
  P2 PERSONA;      -- SE INICIA CON NEW
BEGIN  
  DIR.CALLE:='La Mina, 3';  
  DIR.CIUDAD:='Guadalajara'; 
  DIR.CODIGO_POST:=19001; 
  --
  P.CODIGO:=1; 
  P.NOMBRE := 'JUAN'; 
  P.DIREC := DIR; 
  P.FECHA_NAC := '10/11/1988';
  DBMS_OUTPUT.PUT_LINE('NOMBRE: ' ||P.NOMBRE ||
         ' * CALLE:'||P.DIREC.CALLE);
  --
  DIR2 := NEW DIRECCION ('C/Madrid 10','Toledo',45002);
  P2:= NEW PERSONA(2,'JUAN', DIR2, SYSDATE);
  DBMS_OUTPUT.PUT_LINE('NOMBRE: ' ||P2.NOMBRE || 
     ' * CALLE: '  ||P2.DIREC.CALLE );  
END;