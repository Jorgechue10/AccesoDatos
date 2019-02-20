package P01_Introduccion_JavaBean;

import java.beans.PropertyVetoException;

public class EJ_1_3_Principal{
    public static void main(String[] args) throws PropertyVetoException{
         
    	EJ_1_1_Asalariado empleado = new EJ_1_1_Asalariado();
    	EJ_1_2_Hacienda funcionario1 = new EJ_1_2_Hacienda();    
    	
    	
    	
        System.out.println("-----PROPIEDADES LIGADAS----------------------");      
        empleado.addPropertyChangeListener(funcionario1);
        empleado.setSueldo(50);
        
        System.out.println("\n-----PROPIEDADES RESTRINGIDA----------------------");
        empleado.addVetoableChangeListener(funcionario1);
        empleado.setHorasExtras(3);
        System.out.println("Horas extra empleado: " + empleado.getHorasExtras());
        
        /*Para crear el jar introuduces en el cmd-> C:\Users\ifc\git\AccesoDatos\bin\P01_Introduccion_JavaBean>
        jar cvf ej_1_componentes.jar EJ_1_1_Asalariado.class EJ_1_2_Hacienda.class EJ_1_3_Principal.class*/
    }
}