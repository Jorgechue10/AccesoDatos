package operaciones;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import jaxbClases_ListaReproduccion.*;
import jaxbClases_ListaReproduccion.ListaCanciones.Cancion;

public class principal_ListaReproduccion {

	public static void main(String[] args) throws IOException, JAXBException{
		// TODO Auto-generated method stub

		visualizarxml();
	}

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
			ListaCanciones misCanciones = (ListaCanciones) u.unmarshal(new FileInputStream("Unidad_01_P07_Mapear_XML_a_clase/lista_reproduccion.xml"));

			// Visualizo el documento
			Marshaller m = jaxbContext.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			m.marshal(misCanciones, System.out);

			// Guardamos las canciones en la lista
			List listaCanciones = new ArrayList();
			listaCanciones = misCanciones.getCancion();

			System.out.println("---------------------------- ");
			System.out.println("---VISUALIZAR LOS OBJETOS--- ");
			System.out.println("---------------------------- ");

			for (int i = 0; i < listaCanciones.size(); i++) {
				ListaCanciones.Cancion lc = (Cancion) listaCanciones.get(i);
				System.out.println("Número de canción: " + lc.getId() + ". Año: " + lc.getAnio()
						+ ". Título: " + lc.getTitulo() + ". Artista: " + lc.getArtista()
						+ ". Duración: " + lc.getDuracion() + ". ¿Canción española?: " + lc.isCancionEspaniola());
			}
	}
}
