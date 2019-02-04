package P02_NeoDatis;

import java.math.BigDecimal;

import org.neodatis.odb.ODB;

import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class AD_1_Principal {
	static ODB bd;
	public static void main(String[] args) {

		bd = ODBFactory.open("Unidad_04_BDOO\\P02_NeoDatis\\Data\\ad_1_articulos.dat");
		
		//-----CONSULTAS-------
		mostrarDatosVentas();
		mostrarDatosVentasPorArticulo();
		//mostrarEstatisticas();
		
		
		//---------------------
		bd.close();
	}
	
	public static void mostrarDatosVentas() {
		
		Objects<AD_1_Ventas> ventas = bd.getObjects(AD_1_Ventas.class);
		
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
	}
	
	public static void mostrarDatosVentasPorArticulo() {
		
		System.out.println("Datos de Ventas agrupados por artículo");
		
		Values unidadesVendidas = bd.getValues(new ValuesCriteriaQuery(AD_1_Ventas.class).
				sum("univen").groupBy("codarti"));
		
		
		//Values  = bd.getValues(new ValuesCriteriaQuery(AD_1_Articulos.class));
		
		Values valorImporte = bd.getValues(new ValuesCriteriaQuery(AD_1_Ventas.class).
				sum("univen*codarti.pvp").groupBy("codarti"));
		
		
		Values numVentas = bd.getValues(new ValuesCriteriaQuery(AD_1_Ventas.class).
				count("codventas").groupBy("codarti"));
		
		
		while(unidadesVendidas.hasNext()) {
			
			ObjectValues ov_unidadesVendidas = unidadesVendidas.nextValues();
			ObjectValues ov_numVentas = numVentas.nextValues();
			
			System.out.println("Nº de uds. vendidas: " + ov_unidadesVendidas.getByIndex(0) + 
					" | Importe:   Nº de ventas: " + ov_numVentas.getByIndex(0));
			
		}
	}
	
	public static void mostrarEstatisticas() {
		
		// Media de importe de ventas por artículo
		
		
		
	}
}