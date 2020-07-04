# Programación de componentes de acceso a datos.

## Introducción

El desarrollo de software basado en componentes (DSBC o CBD en inglés) constituye una aproximación del desarrollo de software que describe, construye y emplea técnicas software para elaborar sistemas abiertos y distribuidos, mediante el ensamblaje de partes software reutilizables. El surgimiento de este paradigma supone una extensión a la programación orientada a objetos y viene dada por la necesidad de ensamblar módulos independientes y supone una extensión a la paradirma de desarrollo orientado a objetos.

## Componentes. Definición.

Según Szyperski (1998), *Un componente software es una unidad de composición en formato ejecutable con interfaces especificadas contractualmente y dependencias explícitas del contexto. Un componente software se puede instalar independientemente y está sujeto a composición por terceros. Además, no tienen estado observable.*

El objetivo del uso de componentes es facilitar la construcción de aplicaciones mediante módulos reutilizables, diseñados previamente de forma independiente de la aplicación final en la que se ensamblan. 

[Más info UNICAN PDF ES](https://www.ctr.unican.es/asignaturas/MC_OO/Doc/Componentes_0910.pdf)

### Características

* Independencia de la plataforma.
* Son genéricos.
* Son identificables.
* Son Autocontenidos, es decir, no necesitan utilizar otros para hacer su cometido y deben poder ser distribuidos como *paquetes*.
* Son reemplazables por otros componentes.
* Proporcionan acceso a través de una interfaz (y solo a través de ella).
* La implementación puede variar pero no la interfaz.
* Necesidad de documentación adecuada.
* Reutilización en tiempo de ejecución.

Las tecnologías que se basan en componentes definen dos conceptos a la hora de implementar, empaquetar o especificar los componentes:

* Modelo de componentes. *Es una definición de estándares para la implementación, documentación y el despliegue de componentes. Por lo tanto, define la forma de sus interfaces y los mecanismos para interconectarlos entre ellos (p.e. COM, JavaBeans o CORBA).*

* Plataforma de componentes. Es la implementación basada en un modelo concreto; *una plataforma de componentes es un entorno de de- sarrollo y de ejecución de componentes que permite aislar la mayor parte de las dificultades conceptuales y técnicas que conlleva la construcción de aplicaciones basadas en los componentes de ese modelo.*

La tecnología concreta de componentes que se verá aquí son los JavaBeans (basados en Java y por tanto multiplataforma), pero hay más; .NET, COM, COM+ (Microsoft Windows).

## Javabeans

[Introducción a los JavaBeans](http://www.programandoapasitos.com/2015/11/acceso-datos-introduccion-los-javabeans.html)

## DAO

*Un __objeto de acceso a datos__ (en inglés, data access object, abreviado DAO) es un componente de software que suministra una interfaz común entre la aplicación y uno o más dispositivos de almacenamiento de datos, tales como una Base de datos o un archivo.* [Fuente](https://es.wikipedia.org/wiki/Objeto_de_acceso_a_datos)

* [Intro DAO](http://www.programandoapasitos.com/2016/03/acceso-datos-bases-de-datos-orientadas.html)

* [Patrón DAO](http://chuwiki.chuidiang.org/index.php?title=Patrón_DAO)

* [Ejemplo Spring DAO](http://chuwiki.chuidiang.org/index.php?title=Ejemplo_sencillo_con_SpringFramework_DAO)


## Factory

## MVC

## Recursos

* [Ejemplo DAO MVC](https://github.com/Jorgechue10/AccesoDatos/tree/master/Unidad_06_Ejemplo_DAO_MVC)
* [Drivers Java MongoDB](https://repo1.maven.org/maven2/org/mongodb/mongo-java-driver/)