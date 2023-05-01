package usoTP1;

import implementacion.Pila;
import tdas.PilaTDA;

public class EJ2_f_PromedioPila {
	
	static public int promedioPila(PilaTDA original) {
		int suma = 0;
		int tamañoPila = 0;
		while (!original.pilaVacia()) {
			suma += original.tope();
			tamañoPila++;
			original.desapilar();
		}
		return suma/tamañoPila;
	}
	
	public static void main(String[] args) {
		PilaTDA miPrimerPila = new Pila();
		miPrimerPila.inicializarPila();
		miPrimerPila.apilar(7);
		miPrimerPila.apilar(5);
		miPrimerPila.apilar(3);

		int promedio = promedioPila(miPrimerPila);

		// Esto deberia imprimir 5
		System.out.println(promedio);	
	}
}
