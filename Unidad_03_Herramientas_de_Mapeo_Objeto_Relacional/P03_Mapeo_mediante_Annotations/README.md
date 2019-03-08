## Mapear desde Java a MySQL mediante Java Annotations


Para realizar esta operación no hace falta el uso de ficheros XML, se usarán Anotaciones Java en el propio código. Estas anotaciones permiten especificar de una forma más sencilla (y breve) la información de mapeo de las clases Java. Hará falta:


- El archivo de configuración para conectarse con la BD ([hibernate.cfg.xml](hibernate.cfg.xml)). En el que habrá que indicarle donde se encuentran las clases que queremos mapear. <mapping class="P03_Mapeo_mediante_Annotations.Jugadores"/>


- Las clases que queramos mapear con sus anotaciones ([Jugadores](Jugadores.java), [Estadisticas](Estadisticas.java), [Equipos](Equipos.java)). 


### EJEMPLO


- [HibernateUtils](HibernateUtils.java). -Para poder utilizar Hibernate hace falta inicializar el entorno y obtener el objeto Session mediante SessionFactory, esto lo realizaremos mediante esta clase. Además, es necesario cargar la configuración (el fichero .cfg.xml) mediante la llamada al método configure(). El objetivo final es crear la SessionFactory que nos permita obtener objetos Session. Las clases que utilicemos para realizar operaciones con la BD necesitarán usar esta clase para abrir uns sesión con la BD.


- [EJ_PruebaHibernate](EJ_PruebaHibernate.java). -Clase que realiza unas consultas básicas a la BD y realiza una inserción.


### ACTIVIDAD

- [AD_Consultas](AD_Consultas.java). -Ejercicio en el que se realizan consultas más complejas.