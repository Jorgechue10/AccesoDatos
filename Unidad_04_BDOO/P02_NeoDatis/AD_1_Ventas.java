package P02_NeoDatis;

public class AD_1_Ventas {

	private int codventa;
	private AD_1_Articulos codarti;
    private AD_1_Clientes numcli ;
	private int univen; 
	private String fecha;
	
	public AD_1_Ventas(){}
	
	public AD_1_Ventas(int codventa, AD_1_Articulos codarti, AD_1_Clientes numcli, int univen, String fecha) {
		super();
		this.codventa = codventa;
		this.codarti = codarti;
		this.numcli = numcli;
		this.univen = univen;
		this.fecha = fecha;
	}
	public int getCodventa() {
		return codventa;
	}
	public void setCodventa(int codventa) {
		this.codventa = codventa;
	}
	public AD_1_Articulos getCodarti() {
		return codarti;
	}
	public void setCodarti(AD_1_Articulos codarti) {
		this.codarti = codarti;
	}
	public AD_1_Clientes getNumcli() {
		return numcli;
	}
	public void setNumcli(AD_1_Clientes numcli) {
		this.numcli = numcli;
	}
	public int getUniven() {
		return univen;
	}
	public void setUniven(int univen) {
		this.univen = univen;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	} 

}
