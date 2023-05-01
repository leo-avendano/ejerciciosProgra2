package usoTP1;

import implementacion.Pila;
import tdas.PilaTDA;

public class EJ2_b_CopiarPila {
	static public PilaTDA copiarPila(PilaTDA original) {
		PilaTDA resultado = new Pila();
		resultado.inicializarPila();
		PilaTDA pilaInvertida = new Pila();
		pilaInvertida.inicializarPila();
		while (!original.pilaVacia()) {
			pilaInvertida.apilar(original.tope());
			original.desapilar();
		}
		while (!pilaInvertida.pilaVacia()) {
			resultado.apilar(pilaInvertida.tope());
			pilaInvertida.desapilar();
		}
		return resultado;
	}
	
	public static void main(String[] args) {
		PilaTDA miPrimerPila = new Pila();
		miPrimerPila.inicializarPila();
		miPrimerPila.apilar(1);
		miPrimerPila.apilar(5);
		miPrimerPila.apilar(3);
		miPrimerPila.apilar(6);

		PilaTDA miNuevaPila = copiarPila(miPrimerPila);
		
		// Esto deberia imprimir 6,3,5,1
		while (!miNuevaPila.pilaVacia()) {
			System.out.println(miNuevaPila.tope());
			miNuevaPila.desapilar();
		}

	}
}
