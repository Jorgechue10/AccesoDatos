package operaciones;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import jaxbClases.*;
import jaxbClases.Ventas.Venta;

public class principal {

	public static void main(String[] args)throws IOException, JAXBException {

		visualizarxml();
		// Método para añadir una venta, recibe el número de venta,
		// las unidades
		// el nombre cliente, la fecha
		// Comprobar que el número de venta no exista
		//insertarventa(35, "Cliente 2", 10, "16-10-2018");//inserta otra venta en el documento xml
		//borrarVenta(35);
		//modificarStock(-20);
		//modificarVenta(35,20,"23-11-2018");
		//visualizarxml();
	}

	////////////////////////////////////////
	public static void visualizarxml() throws IOException, JAXBException {

		System.out.println("------------------------------ ");
		System.out.println("-------VISUALIZAR XML--------- ");
		System.out.println("------------------------------ ");
		
			// JAXBContext jaxbContext = JAXBContext.newInstance("datosclases");
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);

			// Crear un objeto de tipo Unmarshaller para convertir datos XML en
			// un �rbol de objetos Java
			Unmarshaller u = jaxbContext.createUnmarshaller();
			
			// La clase JAXBElement representa a un elemento de un documento XML
			// en este caso a un elemento del documento ventasarticulos.xml
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("Unidad_01_P07_Mapear_XML_a_clase/ventas_articulo.xml"));

			// Visualizo el documento
			Marshaller m = jaxbContext.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			m.marshal(jaxbElement, System.out);

			// Si queremos operar con el documento obtenemos los
			// objetos del jaxbElement
			// El método getValue() retorna el modelo de contenido (content
			// model) y el valor de los atributos del elemento

			VentasType miventa = (VentasType) jaxbElement.getValue();

			// Obtenemos una instancia para obtener todas las ventas
			Ventas vent = miventa.getVentas();

			// Guardamos las ventas en la lista
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();

			System.out.println("---------------------------- ");
			System.out.println("---VISUALIZAR LOS OBJETOS--- ");
			System.out.println("---------------------------- ");
			// Datos del artículo
			DatosArtic miartic = (DatosArtic) miventa.getArticulo();

			System.out.println("Nombre art: " + miartic.getDenominacion());
			System.out.println("Codigo art: " + miartic.getCodigo());
			System.out.println("Stock art: " + miartic.getStock());
			System.out.println("Precio art: " + miartic.getPrecio());
			System.out.println("Ventas  del artúculo , hay: " + listaVentas.size());

			for (int i = 0; i < listaVentas.size(); i++) {
				Ventas.Venta ve = (Venta) listaVentas.get(i);
				System.out.println("Número de venta: " + ve.getNumventa() + ". Nombre cliente: " + ve.getNombrecliente()
						+ ", unidades: " + ve.getUnidades() + ", fecha: " + ve.getFecha());
			}


	}

	private static void insertarventa(int numeventa, String nomcli, int uni, String fecha) {

		System.out.println("---------------------------- ");
		System.out.println("-------AÑADIR VENTA--------- ");
		System.out.println("---------------------------- ");
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller u = jaxbContext.createUnmarshaller();
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("Unidad_01_P07_Mapear_XML_a_clase/ventas_articulo.xml"));
			

			VentasType miventa = (VentasType) jaxbElement.getValue();

			// Obtenemos una instancia para obtener todas las ventas
			Ventas vent = miventa.getVentas();

			// Guardamos las ventas en la lista
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();

			// comprobar si existe el número de venta, reccorriendo el arraylist
			int existe = 0; // si no existe, 1 si existe
			for (int i = 0; i < listaVentas.size(); i++) {
				Ventas.Venta ve = (Venta) listaVentas.get(i);
				if (ve.getNumventa().intValue() == numeventa) {
					existe = 1;
					break;
				}
			}

			if (existe == 0) {
				// Crear el objeto Ventas.Venta, y si no existe se añade a la
				// lista

				Ventas.Venta ve = new Ventas.Venta();
				ve.setNombrecliente(nomcli);
				ve.setFecha(fecha);
				ve.setUnidades(uni);
				BigInteger nume = BigInteger.valueOf(numeventa);
				ve.setNumventa(nume);

				// añadimos la venta a la lista

				listaVentas.add(ve);

				// crear el Marshaller, volcar la lista al fichero XML
				Marshaller m = jaxbContext.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				m.marshal(jaxbElement, new FileOutputStream("Unidad_01_P07_Mapear_XML_a_clase/ventas_articulo.xml"));

				System.out.println("Venta añaadida: " + numeventa);
 
			} else

				System.out.println("En número de venta ya existe: " + numeventa);

		} catch (JAXBException je) {
			System.out.println(je.getCause());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	private static boolean borrarVenta(int numeventa) {
		System.out.println("---------------------------- ");
		System.out.println("-------BORRAR VENTA--------- ");
		System.out.println("---------------------------- ");
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller u = jaxbContext.createUnmarshaller();
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("Unidad_01_P07_Mapear_XML_a_clase/ventas_articulo.xml"));
			

			VentasType miventa = (VentasType) jaxbElement.getValue();

			// Obtenemos una instancia para obtener todas las ventas
			Ventas vent = miventa.getVentas();

			// Guardamos las ventas en la lista
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();

			// comprobar si existe el número de venta, reccorriendo el arraylist
			int existe = 0; // si no existe, 1 si existe
			Ventas.Venta ve = new Ventas.Venta();
			for (int i = 0; i < listaVentas.size(); i++) {
				ve = (Venta) listaVentas.get(i);
				if (ve.getNumventa().intValue() == numeventa) {
					existe = 1;
					break;
				}
			}

			if (existe == 1) {
				listaVentas.remove(ve);
				
				// crear el Marshaller, volcar la lista al fichero XML
				Marshaller m = jaxbContext.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				m.marshal(jaxbElement, new FileOutputStream("Unidad_01_P07_Mapear_XML_a_clase/ventas_articulo.xml"));

				System.out.println("Venta borrada: " + numeventa);				
				return true;
			}else
				System.out.println("No existe ninguna venta con ese número");
			
		} catch (JAXBException je) {
			System.out.println(je.getCause());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return false;
	}
	
	private static boolean modificarStock(int cantidad) {
		System.out.println("---------------------------- ");
		System.out.println("-------MODIFICAR STOCK------ ");
		System.out.println("---------------------------- ");
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller u = jaxbContext.createUnmarshaller();
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("Unidad_01_P07_Mapear_XML_a_clase/ventas_articulo.xml"));
			

			VentasType miventa = (VentasType) jaxbElement.getValue();
			
			DatosArtic articulo = miventa.getArticulo();
			BigInteger stock_anterior=articulo.getStock();
			int suma = stock_anterior.intValue()+cantidad;
			BigInteger stock_total = BigInteger.valueOf(suma);
			articulo.setStock(stock_total);	
			// crear el Marshaller, volcar la lista al fichero XML
			Marshaller m = jaxbContext.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(jaxbElement, new FileOutputStream("Unidad_01_P07_Mapear_XML_a_clase/ventas_articulo.xml"));
			
			System.out.println("Stock modificado: "+ stock_anterior+" + "+cantidad+" = "+articulo.getStock());				
			return true;
			
		} catch (JAXBException je) {
			System.out.println(je.getCause());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return false;
	}
	
	private static boolean modificarVenta(int numeventa, int unidades, String fecha) {
		System.out.println("---------------------------- ");
		System.out.println("-------MODIFICAR VENTA------ ");
		System.out.println("---------------------------- ");
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller u = jaxbContext.createUnmarshaller();
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("Unidad_01_P07_Mapear_XML_a_clase/ventas_articulo.xml"));
			

			VentasType miventa = (VentasType) jaxbElement.getValue();

			// Obtenemos una instancia para obtener todas las ventas
			Ventas vent = miventa.getVentas();

			// Guardamos las ventas en la lista
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();

			// comprobar si existe el número de venta, reccorriendo el arraylist
			int existe = 0; // si no existe, 1 si existe
			Ventas.Venta ve = new Ventas.Venta();
			for (int i = 0; i < listaVentas.size(); i++) {
				ve = (Venta) listaVentas.get(i);
				if (ve.getNumventa().intValue() == numeventa) {
					existe = 1;
					break;
				}
			}

			if (existe == 1) {
				//Modificamos los campos que queremos
				ve.setFecha(fecha);
				ve.setUnidades(unidades);				
				
				// crear el Marshaller, volcar la lista al fichero XML
				Marshaller m = jaxbContext.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				m.marshal(jaxbElement, new FileOutputStream("Unidad_01_P07_Mapear_XML_a_clase/ventas_articulo.xml"));

				System.out.println("Venta modificada: " + numeventa);				
				return true;
			}else
				System.out.println("No existe ninguna venta con ese número");
			
		} catch (JAXBException je) {
			System.out.println(je.getCause());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return false;
	}
}
