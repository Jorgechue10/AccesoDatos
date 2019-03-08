## Mapear desde Java a MySQL mediante XML (ficheros .hbm.xml)

Los ficheros necesarios para realizar esta operación serán:


- [hibernate.cfg.xml](hibernate.cfg.xml). Archivo de configuración para conectarse con la BD. Habrá que indicarle la ruta de los ficheros .hbm.xml que queremos mapear: <mapping resource="P01_Tablas_Mapeadas_a_Java/Equipos.hbm.xml"/>


- Los archivos .hbm.xml de cada clase con la información que permita mapear la clase a una base de datos relacional. 


**Nota**: en los ejemplos realizados cogeremos los ficheros .hbm.xml generados al mapear las tablas a java, que se encuentran en el paquete 1, para así reutilizar código.


### EJEMPLO


-[HibernateUtils](HibernateUtils.java). -Para poder utilizar Hibernate hace falta inicializar el entorno y obtener el objeto Session mediante SessionFactory, esto lo realizaremos mediante esta clase. Además, es necesario cargar la configuración (el fichero .cfg.xml) mediante la llamada al método configure(). El objetivo final es crear la SessionFactory que nos permita obtener objetos Session.


-[HibernateAplicacion](HibernateAplicacion.java). -Clase que va a abrir una sesión, usando la clase HibernateUtils, para poder realizar una insercción en la BD.