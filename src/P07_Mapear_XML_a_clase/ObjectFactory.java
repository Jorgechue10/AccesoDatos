//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.11.12 a las 04:35:24 PM CET 
//


package P07_Mapear_XML_a_clase;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jaxbClases package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Ventasarticulos_QNAME = new QName("", "ventasarticulos");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jaxbClases
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Ventas }
     * 
     */
    public Ventas createVentas() {
        return new Ventas();
    }

    /**
     * Create an instance of {@link VentasType }
     * 
     */
    public VentasType createVentasType() {
        return new VentasType();
    }

    /**
     * Create an instance of {@link DatosArtic }
     * 
     */
    public DatosArtic createDatosArtic() {
        return new DatosArtic();
    }

    /**
     * Create an instance of {@link Ventas.Venta }
     * 
     */
    public Ventas.Venta createVentasVenta() {
        return new Ventas.Venta();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VentasType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ventasarticulos")
    public JAXBElement<VentasType> createVentasarticulos(VentasType value) {
        return new JAXBElement<VentasType>(_Ventasarticulos_QNAME, VentasType.class, null, value);
    }

}
