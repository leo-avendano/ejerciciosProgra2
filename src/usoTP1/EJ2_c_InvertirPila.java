package usoTP1;

import implementacion.Pila;
import tdas.PilaTDA;

public class EJ2_c_InvertirPila {
	static public PilaTDA invertirPila(PilaTDA original) {
		PilaTDA pilaInvertida = new Pila();
		pilaInvertida.inicializarPila();
		while (!original.pilaVacia()) {
			pilaInvertida.apilar(original.tope());
			original.desapilar();
		}
		return pilaInvertida;
	}
	
	public static void main(String[] args) {
		PilaTDA miPrimerPila = new Pila();
		miPrimerPila.inicializarPila();
		miPrimerPila.apilar(1);
		miPrimerPila.apilar(5);
		miPrimerPila.apilar(3);
		miPrimerPila.apilar(6);

		miPrimerPila = invertirPila(miPrimerPila);

		// Esto deberia imprimir 1,5,3,6
		while (!miPrimerPila.pilaVacia()) {
			System.out.println(miPrimerPila.tope());
			miPrimerPila.desapilar();
		}
	}
}
