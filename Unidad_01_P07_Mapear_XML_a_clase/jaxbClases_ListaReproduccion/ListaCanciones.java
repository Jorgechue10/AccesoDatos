//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.11.23 a las 12:14:40 PM CET 
//


package jaxbClases_ListaReproduccion;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cancion" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                   &lt;element name="anio" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                   &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="artista" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="duracion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="cancion_espaniola" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cancion"
})
@XmlRootElement(name = "listaCanciones")
public class ListaCanciones {

    @XmlElement(required = true)
    protected List<ListaCanciones.Cancion> cancion;

    /**
     * Gets the value of the cancion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cancion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCancion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListaCanciones.Cancion }
     * 
     * 
     */
    public List<ListaCanciones.Cancion> getCancion() {
        if (cancion == null) {
            cancion = new ArrayList<ListaCanciones.Cancion>();
        }
        return this.cancion;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *         &lt;element name="anio" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="artista" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="duracion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="cancion_espaniola" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "id",
        "anio",
        "titulo",
        "artista",
        "duracion",
        "cancionEspaniola"
    })
    public static class Cancion {

        @XmlElement(required = true)
        protected BigInteger id;
        @XmlElement(required = true)
        protected BigInteger anio;
        @XmlElement(required = true)
        protected String titulo;
        @XmlElement(required = true)
        protected String artista;
        @XmlElement(required = true)
        protected String duracion;
        @XmlElement(name = "cancion_espaniola")
        protected boolean cancionEspaniola;

        /**
         * Obtiene el valor de la propiedad id.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getId() {
            return id;
        }

        /**
         * Define el valor de la propiedad id.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setId(BigInteger value) {
            this.id = value;
        }

        /**
         * Obtiene el valor de la propiedad anio.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getAnio() {
            return anio;
        }

        /**
         * Define el valor de la propiedad anio.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setAnio(BigInteger value) {
            this.anio = value;
        }

        /**
         * Obtiene el valor de la propiedad titulo.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTitulo() {
            return titulo;
        }

        /**
         * Define el valor de la propiedad titulo.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitulo(String value) {
            this.titulo = value;
        }

        /**
         * Obtiene el valor de la propiedad artista.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getArtista() {
            return artista;
        }

        /**
         * Define el valor de la propiedad artista.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setArtista(String value) {
            this.artista = value;
        }

        /**
         * Obtiene el valor de la propiedad duracion.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDuracion() {
            return duracion;
        }

        /**
         * Define el valor de la propiedad duracion.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDuracion(String value) {
            this.duracion = value;
        }

        /**
         * Obtiene el valor de la propiedad cancionEspaniola.
         * 
         */
        public boolean isCancionEspaniola() {
            return cancionEspaniola;
        }

        /**
         * Define el valor de la propiedad cancionEspaniola.
         * 
         */
        public void setCancionEspaniola(boolean value) {
            this.cancionEspaniola = value;
        }

    }

}
