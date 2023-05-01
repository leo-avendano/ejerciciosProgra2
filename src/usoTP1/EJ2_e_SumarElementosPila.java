package usoTP1;

import implementacion.Pila;
import tdas.PilaTDA;

public class EJ2_e_SumarElementosPila {
	static public int sumarElementosPila(PilaTDA original) {
		int suma = 0;
		while (!original.pilaVacia()) {
			suma += original.tope();
			original.desapilar();
		}
		return suma;
	}
	
	public static void main(String[] args) {
		PilaTDA miPrimerPila = new Pila();
		miPrimerPila.inicializarPila();
		miPrimerPila.apilar(1);
		miPrimerPila.apilar(5);
		miPrimerPila.apilar(3);
		miPrimerPila.apilar(6);

		int suma = sumarElementosPila(miPrimerPila);

		// Esto deberia imprimir 15
		System.out.println(suma);	
	}
}
