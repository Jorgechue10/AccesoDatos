package Utilidades;

import java.util.Scanner;

public class Ejercicio_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner (System.in);
		
		System.out.println("Introduce dos numeros enteros");
		int x = teclado.nextInt();
		int y = teclado.nextInt();
		int suma;
		
		suma = x+y;
		System.out.println("El resultado es: "+suma);
		teclado.close();		
	}
}