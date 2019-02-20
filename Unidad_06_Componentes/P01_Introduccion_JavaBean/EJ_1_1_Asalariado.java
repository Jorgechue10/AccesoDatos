package P01_Introduccion_JavaBean;

import java.beans.*;
import java.io.Serializable;

public class EJ_1_1_Asalariado implements Serializable{

		// Propiedades
		private PropertyChangeSupport propertySupport;
	   private int sueldo;
	   
	
	   private final VetoableChangeSupport vcs = new VetoableChangeSupport(this);
	   private int horasExtras;

	   // Constructor
	   public EJ_1_1_Asalariado(){
	         propertySupport = new PropertyChangeSupport(this);
	         sueldo = 20;
	         horasExtras = 0;
	   }
	  
	   // Métodos
	   public void addPropertyChangeListener(PropertyChangeListener listener){
	         propertySupport.addPropertyChangeListener(listener);
	   }
	  
	   public void removePropertyChangeListener(PropertyChangeListener listener){
	         propertySupport.removePropertyChangeListener(listener);
	   }
	  
	   public void setSueldo(int nuevoSueldo){
	         int anteSueldo = sueldo;
	         sueldo = nuevoSueldo;
	         if (anteSueldo != nuevoSueldo){
	                propertySupport.firePropertyChange("sueldo", anteSueldo, sueldo);
	         }
	   }
	  
	   public int getSalario(){
	         return sueldo;
	   }	   
	   	   
	   public void addVetoableChangeListener(VetoableChangeListener listener) {
	        this.vcs.addVetoableChangeListener(listener);
	    }

	    public void removeVetoableChangeListener(VetoableChangeListener listener) {
	        this.vcs.removeVetoableChangeListener(listener);
	    }
	   
	   public int getHorasExtras() {
		   return horasExtras;
	   }
	
	   public void setHorasExtras(int horasExtras) throws PropertyVetoException {		   
		   try {
			   
			   vcs.fireVetoableChange("horasExtra", this.horasExtras, horasExtras);
			   this.horasExtras = horasExtras;
		   
		   } catch (PropertyVetoException e) {
			   System.out.println("Se ha producido una excepción: " + e);
		   }		   
	   }
}