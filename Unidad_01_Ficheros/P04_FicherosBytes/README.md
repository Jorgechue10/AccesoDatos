# FICHEROS BYTES

## EJEMPLOS

-Ejemplo 1. [LeerEscribirBytes](EJ_1_LeerEscribirBytes.java)
-Clase que escribe **(FileOutputStream)** y lee **(FileInputStream)** datos sobre un fichero binario.

-Ejemplo 2. [DatosPrimitivos](EJ_2_DatosPrimitivos.java)
-Clase que escribe **(DataOutputStream)** y lee **(DataInputStream)** datos primitivos sobre un fichero binario.

-Ejemplo 3. Lectura/Escritura de objetos:

- [Persona](EJ_3_1_Persona.java)
-Clase que crea un objeto Persona con sus respectivos atributos, contructor y métodos.


- [Escritura_de_objetos](EJ_3_2_Escritura_de_objetos.java)
-Clase que escribe 5 objetos Persona en un fichero, usando la clase **(ObjectOutputStream)**.


- [Lectura_de_objetos](EJ_3_3_Lectura_de_objetos.java)
-Clase que lee los objetos Persona que contiene un fichero, usando la clase **(ObjectInputStream)**.

-Ejemplo 4. Ficheros aleatorios **(RandomAccessFile)**:

- [Escritura_fichero_aleatorio](EJ_4_1_Escritura_fichero_aleatorio.java)
-Clase que escribe en un fichero aleatorio.


- [Lectura_fichero_aleatorio](EJ_4_2_Lectura_fichero_aleatorio.java)
-Clase que lee todo el contenido de un fichero aleatorio.


- [Consulta_fichero_aleatorio](EJ_4_3_Consulta_fichero_aleatorio.java)
-Clase que realiza una consulta en un fichero aleatorio.


- [Insertar_final_fichero_aleatorio](EJ_4_4_Insertar_final_fichero_aleatorio.java)
-Clase que inserta datos al final del fichero aleatorio.


## ACTIVIDADES

### DATOS PRIMITIVOS

### ACTIVIDAD 1:

- Crea un programa en Java que escriba en un fichero de bytes (ad_1_edades.dat) una lista de 10 nombres y edades, utilizando la clase DataOutputStream. **Solución:** [Edades_Byte_Escritura](AD_1_1_EdadesByte_escritura.java)  
 
      
- Crea un programa en Java que lea de un fichero de bytes una lista de nombres y edades, debe enviar la lectura a la salida estándar. Utilizando la clase DataOutputStream. **Solución:** [Edades_Byte_Lectura](AD_1_2_EdadesByte_lectura.java)   
      

### LECTURA/ESCRITURA DE OBJETOS

### ACTIVIDAD 2:

- Crear la clase MovimientoBancario con los siguientes atributos: fecha, concepto, cantidad, tipo. Escribir constructor, getters y setters. Estos datos corresponden a los movimientos de una cuenta corriente. **Solución:** [MovimientoBancario](AD_2_1_MovimientoBancario.java)  
      
      
- Solicitar al usuario movimientos (usando MovimientoBancario) y almacenarlos en un fichero llamado ad_2_movimientosBancarios.dat. **Solución:** [MovimientoBancario_Escritura](AD_2_2_MovimientoBancario_escritura.java)  
     
      
- Leer del fichero las cantidades y mostrar un mensaje con el saldo actual de la cuenta. El atributo tipo es Boolean. En caso de ser true se estará indicando un ingreso, en caso contrario se retira dinero de la cuenta. **Solución:** [MovimientoBancario_Lectura](AD_2_3_MovimientoBancario_lectura.java)  


### FICHEROS ALEATORIOS:

### ACTIVIDAD 3:

Necesitamos una aplicación para gestionar una lista de reproducción de nuestras canciones favoritas. Esta lista se debe almacenara en un fichero de acceso aleatorio(archivo de bytes). Para cada canción se almacenan los siguientes datos: ID, Año, Título, Artista, Duración, Canción_española.
Se han de crear dos clases:
- Una clase para representar la Canción. **Solución:** [Cancion](AD_3_1_Cancion.java) 


- Otra clase para crear un menú de opciones sobre la lista.

  - La primera opción se utiliza para crea un fichero, el nombre del fichero será: ad_3_listaReproduccion.dat.


  - La segunda opción, recibe por teclado los datos de una canción e inserta en el fichero dicha información. Primero ha de comprobar si existe el ID de la canción, antes de insertar los nuevos datos. Si existe se informa al usuario.


  - La tercera opción debe consultar los datos de una canción del fichero aleatorio. Se solicitara a través de teclado un identificador de la canción. Si el ID existe se visualizaran los datos correspondientes en caso contrario se mostrara un mensaje de error.


  - Cuarta opción, se recibe el ID y el año de la canción. Se debe modificar el año de la canción. El programa debe visualizar el nombre de la canción, el año anterior y el nuevo año. Si el ID no existe, se informa al usuario.


  - Quinta opción, se recibe el ID de una canción y borra su información. Se hará un borrado lógico: el ID será igual a -1, el resto de datos se mantendrán igual.


  - Sexta opción, se deben mostrar las canciones borradas.


  - Séptima opción, se deben mostrar las canciones de la lista de reproducción.


  - Octava opción, salir del programa.
  
  **Solución:** [ListaReproduccionMain](AD_3_2_ListaReproduccionMain.java) 
