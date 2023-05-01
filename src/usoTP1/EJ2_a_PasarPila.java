package usoTP1;

import implementacion.Pila;
import tdas.PilaTDA;

public class EJ2_a_PasarPila {

	static public PilaTDA pasarPila (PilaTDA origen) {
		PilaTDA destino = new Pila();
		destino.inicializarPila();
		while (!origen.pilaVacia()) {
		  destino.apilar(origen.tope());
		  origen.desapilar();
		}
		return destino;
	}

	public static void main(String[] args) {
		PilaTDA miPrimerPila = new Pila();
		miPrimerPila.inicializarPila();
		miPrimerPila.apilar(1);
		miPrimerPila.apilar(5);
		miPrimerPila.apilar(3);
		miPrimerPila.apilar(6);

		PilaTDA miNuevaPila = pasarPila(miPrimerPila);
		
		// Esto deberia imprimir 1,5,3,6
		while (!miNuevaPila.pilaVacia()) {
			System.out.println(miNuevaPila.tope());
			miNuevaPila.desapilar();
		}

	}

}
