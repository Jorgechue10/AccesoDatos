# Mapear XML a clase Java

## Ejemplo

Mapear a clase Java un XML de **ventas y artículos**:

1. Se crea el **XML** con los datos. [XML_VentasArticulos](ventas_articulo.xml) 

2. Se crea el **XSD** del documento XML. [XSD_VentasArticulos](ventas_articulo.xsd)

3. Se mapea a clase Java. Para ello hay que hacer click derecho sobre el documento 
**XSD** y darle a **‘Generate’ → ‘JAXB Classes...’** 

4. Una vez mapeado el XML en clases, ya se puede **trabajar con los datos**. [Principal_VentasArticulos](operaciones/principal.java)

> **Nota:** Para mapear XSD a clase Java hay que hacer click derecho sobre el documento XSD y darle a ‘Generate’ → ‘JAXB Classes...’
>
> Es posible que algunas versiones de Eclipse necesiten instalar Web Tools Platform(WTP) para disponer de la herramienta que genera las clases JABX. Para instalar WTP hay que ir a la barra de herramientas ‘Help’ → ‘Install New Software...’ y en la barra que pone ‘Work with:’ pegas el siguiente enlace: 
>
> **http://download.eclipse.org/webtools/repository/nombre de la versión de eclipse (oygen, photon, …)**
>
> Una vez cargue, eliges la opción Web Tools Platform (WTP) con la versión más nueva. Y por último la instalas.

## Actividades

### Ejercicio 1

Añade al proyecto Principal_VentasArticulos:

* Método que reciba un número de venta y la borre, si existe, del documento XML. El método devolverá true si se ha borrado la venta y false si no se ha borrado o ha ocurrido algún error.

* Método para modificar el stock del artículo. Recibe una cantidad numérica y se debe sumar al stock del artículo. El método devuelve true si todo ha ido bien y false en caso contrario.

* Método para cambiar los datos de una venta, recibe el número de venta a modificar, las unidades y la fecha. Devuelve true o false en función del éxito de la operación.

**Solución:** [Principal_VentasArticulos](operaciones/principal.java)

### Ejercicio 2

Generar plantilla XSD para una lista de reproducción y mapear a clase Java. Después generar un documento XML que contenga una lista de reproducción con canciones y visualizar el XML en una clase llamada ‘Principal_ListaReproduccion’.

**Solución:**  [XSD_ListaReproduccion](lista_reproduccion.xsd), [XML_ListaReproduccion](lista_reproduccion.xml),  [Principal_ListaReproduccion](operaciones/principal_ListaReproduccion.java)
