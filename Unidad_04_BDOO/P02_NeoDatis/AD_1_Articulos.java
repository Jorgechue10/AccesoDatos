package P02_NeoDatis;

public class AD_1_Articulos {
	private int codarti;
	private String denom; 
	private int stock; 
	private float pvp;
	
	public AD_1_Articulos(){}
	
	public AD_1_Articulos(int codarti, String denom, int stock, float pvp) {
		super();
		this.codarti = codarti;
		this.denom = denom;
		this.stock = stock;
		this.pvp = pvp;
	}
	public int getCodarti() {
		return codarti;
	}
	public void setCodarti(int codarti) {
		this.codarti = codarti;
	}
	public String getDenom() {
		return denom;
	}
	public void setDenom(String denom) {
		this.denom = denom;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public float getPvp() {
		return pvp;
	}
	public void setPvp(float pvp) {
		this.pvp = pvp;
	} 

	

}
