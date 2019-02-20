package P01_Introduccion_JavaBean;

import java.beans.*;
import java.io.Serializable;

public class EJ_1_2_Hacienda implements Serializable, PropertyChangeListener, VetoableChangeListener{
	
	// Constructor
   public EJ_1_2_Hacienda(){}
      
       
    // Métodos   
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("sueldo")) {
			
			System.out.println("Hacienda: nuevo sueldo " + evt.getNewValue());
			System.out.println("Hacienda: sueldo anterior " + evt.getOldValue());				
		}		
	}

	@Override
	public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
	
		
		
		if ((Integer) evt.getNewValue() > 12) {
			System.out.println("Has introducido " + evt.getNewValue()+" y no se pueden "
				+ "initroducir más de 12 horas");
			
			throw new PropertyVetoException(null, null);
			
		}else {
			System.out.println("Hacienda: nuevas horas extras " + evt.getNewValue());
			System.out.println("Hacienda: horas extra anteriores " + evt.getOldValue());
		}		
	}

}