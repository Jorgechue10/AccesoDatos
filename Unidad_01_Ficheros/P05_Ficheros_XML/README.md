# MANEJO DE FICHEROS XML

Interfaces para usar DOM

- **Document:** Objeto equivalente a un documento XML.
- **Element:** Objeto equivalente a un elemento del documento XML.
- **Node:** Representa cualquier nodo del documento.
- **NodeList:** Lista con los nodos hijos de un nodo.
- **Attr:** Permite acceder a los atributos de un nodo.
- **Text:** Son los datos carácter de un elemento.
- **CharacterData:** Atributos y métodos para manipular los datos de caracteres.
- **DocumentType:** Información de la etiqueta DOCTYPE.

## EJEMPLOS

-Ejemplo 1. Creación documento XML:

- [Cancion](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_01_Ficheros/P05_Ficheros_XML/EJ_1_1_Cancion.java)
-Clase que crea un objeto Cancion con sus respectivos atributos, contructor y métodos.


- [Generar_canciones](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_01_Ficheros/P05_Ficheros_XML/EJ_1_2_Generar_canciones.java)
-Clase que recibe objetos Cancion y los mete en un fichero de bytes.


- [Crear_cancion_XML](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_01_Ficheros/P05_Ficheros_XML/EJ_1_3_Crear_cancion_XML.java)
-Clase que crea un documento XML partiendo de un fichero de bytes.

-Ejemplo 2. Acceso a ficheros XML con **SAX** (API Simple para XML):

- [Prueba_Sax](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_01_Ficheros/P05_Ficheros_XML/EJ_2_1_PruebaSax.java)
-Clase que visualiza el contendio de un fichero XML.


**Actividad: ** Utiliza SAX para visualizar y contar el número de canciones que son españolas. **Solución:** [Actividad_Sax](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_01_Ficheros/P05_Ficheros_XML/EJ_2_2_ActividadSax.java)

-Ejemplo 3. Serialización de objetos a un documento XML:

- [ListaCanciones](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_01_Ficheros/P05_Ficheros_XML/EJ_3_1_ListaCanciones.java)
-Clase que crea un objeto ListaCanciones, que es una lista de tipo Cancion.


- [Escribir_Canciones](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_01_Ficheros/P05_Ficheros_XML/EJ_3_2_EscribirCanciones.java)
-Clase que escribe en el objeto ListaCanciones las canciones que contiene un fichero y las mete en un XML.


- [Leer_Canciones](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_01_Ficheros/P05_Ficheros_XML/EJ_3_3_LeerCanciones.java)
-Clase que lee con **XStream** un fichero XML de canciones.

-Ejemplo 4. Conversión a otros formatos:

- [Convertir_XML_HTML](https://github.com/Jorgechue10/AccesoDatos/blob/master/Unidad_01_Ficheros/P05_Ficheros_XML/EJ_4_Convertir_XML_HTML.java)
-Clase que convierte un documento XML en un fichero HTML.