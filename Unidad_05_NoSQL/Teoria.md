# Bases de Datos NoSQL

## Introducción

[Referencia UniCan](https://ocw.unican.es/pluginfile.php/2396/course/section/2473/Tema%201.%20NoSQL%20introduccio%CC%81n.pdf)

[Estadística de uso de bases de datos](https://db-engines.com/en/ranking)

## MongoDB

### Introducción

*MongoDB es una base de datos orientada a documentos. Esto quiere decir que en lugar de guardar los datos en registros, guarda los datos en documentos. Estos documentos son almacenados en BSON, que es una representación binaria de [JSON](https://developer.mozilla.org/es/docs/Learn/JavaScript/Objects/JSON).*

*Una de las diferencias más importantes con respecto a las bases de datos relacionales, es que no es necesario seguir un esquema. Los documentos de una misma colección - concepto similar a una tabla de una base de datos relacional -, pueden tener esquemas diferentes.* [Fuente](https://www.genbeta.com/desarrollo/mongodb-que-es-como-funciona-y-cuando-podemos-usarlo-o-no)



[Primeros pasos](https://guiadev.com/tutorial-mongodb/#Primeros_pasos_en_MongoDB)

### Instalación

[Instalación Windows](https://fastdl.mongodb.org/win32/mongodb-win32-x86_64-2008plus-ssl-4.0.5-signed.msi)

#### Clientes

* Hay clientes mediante línea de comandos y entorno gráfico. Veremos ejemplos en ambos casos. 
* El cliente gráfico a utilizar será el que se puede instalar junto al propio servidor [Mongo Compass](https://www.mongodb.com/products/compass).


### Estructuras JSON

* Colecciones de pares clave/valor.
* Lista ordenada de valores (P.Ej: arrays, etc.).

En JSON, las estructuras se presentan de dos formas:

* Objeto. Podría decirse que es un conjunto no ordenado de pares clave/valor expresado entre { y } (llaves). La clave y el valor asociado se separan mediante : (dos puntos). Cada par se separa del siguiente mediante una coma.

```json
{
  "active": true,
  "formed": 2016,
  "homeTown": "Metro City",
  "members": [
    {
      "age": 29,
      "name": "Molecule Man",
      "powers": [
        "Radiation resistance",
        "Turning tiny",
        "Radiation blast"
      ],
      "secretIdentity": "Dan Jukes"
    },
    {
      "age": 39,
      "name": "Madame Uppercut",
      "powers": [
        "Million tonne punch",
        "Damage resistance",
        "Superhuman reflexes"
      ],
      "secretIdentity": "Jane Wilson"
    },
    {
      "age": 1000000,
      "name": "Eternal Flame",
      "powers": [
        "Immortality",
        "Heat Immunity",
        "Inferno",
        "Teleportation",
        "Interdimensional travel"
      ],
      "secretIdentity": "Unknown"
    }
  ],
  "secretBase": "Super tower",
  "squadName": "Super hero squad"
}
```

* Array. Es una colección de valores encerrada por [ ]  (corchetes o square brackets).

```json
{
  "heroes": [
    {
      "age": 29,
      "name": "Molecule Man",
      "powers": [
        "Radiation resistance",
        "Turning tiny",
        "Radiation blast"
      ],
      "secretIdentity": "Dan Jukes"
    },
    {
      "age": 39,
      "name": "Madame Uppercut",
      "powers": [
        "Million tonne punch",
        "Damage resistance",
        "Superhuman reflexes"
      ],
      "secretIdentity": "Jane Wilson"
    }
  ]
}
```

* Valor. Puede ser de los siguientes tipos:

  * __String__: en UTF-8. Van siempre entre dobles comillas.
  * __Number__: números. Al guardarse en BSON admite los de tipo byte, int32, in64 o double.
  * __Boolean__: true o false.
  * __Array__: entre corchetes [] y pueden contener de 1 a N elementos, que pueden ser de cualquiera de los otros tipos.
  * __Documentos__: un documento en formato JSON puede contener otros documentos embebidos que incluyan más documentos o cualquiera de los tipos anteriormente descritos.
  * __Null__.



#### Validez JSON

* Hay multitud de sitios o aplicaciones que permiten comprobar si un objeto JSON es válido o no. Un par de ejemplos:

  * [JSONLint](https://jsonlint.com)

  * [JSONFormatter](https://jsonformatter.curiousconcept.com)

#### xml vs JSON

* TL;DR. JSON es más ligero y fácil de parsear. [Más en detalle](https://www.w3schools.com/js/js_json_xml.asp)

[Conversor online](http://www.utilities-online.info/xmltojson)


### Operaciones básicas iniciales en MongoDB

* En cualquier base de datos, el conjunto de operaciones básicas se denominan CRUD. Vemos ejemplos de éstas en MongoDB.

* ``` show databases o show dbs ```
* ``` use nombre_base_datos``` Si no existe la crea al insertar un objeto.
* ```db``` Referencia a la base de datos actual.
* ```show collections```
* ```db.help()``` Para consultar la ayuda.
* ```db.nombrecoleccion.help()``` Ayuda específica para colecciones.

#### Importar y exportar datos

* __mongoimport__ para importar datos creados con mongoexport
  
  * ```mongoimport --host localhost --port 27666 --db test --collection people --file data.json --jsonArray``` Desde un fichero JSON.

* __mongoexport__ para exportar datos (en JSON o CSV). No debe usarse para backups completos.

  * ```mongoexport --collection collectionName --out collection.json``` Simple
  * ```mongoexport -db dbName --collection collectionName --query '{"field": value}'``` Con una query
  * ```mongoexport.exe –db <myBD> –collection collectionName -csv –out path/to/file.csv –fields ``` A CSV
  
    * Dado que MongoDB usa tipos de datos BSON que no existen en JSON al exportarlos lo hace siguiendo unas reglas, por ejemplo data_date lo genera como Date( <date> )


* __mongodump__ para crear un export binario de los contenidos de una base de datos MongoDB. Debe usarse para backups.
* __mongorestore__ para recrear una base de datos a partir de un dump creado con mongodump

Más ejemplos: [Importar datos a MongoDB](https://www.todavianose.com/importar-en-mongodb/) 

### Crear registros. _Crud_

* ```save() o insert()``` Para añadir datos.


### Consultas. _cRud_

Para realizar consultas a la base de datos, debemos usar el comando db.nombre_de_coleccion.find(). El comando puede recibir dos parámetros: una consulta (los __filtros__) y una proyección(los __campos__). Ambos comandos son opcionales por lo que si ejecutamos el comando:

* ```db.jugadores.find()``` 

Se obtiene una lista con los primeros 20 elementos de la colección. Solo los primeros porque MongoDB no muestra todos los elementos. Para la consulta MongoDB crea un __cursor__. Para mostrar más documentos hay que escribir *it*.

Al ejecutar el comando anterior, el resultado no está formateado, por lo que es poco legible. Para solucionar este problema ese puede usar el modificador *pretty* que devolverá un resultado más legible.

### Filtrando las consultas.

Añadiendo consultas al comando find, filtra los elementos según las necesidades. Para ello se especifica un objeto JSON como primer parámetro del comando, con los campo por los que se quiere filtrar. Por ejemplo, jugadores en activo con el dorsal 23:

```javascript
db.jugadores.find(
    {jersey:23, isActive: true}
  ).pretty()
```

Los resultados muestran todos los campos de cada elemento. Es como utilizar el asterisco en una consulta SELECT. Si se desea seleccionar solo algunos de los campos, hay que utilizar el segundo parámetro de la consulta find para definir una __proyección__.

```javascript
db.jugadores.find(
    {jersey:23, isActive: true},
    {firstName:1, lastName:1} 
  ).pretty()

/*
    Devolverá nombre y apellido. Si en lugar de valor 1, se pasa 0, devuelve todos los campos SALVO los indicados con el 0.
*/
```

Otra función alternativa a __find()__ es __findOne()__ que devuelve solo la primera colección de las que cumplen con lo especificado en la consulta.

### Ordenando los resultados

* ```sort()``` Para ordenar. 1 ascendente, -1 desdendente.


### Operaciones de comparación

* __$eq__. Matches values that are equal to a specified value.
* __$gt__. Matches values that are greater than a specified value.
* __$gte__. Matches values that are greater than or equal to a specified value.
* __$in__. Matches any of the values specified in an array.
* __$lt__. Matches values that are less than a specified value.
* __$lte__. Matches values that are less than or equal to a specified value.
* __$ne__. Matches all values that are not equal to a specified value.
* __$nin__. Matches none of the values specified in an array.

[referencia oficial, EN](https://docs.mongodb.com/manual/reference/operator/query-comparison/)

### Operaciones lógicas

* __$and__. Joins query clauses with a logical AND returns all documents that match the conditions of both clauses.
* __$not__. Inverts the effect of a query expression and returns documents that do not match the query expression.
* __$nor__. Joins query clauses with a logical NOR returns all documents that fail to match both clauses.
* __$or__. Joins query clauses with a logical OR returns all documents that match the conditions of either clause.

[referencia oficial, EN](https://docs.mongodb.com/manual/reference/operator/query-logical/)

### Operaciones de tipo

* __$exists__. Matches documents that have the specified field.
* __$type__. Selects documents if a field is of the specified type.

[referencia oficial, EN](https://docs.mongodb.com/manual/reference/operator/query-element/)


### Actualizaciones. _crUd_

* ```update()``` Para actualizar registros.

* Un ejemplo:

```javascript 

db.coleccion.update(filtro, cambios, {
    upsert: boolean,
    multi: boolean
  })

// filtro especifica la condición de búsqueda, como en find.

// cambios debe recoger los cambios que se desea hacer. En esta variable se indica cómo debe quedar el documento si se cumple lo especificado en el filtro. Si un campo no se incluye, se eliminará tras la modificación. Esto exige actuar con cautela.
```

#### multi y upsert

*Por defecto MongoDB solo actualiza un documento a no ser que le indiquemos lo contrario. Es una manera de evitar errores. Para actualizar todos deberemos usar la opción multi que debe incluirse como se ve en el ejemplo anterior*

*Además de la opción multi, tenemos disponible la opción upsert, que lo que hace es insertar el documento si este no existe. Es bastante parecido al comando save que hemos visto en las operaciones de inserción En este caso se comprueba toda la consulta en lugar de solo el _id.*  [Fuente](https://charlascylon.com/2013-07-18-tutorial-mongodb-operaciones-de-actualización-de)

#### operadores Actualización

* __$set__. Para actualizar un documento o varios con nuevas propiedades.
* __$unset__. Para eliminar propiedades de un documento o varios.
* __$inc__. Incrementa campos numéricos en la cantidad especificada.
* __$rename__. Para renombrar campos de documentos.



[Tutorial ES](https://charlascylon.com/2013-07-18-tutorial-mongodb-operaciones-de-actualización-de)

### Eliminaciones. _cruD_

* ```remove()``` Para eliminar registros.


### Funciones de resumen

* __$sum__: suma (o incrementa)
* __$avg__: calcula la media
* __$min__: mínimo de los valores
* __$max__: máximo


### Operaciones con funciones de agregado.

De forma similar a las funciones de agregación de las bases de datos relacionales, en MongoDB hay una suite de funciones de agregado para computar los datos obtenidos en consultas, etc. Son las siguientes.

* [Funciones de agregación](http://gpd.sip.ucm.es/rafa/docencia/nosql/Agregando.html)

### Funciones para arrays:

* __$each__: Utilizado junto con las ya vistas addToSet o push para indicar que se añaden varios elementos a un array.
* __$pop__: Par eliminar el primer o último elemento de un array.
* __$pull__: Para eliminar los valores del array que cumplan con el filtro especificado.
* __$push__: Mete en un array un valor determinado
* __$addToSet__: Mete en un array los valore que digamos, pero solo una vez
* __$first__: obtiene el primer elemento del grupo, a menudo junto con sort
* __$last__: obtiene el último elemento, a menudo junto con sort
* __$elemMatch:__: Obtiene documentos que contienen campos array con al menos un elemento especificado como criterio de consulta.


### Funciones para cadenas de texto.

Las funciones específicas para las cadenas de texto son las siguientes y su cometido queda bastante bien explicado por el propio nombre de la función.

* __$concat__.  Concatena varias cadenas en una sola.
* __$toUpper__. Convierte a mayúsculas.
* __$toLower__. Convierte a minúsculas.
* __$substr__.  Devuelve un substring de una cadena existente.
* __$strcasecmp__. Compara cadenas sin tener en cuenta mayúsculas/minúsculas.


### Funciones aritméticas.

* __$abs__. Para obtener el valor absoluto.
* __$add__. Suma (en el caso de fechas añade milisegundos).
* __$ceil__. Entero inferior más cercano.
* __$divide__. División.
* __$exp__. e^x
* __$floor__. Entero superior más cercano.
* __$ln__. Logaritmo neperiano.
* __$log__. Devuelve el logaritmo para el número y la base indicados.
* __$log10__. Logaritmo en base 10.
* __$mod__. Módulo división entera.
* __$multiply__. Producto.
* __$pow__. Potencia x^y.
* __$sqrt__. Raíz cuadrada.
* __$substract__. Resta.
* __$trunc__. Truncamiento

### Funciones sobre fechas.


* __$dayOfYear__. Día del año.
* __$dayOfMonth__. Día del mes.
* __$dayOfWeek__. Día de la semana.
* __$dateFromString__. Convierte una cadena en fecha.
* __$dateToString__. Convierte una fecha en cadena (admite varios formatos).
* __$year__. Devuelve de una fecha la parte correspondiente al año.
* __$month__. Devuelve de una fecha la parte correspondiente al mes.
* __$week__. Devuelve de una fecha la parte correspondiente a la semana.
* __$hour__. Devuelve de una fecha la parte correspondiente a las horas.
* __$minute__. Devuelve de una fecha la parte correspondiente a minutos.
* __$second__. Devuelve de una fecha la parte correspondiente a segundos.
* __$millisecond__. Devuelve de una fecha la parte correspondiente a milisegundos.



La agregación trabaja con grupos de valores procedentes de múltiples documentos que se pueden agrupar a fin de obtener un resultado. En MongoDB se presentan [3 formas](https://docs.mongodb.com/manual/aggregation/) de llevar a cabo la agregación:

* *Pipeline* o tubería. Se denomina así porque cada etapa de la agregación toma como entrada la salida de la anterior.
* *Propósito único*
* *Map-reduce*


### Aggregation Pipeline

Está dividida en varias etapas en las que se somete a una colección a diversas operaciones (cada una se considera una etapa), que modifican los datos hasta obtener el resultado deseado. Cada etapa tiene asociada una multiplicidad, lo que hace referencia al número de documentos que se obtienen como resultado tras la etapa en cuestión. Son similares a las cardinalidades de las relaciones de bases de datos relacionales:

* 1:1 Se aplica a uno y se obtiene un documento.
* 1:N Se aplica a un documento y se obtienen n.
* N:1 Se aplica a n documentos y se obtiene 1.

[Introducción a Aggregation Pipeline](https://charlascylon.com/2013-10-10-tutorial-mongodb-introduccion-aggregation-framework)

#### Etapas de aggregation pipeline (resumidas, para verlas todas; [Referencia EN](https://docs.mongodb.com/manual/reference/operator/aggregation-pipeline/))

* [$project](https://docs.mongodb.com/manual/reference/operator/aggregation/project/) 1:1
  * Cambia la forma del documento, la proyección.
* [$match](https://docs.mongodb.com/manual/reference/operator/aggregation/match/) n:1
  * Filtra los resultados.
* [$group](https://docs.mongodb.com/manual/reference/operator/aggregation/group/) n:1
  * Agrupa los documentos por campos comunes. También se usa para las funciones de resumen.
* [$sort](https://docs.mongodb.com/manual/reference/operator/aggregation/sort/) 1:1
  * Ordenación.
* [$skip](https://docs.mongodb.com/manual/reference/operator/aggregation/skip/) n:1
  * Salto de elementos.
* [$limit](https://docs.mongodb.com/manual/reference/operator/aggregation/limit/) n:1
  * Mostrar una cantidad determinada de resultados.
* [$lookup](https://docs.mongodb.com/manual/reference/operator/aggregation/lookup/).
  * Para poder establecer relaciones entre colecciones. Es parecido a un LEFT OUTER JOIN en sql.
* [$unwind](https://docs.mongodb.com/manual/reference/operator/aggregation/unwind/) 1:n
  * Normalización de arrays.
* [$out](https://docs.mongodb.com/manual/reference/operator/aggregation/out/) 1:1
  * Para enviar el resultado a una salida concreta (P.Ej: insertarlo en un nuevo documento)

#### Condiciones en la agregación:

* [$cond](https://docs.mongodb.com/manual/reference/operator/aggregation/cond/). Es similar a la sentencia de control if-else. Recibe 3 elementos; la expresión a evaluar, sentencia si true, sentencia si false.

* [ifNull](https://docs.mongodb.com/manual/reference/operator/aggregation/ifNull/). Recibe una expresión y otra de reemplazo. Evalua la primera y devuelve su valor si no es nulo, o la de reemplazo si lo es.


#### Arrays y campos compuestos
* [__$arrayElemAt__](https://docs.mongodb.com/manual/reference/operator/aggregation/arrayElemAt/) Para acceder a los elementos de un array presente en un documento. Recibe el campo array y el índice que se desea consultar.

* [$concatArrays](https://docs.mongodb.com/manual/reference/operator/aggregation/concatArrays/). Recibe varios arrays independientes y los concatena en uno solo.
* [$filter](https://docs.mongodb.com/manual/reference/operator/aggregation/filter/). Devuelve un array nuevo a partir de algunos elementos de otro array.
* [$isArray](https://docs.mongodb.com/manual/reference/operator/aggregation/isArray/). Devuelve verdadero o falso si el operando recibido es o no array.
* [$size](https://docs.mongodb.com/manual/reference/operator/aggregation/size/). Devuelve el tamaño del array que recibe.
* [$slice](https://docs.mongodb.com/manual/reference/operator/aggregation/slice/). Devuelve un subconjunto del array que recibe.

### Relaciones entre documentos   

En muchos casos, el modelo de datos desnormalizado donde se almacenan datos relacionados en un mismo documento es adecuado. Sin embargo, hay ocasiones en las que tiene sentido almacenar la información en documentos separados (de distintas colecciones o bases de datos). En MongoDB esto se hace de [dos formas diferentes](https://docs.mongodb.com/manual/reference/database-references/):

#### Referencias Manuales

En este caso se almacena el campo *_id* de un documento en otro como referencia. Así, la aplicación puede ejecutar consultas para recuperar la información. Como se ve, es parecido al sistema de claves ajenas de las bases de datos relacionales.

#### DBRefs

En este caso, se genera referencias de un documento a otro mediante el campo *_id*, el nombre de la colección y de forma opcional el de la base de datos. Mediante estos datos, DBRefs permite enlazar los documentos de múltiples colecciones. Para gestionar las referencias, la aplicación debe hacer varias consultas a fin de recuperar los documentos referenciados. DBRefs proporcionan un formato y tipo común para rerpesentar las relaciones entre documentos, así como una semántica común para representar los enlaces entre documentos si estos han de interactuar con múltiples herramientas o frameworks. 

* Nota de la documentación oficial: A menos que se tenga una buena razón para utilizar DBRefs, es preferible emplear referencias manuales.


### Notas sobre las comillas

Al realizar alguna consulta de prueba siguiendo los ejemplos, probablemente se habrá visto que MongoDB guarda los elementos con comillas dobles en el identificador. Es decir que MongoDB guarda las duplas “firstName”:“Alex” o “age”:34. En las consultas, en cambio, no se han especificado dichas comillas. Esto es porque el motor JavaScript de MongoDB las añade. Esto facilita la escritura de consultas, que no son obligatorias.

## Recursos


* [MongoDB Comandos básicos](https://jarriagadeveloper.wordpress.com/2016/01/19/mongodb-comandos-basicos/) 
* [Más ejemplos Comandos](http://www.diegocalvo.es/tutorial-de-mongodb-con-ejemplos/) 
* [Libro MongoDB ES](https://github.com/uokesita/the-little-mongodb-book/blob/master/es/mongodb.markdown) 
* [API Datos NBA](https://github.com/kshvmdn/nba.js/blob/master/docs/api/DATA.md) 
* [Tutorial MongoDB ES](https://charlascylon.com/tutorialmongo)