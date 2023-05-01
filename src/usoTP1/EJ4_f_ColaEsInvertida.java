package usoTP1;

import implementacion.Cola;
import implementacion.Pila;
import tdas.ColaTDA;
import tdas.PilaTDA;

public class EJ4_f_ColaEsInvertida {
	private static boolean colaEsInvertida(ColaTDA cola1, ColaTDA cola2) {
		PilaTDA cola1Invertida = new Pila();
		cola1Invertida.inicializarPila();
		boolean esInvertida = true;
		while (!cola1.colaVacia()) {
			cola1Invertida.apilar(cola1.primero());
			cola1.desacolar();
		}
		while (!cola2.colaVacia() && esInvertida) {
			if (cola2.primero() == cola1Invertida.tope()) {
				cola2.desacolar();
				cola1Invertida.desapilar();
			} else {
				esInvertida = false;
			}
		}
		return esInvertida;
	}
	public static void main(String[] args) {
		ColaTDA miPrimerCola = new Cola();
		miPrimerCola.inicializarCola();
		miPrimerCola.acolar(1);
		miPrimerCola.acolar(2);
		miPrimerCola.acolar(3);
		miPrimerCola.acolar(5);
		miPrimerCola.acolar(6);
		
		ColaTDA miOtraCola = new Cola();
		miOtraCola.inicializarCola();
		miOtraCola.acolar(6);
		miOtraCola.acolar(5);
		miOtraCola.acolar(3);
		miOtraCola.acolar(2);
		miOtraCola.acolar(1);
		
		boolean sonIguales = colaEsInvertida(miPrimerCola, miOtraCola);

		// Esto deberia imprimir true
		System.out.println(sonIguales);
		
		ColaTDA miPrimerCola2 = new Cola();
		miPrimerCola2.inicializarCola();
		miPrimerCola2.acolar(1);
		miPrimerCola2.acolar(2);
		miPrimerCola2.acolar(3);
		miPrimerCola2.acolar(5);
		miPrimerCola2.acolar(6);
		
		ColaTDA miOtraCola2 = new Cola();
		miOtraCola2.inicializarCola();
		miOtraCola2.acolar(6);
		miOtraCola2.acolar(3);
		miOtraCola2.acolar(5);
		miOtraCola2.acolar(8);
		
		
		boolean sonIguales2 = colaEsInvertida(miPrimerCola2, miOtraCola2);

		// Esto deberia imprimir false
		System.out.println(sonIguales2);
			
	}
}
