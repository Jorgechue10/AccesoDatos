package P02_NeoDatis;

import org.neodatis.odb.ODB;

import org.neodatis.odb.ODBFactory;

public class AD_1_Principal {
	static ODB bd;
	public static void main(String[] args) {

		bd = ODBFactory.open("Unidad_04_BDOO\\P02_NeoDatis\\Data\\ad_1_articulos.dat");
		bd.close();

	

	}
}