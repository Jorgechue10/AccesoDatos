package P02_NeoDatis;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.neodatis.odb.ODB;

import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.IValuesQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.GroupByValuesQueryResultAction;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class AD_1_Principal {
	static ODB odb;
	public static void main(String[] args) {

		odb = ODBFactory.open("Unidad_04_BDOO\\P02_NeoDatis\\Data\\ad_1_articulos.dat");
		
		//-----CONSULTAS-------
		mostrarDatosVentas();
		mostrarDatosVentasPorArticulo();
		mostrarDatosClientes();
		mostrarEstatisticas();
		
		
		//---------------------
		odb.close();
	}
	
	public static void mostrarDatosVentas() {
		
		Objects<AD_1_Ventas> ventas = odb.getObjects(AD_1_Ventas.class);
		
		System.out.println("Datos de Ventas:");
		
		System.out.println("      ------------------------------------------------------------------------------"
				+ "----------------------------------");
		System.out.printf("%-5s | %-10s | %-13s | %-12s | %-12s |   %-13s | %-10s | %-8s | %-7s |\n","", "Cod. Venta",
				"Cod. Articulo", "Denominación", "Num. Cliente", "Nom. Cliente", "  Fecha", "Unidades", "Importe");
		System.out.println("------|------------|---------------|--------------|--------------|-----------------|"
				+ "------------|----------|---------|");
		
		int i = 1;
		
		while(ventas.hasNext()){
			AD_1_Ventas venta = ventas.next();
			
			System.out.printf("| %2d  |     %-6d |       %-7d | %-12s | %6d       | %-15s | %-10s | %4d     | %7.2f |\n", (i++), 
					venta.getCodventa(), venta.getCodarti().getCodarti(), venta.getCodarti().getDenom(), 
					venta.getNumcli().getNumcli(), venta.getNumcli().getNombre(), venta.getFecha(), venta.getUniven(),
					(venta.getCodarti().getPvp()*venta.getUniven()));
		    System.out.println("|-----|------------|---------------|--------------|--------------|-----------------|"
		    		+ "------------|----------|---------|");		    
		}
		System.out.println("\n---------------------------------------------------------------------------------------\n");
	}
	
	public static void mostrarDatosVentasPorArticulo() {
				System.out.println("Datos de Ventas agrupados por ariculo:");

		Objects<AD_1_Ventas> ventas = odb.getObjects(AD_1_Ventas.class);
		
		Values nUnidadesVendidas = odb.getValues(new ValuesCriteriaQuery(AD_1_Ventas.class).
				sum("univen").groupBy("codarti"));
		Values nVentas = odb.getValues(new ValuesCriteriaQuery(AD_1_Ventas.class).
				count("codventas").groupBy("codarti"));
		
		
		AD_1_Ventas venta;
		int codartiAnterior = 0;
		
		while(ventas.hasNext()) {
			
			venta = ventas.next();
			
			if (venta.getCodarti().getCodarti() != codartiAnterior) {
				
				ObjectValues ov = nUnidadesVendidas.nextValues();
				ObjectValues ov2 = nVentas.nextValues();
				BigDecimal valor = (BigDecimal)ov.getByIndex(0);
				float sumaImporte = venta.getCodarti().getPvp() * valor.floatValue();
				
				System.out.println("Código artículo: "+ venta.getCodarti().getCodarti() + " | Denominación: " + venta.getCodarti().getDenom() + 
						" | Stock: " + venta.getCodarti().getStock() + " | PVP: " + venta.getCodarti().getPvp() + " | N. de uds. vendidas: " 
						+ ov.getByIndex(0) + " | Suma del importe: " + sumaImporte + " | N.de ventas: " + ov2.getByIndex(0));
			}
			
			codartiAnterior = venta.getCodarti().getCodarti();
			
			
		}
		System.out.println("\n---------------------------------------------------------------------------------------\n");
	}
	
	public static void mostrarDatosClientes() {
		
		System.out.println("Datos de Clientes");
	
		Objects<AD_1_Clientes> clientes = odb.getObjects(AD_1_Clientes.class);
	
		while(clientes.hasNext()) {
			AD_1_Clientes cliente = clientes.next();
			
			//comprobar cuantas ventas tiene el cliente
			Objects<AD_1_Ventas> ventas = odb.getObjects(AD_1_Ventas.class);
			
			int numeroCompras = 0;
			float importeTotal = 0;
			
			while(ventas.hasNext()) {
				AD_1_Ventas venta = ventas.next();
				if(venta.getNumcli().getNumcli()==cliente.getNumcli()) {
					numeroCompras++;
					importeTotal += venta.getUniven() * venta.getCodarti().getPvp();
				}
			}
			
			System.out.println("Nº: " + cliente.getNumcli() + 
					" | Nombre: " + cliente.getNombre() + 
					" | Poblacion: " + cliente.getPobla() +
					" | Importe: " + importeTotal +
					" | Nº Compras: " + numeroCompras);
		}
		System.out.println("\n---------------------------------------------------------------------------------------\n");
	}
	
	public static void mostrarEstatisticas() {
		
		System.out.println("Estadísticas:");

		//Artículo con mayor número de ventas
		Objects<AD_1_Ventas> ventas = odb.getObjects(AD_1_Ventas.class);
		
		Values nVentas = odb.getValues((IValuesQuery) new ValuesCriteriaQuery(AD_1_Ventas.class).
				count("codventas").groupBy("codarti"));
		
		AD_1_Ventas venta;
		int codartiAnterior = 0;
		int codigoArticuloMasVendido = 0;
		
		while(ventas.hasNext()) {
			
			venta = ventas.next();
			
			if (venta.getCodarti().getCodarti() != codartiAnterior) {				
				ObjectValues ov = nVentas.nextValues();
				BigInteger valor = (BigInteger)ov.getByIndex(0);
				if (valor.intValue() > codigoArticuloMasVendido) {
					codigoArticuloMasVendido = codartiAnterior;
				}				
			}			
			codartiAnterior = venta.getCodarti().getCodarti();			
		}
		
		//Cliente con mayor importe gastado y mayor número de compras
		Objects<AD_1_Clientes> clientes = odb.getObjects(AD_1_Clientes.class);
		
		int numClienteMayorImporteGastado = 0;
		int numClienteMasCompras = 0;
		
		while(clientes.hasNext()) {
			AD_1_Clientes cliente = clientes.next();
			
			ventas = odb.getObjects(AD_1_Ventas.class);
			
			int numeroCompras = 0;
			float importeTotal = 0;
			
			while(ventas.hasNext()) {
				venta = ventas.next();
				if(venta.getNumcli().getNumcli() == cliente.getNumcli()) {
					numeroCompras++;
					importeTotal += venta.getUniven() * venta.getCodarti().getPvp();
				}
			}
			
			if (importeTotal > numClienteMayorImporteGastado) {
				numClienteMayorImporteGastado = cliente.getNumcli();
			}
			
			if (numeroCompras > numClienteMasCompras) {
				numClienteMasCompras = cliente.getNumcli();
			}			
		}
		
		System.out.println("Código del artículo más vendido: " + codigoArticuloMasVendido);
		System.out.println("Número del cliente con mayor importe gastado: " + numClienteMayorImporteGastado);
		System.out.println("Número del cliente con más compras realizadas: " + numClienteMasCompras);
		
		System.out.println("\n---------------------------------------------------------------------------------------\n");
	}
}