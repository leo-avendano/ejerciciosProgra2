package usoTP1;

import implementacion.Cola;
import implementacion.Pila;
import tdas.PilaTDA;
import tdas.ColaTDA;

public class EJ4_b_InvertirColaAux {
	private static ColaTDA invertirColaAux(ColaTDA origen) {
		ColaTDA resultado = new Cola();
		PilaTDA pilaAux = new Pila();
		resultado.inicializarCola();
		pilaAux.inicializarPila();
		while (!origen.colaVacia()) {
			pilaAux.apilar(origen.primero());
			origen.desacolar();
		}
		while (!pilaAux.pilaVacia()) {
			resultado.acolar(pilaAux.tope());
			pilaAux.desapilar();
		}
		return resultado;
	}
	public static void main(String[] args) {
		ColaTDA miPrimerCola = new Cola();
		miPrimerCola.inicializarCola();
		miPrimerCola.acolar(1);
		miPrimerCola.acolar(2);
		miPrimerCola.acolar(3);
		miPrimerCola.acolar(5);
		miPrimerCola.acolar(6);
		
		
		ColaTDA segundaCola = invertirColaAux(miPrimerCola);

		// Esto deberia imprimir 6,5,3,2,1
		while (!segundaCola.colaVacia()) {
			System.out.println(segundaCola.primero());
			segundaCola.desacolar();
		}
	}
}
