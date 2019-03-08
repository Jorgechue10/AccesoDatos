## Bases de datos orientadas a objetos

*En una base de datos orientada a objetos, la información se representa mediante objetos como los presentes en la programación orientada a objetos... Un ODBMS hace que los objetos de la base de datos aparezcan como objetos de un lenguaje de programación en uno o más lenguajes de programación a los que dé soporte. Un ODBMS extiende los lenguajes con datos persistentes de forma transparente, control de concurrencia, recuperación de datos, consultas asociativas y otras capacidades.* [Wikipedia, Base de datos orientada a objetos](https://es.wikipedia.org/wiki/Base_de_datos_orientada_a_objetos)

### Características

De forma general, se puede decir que las ODBMS cumplen que:

* Los datos se almacenan como objetos POO.
* Cada objeto tiene atributos y métodos e interfaz de acceso al mismo. Los atributos y métodos tienen niveles de acceso.
* Los objetos poseen identificador único (OID).
* Cumplen las características generales de los DBMS relacionales:
	
	* Concurrencia
	* Persistencia
	* Recuperación de fallos
	* Almacenamiento secundario
	* Consultas

* Cumplen las de los lenguajes OO:
	
	* Encapsulamiento
	* Herencia
	* Polimorfismo
	* Modularidad
	* Identidad
	

#### Manifiesto Atkinson

Data de 1989, el nombre se debe a su promotor. Establece 13 características obligatorias para los ODBMS, basado en dos principios: ser un DBMS y ser orientado a objetos:

Características obligatorias de orientación a objetos:

1. Deben soportarse objetos complejos
2. Deben soportarse mecanismos de identidad de los objetos
3. Debe soportarse la encapsulación
4. Deben soportarse los tipos o clases
5. Los tipos o clases deben ser capaces de heredar de sus ancestros
6. Debe soportarse el enlace dinámico
7. El DML debe ser computacionalmente complejo
8. El conjunto de todos los tipos de datos debe ser ampliable
9. Debe proporcionarse persistencia a los datos
10. El DBMS debe ser capaz de gestionar bases de datos de muy gran tamaño
11. El DBMS debe soportar a usuarios concurrentes
12. El DBMS debe ser capaz de recuperarse de fallos hardware y software
13. El DBMS debe proporcionar una forma simple de consultar los datos.


#### Ventajas e Inconvenientes

Poseen mayor capacidad para modelar la información, es decir, ofrecen una aproximación más "real" ya que permiten encapsular los atributos y comportamientos de los objetos reales. Además, cada objeto contiene todas sus posibles relaciones y es posible hacer agrupaciones de objetos basadas en la herencia.

Por el contrario, no hay tantas referencias teóricas como en las DBMS tradicionales, y por ello no puede decirse que haya un modelo de datos universal, aceptado por todo el mundo. A consecuencia de esto, la experiencia de trabajo con estos sistemas es menor que con los DBMS tradicionales. Hay otros aspectos a mejorar como la optimización de las consultas o la seguridad.

[Más información](https://basedatosdistrib.wordpress.com/2014/05/06/6-base-de-datos-orientadas-a-objetos/)

### Estándar ODMG

Es un conjunto de normas con el objetivo de establecer normas comunes para todos los ODBMS. La última versión del mismo es la 3.0, del año 2001, y a grandes rasgos define:

* Modelo de objetos
* Conexión con lenguajes orientados a objetos (C++, Java y otros).
* Lenguaje de definición de objetos (ODL)
* Lenguaje de consulta de objetos (OQL)

#### Tipos de objetos

* Tipos escalares del lenguaje: float, double, int, string, char...
* Tipos estructurados: date, time, timestamp...
* Tipos colección: arrays, list, set, dictionary

#### Literales

Pueden ser de cualquiera de los tres tipos enumerados previamente, así como NULL.

#### Clases

Definen atributos y comportamientos para cada tipo de objeto. Van asociadas a un *extent*.

#### ODL

La definición del ODBMS está contenida en un esquema que se ha creado mediante el lenguaje de definición de objetos ODL (Object Definition Language), definido como parte del estándar. Las palabras reservadas de uso más común son:

* __attribute__: Declara un atributo.
* __array__: Declara un elemento de este tipo, hay similares para: __set__, __list__, o __bag__.
* __class__: Declara el objeto, comportamientos y estado de un tipo.
* __enum__: Para declarar tipos enumerados, a la idea de los de Java.
* __extends__: Herencia de clase.
* __extent__: Extensión o nombre para el conjunto de objetos de una clase, es el que se usa para las consultas.
* __inverse__: Relación inversa.
* __key__: Clave o claves que identifican las instancias de objetos.
* __relationship__: Para declarar una relación.
* __struct__: Tipo estructurado, a la manera de C++.


```java
class Cafeteria (extent Cafeterias􏰊)
􏰠{
	attribute string nombre;
	attribute string direccion;
	relationship Set<􏰜Venta􏰝> cervezasVendidas inverse Venta::cafeteria;	
}

Class Cerveza (extent Cervezas) 
{
	attribute string nombre;
	attribute string fabricante;
	relationship Set<Venta> vendidasPor inverse Venta::cerveza;
}


class Venta (extent Ventas)
{
	attribute float precio;
	relationship Cafeteria cafeteria inverse Cafeteria::cervezasVendidas;
	relationship Cerveza cerveza inverse Cerveza::vendidasPor;
}
```

[Más ejemplos ODL](http://www.programandoapasitos.com/2016/03/acceso-datos-bases-de-datos-orientadas.html)

### Lenguaje OQL

OQL es un lenguaje declarativo basado en SQL que permite realizar consultas de modo eficiente sobre bases de datos orientadas a objetos. Si bien, no posee primitivas para modificar el estado de los objetos, que se modifican a través de los métodos de dichos objetos.

La sintaxis básica de OQL es una estructura muy similar a SQL.

```sql
SELECT valores
FROM colecciones y/o miembros
WHERE condiciones
```

[Referencia, EN](https://docs.mendix.com/refguide/oql)

### NeoDatis Object Database

[NeoDatis ODB](http://neodatis.wikidot.com) es una base de datos sencilla orientada a objetos con soporte para Java y otros lenguajes orientados a objetos. Tras descargarla y descomprimir, se obtiene el fichero jar que permite acceder a su funcionalidad. 

[Recurso en castellano NeoDatis](http://www.programandoapasitos.com/2016/03/acceso-datos-neodatis.html)