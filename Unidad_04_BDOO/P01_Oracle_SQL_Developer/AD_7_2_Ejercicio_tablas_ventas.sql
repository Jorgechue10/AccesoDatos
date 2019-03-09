/*Crear una función que reciba un identificador de venta y devuelva la cantidad de la venta.
Comprobar si la venta existe, devolviendo -1 en caso negativo. Ejecuta esta función mediante
un bloque PL/SQL*/
CREATE OR REPLACE FUNCTION TOTAL_VENTA(IDEN NUMBER) RETURN NUMBER IS
  EXISTEID NUMBER;
  CANTIDAD NUMBER;
  BEGIN
    --COMPROBAR SI EXISTE ID
  SELECT COUNT(IDVENTA) INTO EXISTEID FROM TABLA_VENTAS WHERE IDVENTA = IDEN;
  
  IF EXISTEID = 0 THEN
      RETURN -1;
  END IF ;
  
  IF EXISTEID > 0 THEN
      SELECT SUM(TV.CANTIDAD) INTO CANTIDAD FROM TABLA_VENTAS, 
      TABLE(LINEAS) TV WHERE IDVENTA = IDEN;
      RETURN CANTIDAD;
  END IF ;
  
END;

--Llamada a la función
DECLARE CANTIDAD NUMBER;
BEGIN
  CANTIDAD := TOTAL_VENTA(2);
  DBMS_OUTPUT.PUT_LINE(CANTIDAD);
END;

--Hago una consulta para comprobar que los resultados son correctos
SELECT IDVENTA, TV.* FROM TABLA_VENTAS, 
TABLE(LINEAS) TV;

/*Realiza una consulta que muestre para cada producto el total de unidades vendidas, el
identificador y la descripción del mismo.*/
SELECT DEREF(LINEA.IDPRODUCTO).IDPRODUCTO IDPROD,
        DEREF(LINEA.IDPRODUCTO).DESCRIPCION DESCRIP_PRODUCTO,
        LINEA.CANTIDAD
FROM TABLA_VENTAS TV, TABLE(TV.LINEAS) LINEA;