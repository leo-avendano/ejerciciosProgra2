package usoTP1;

import implementacion.Pila;
import tdas.PilaTDA;

public class EJ2_d_ContarPila {
	static public int contarPila(PilaTDA original) {
		int tamañoPila = 0;
		while (!original.pilaVacia()) {
			tamañoPila++;
			original.desapilar();
		}
		return tamañoPila;
	}
	
	public static void main(String[] args) {
		PilaTDA miPrimerPila = new Pila();
		miPrimerPila.inicializarPila();
		miPrimerPila.apilar(1);
		miPrimerPila.apilar(5);
		miPrimerPila.apilar(3);
		miPrimerPila.apilar(6);

		int tamañoPila = contarPila(miPrimerPila);

		// Esto deberia imprimir 4
		System.out.println(tamañoPila);	
	}
}
