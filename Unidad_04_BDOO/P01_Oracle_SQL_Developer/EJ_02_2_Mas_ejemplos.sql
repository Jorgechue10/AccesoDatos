--CREACIÓN DE UNA TABLA EN LA QUE UNA COLUMNA UTILIZA UN TIPO DE OBJETO
CREATE OR REPLACE TYPE direccion_t AS OBJECT(
  calle VARCHAR2(200),
  ciudad VARCHAR2(200),
  prov CHAR(20),
  codpos VARCHAR2(20));
  
  
CREATE OR REPLACE TYPE cliente_t AS OBJECT (
  clinum NUMBER,
  clinomb VARCHAR2(200),
  direccion direccion_t,
  telefono VARCHAR2(20),
  fecha_nac DATE,
  MEMBER FUNCTION edad RETURN NUMBER,
  PRAGMA RESTRICT_REFERENCES(edad,WNDS));
  
  
CREATE OR REPLACE TYPE BODY cliente_t AS
MEMBER FUNCTION edad RETURN NUMBER IS
  anio NUMBER;
  d DATE;
  BEGIN
    d:= sysdate;
    anio:= TO_NUMBER(TO_CHAR(d, 'YYYY')) - TO_NUMBER(TO_CHAR(fecha_nac, 'YYYY'));
    IF (TO_NUMBER(TO_CHAR(d, 'mm')) < TO_NUMBER(TO_CHAR(fecha_nac, 'mm'))) OR
    (TO_NUMBER(TO_CHAR(d, 'mm')) = TO_NUMBER(TO_CHAR(fecha_nac, 'mm')))
    AND (TO_NUMBER(TO_CHAR(d, 'dd')) < TO_NUMBER(TO_CHAR(fecha_nac, 'dd')))
      THEN anio:= anio-1;
    END IF;
    RETURN anio;
  END;
END;


CREATE TABLE clientes_antiguos_tab (
  año NUMBER,
  cliente CLIENTE_T);
  
  
INSERT INTO CLIENTES_ANTIGUOS_TAB VALUES(2012, cliente_t(1001, 'Juan Andrés Ruiz',
      direccion_t('Paseo Independencia', 'Zaragoza', 'Zaragoza', '50001'),
      '976111111','16/01/2013'));
INSERT INTO CLIENTES_ANTIGUOS_TAB VALUES(2012, cliente_t(900, 'Ana Clemente',
      direccion_t('Paseo Miraflores', 'Villamayor','Zaragoza','50201'),
      '976112222', '16/01/1998'));

select * from clientes_antiguos_tab;
select año from clientes_antiguos_tab;
select c.cliente.clinum from clientes_antiguos_tab c;
select c.cliente.clinomb from clientes_antiguos_tab c;
select c.cliente.direccion.calle from clientes_antiguos_tab c;
select año, c.cliente.clinum,c.cliente.direccion.calle,c.cliente.telefono 
from clientes_antiguos_tab c;
select año, c.cliente.clinum, c.cliente.clinomb, c.cliente.direccion.calle, 
c.cliente.edad() from clientes_antiguos_tab c;

select año from clientes_antiguos_tab;
select c.cliente.clinomb from clientes_antiguos_tab c where c.cliente.clinum='1001';

select c.cliente.clinum NUMERO,c.cliente.clinomb NOMBRE from clientes_antiguos_tab c
order by c.cliente.clinum;

UPDATE clientes_antiguos_tab c SET c.cliente.telefono='6666666' WHERE c.cliente.clinum='900';

select c.cliente.clinum NUMERO,c.cliente.clinomb NOMBRE , c.cliente.telefono TELEFONO 
from clientes_antiguos_tab c order by c.cliente.clinum;

DELETE FROM clientes_antiguos_tab c WHERE c.cliente.clinum='900';