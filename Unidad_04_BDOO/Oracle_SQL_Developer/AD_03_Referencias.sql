-----ACTIVIDADES: REFERENCIAS-----

--Crea un TIPO_DEPARTAMENTO.
CREATE OR REPLACE TYPE TIPO_DEPARTAMENTO AS OBJECT (
  DEPT_NUM NUMBER(2),
  DNOMBRE VARCHAR2(25),
  LOCALIDAD VARCHAR2(25));

--Crea una tabla del tipo definido previamente. Inserta datos en ella.
CREATE TABLE TABLA_DEPT OF TIPO_DEPARTAMENTO;

INSERT INTO TABLA_DEPT VALUES(1, 'Marketing', 'Tarazona');
INSERT INTO TABLA_DEPT VALUES(2, 'RRHH', 'Tudela');
INSERT INTO TABLA_DEPT VALUES(3, 'Producción', 'Novallas');
INSERT INTO TABLA_DEPT VALUES(4, 'Finanzas', 'Malón');
INSERT INTO TABLA_DEPT VALUES(5, 'Informática', 'Tarazona');

--Crea otra tabla con las columnas, una de ellas debe ser una *Referencia* al 
--tipo creado previamente TIPO_DEPARTAMENTO.
CREATE TABLE EMPLEADOS_DEPT (
  EMP_NUM NUMBER(4),
  APELLIDO VARCHAR2(25),
  SALARIO NUMBER(6,2),
  DEPT REF TIPO_DEPARTAMENTO);
 
--Rellena la tabla con datos de la tabla EMPLEADOS_DEPT. 
INSERT INTO EMPLEADOS_DEPT VALUES  (1, 'TUTOR', 1500, NULL);

UPDATE EMPLEADOS_DEPT E SET DEPT = (SELECT REF(D) FROM TABLA_DEPT D
WHERE D.DEPT_NUM = 1) WHERE E.EMP_NUM = 1;

SELECT * FROM EMPLEADOS_DEPT;

--Realiza consultas para recuperar el nº de empleado, apellido, número de 
--departamento y nombre de departamento de los empleados.  
SELECT EMP_NUM, APELLIDO, DEREF(D.DEPT).DEPT_NUM AS DEPT_NUM, 
DEREF(D.DEPT).DNOMBRE AS DNOMBRE FROM EMPLEADOS_DEPT D;