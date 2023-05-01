package usoTP1;

import implementacion.Cola;
import implementacion.Pila;
import tdas.ColaTDA;
import tdas.PilaTDA;

public class EJ4_e_ColaEsCapicua {
	private static boolean colaEsCapicua(ColaTDA origen) {
		ColaTDA colaClon = new Cola();
		colaClon.inicializarCola();
		PilaTDA colaInvertida = new Pila();
		colaInvertida.inicializarPila();
		boolean esCapicua = true;
		
		while(!origen.colaVacia()) {
			colaClon.acolar(origen.primero());
			colaInvertida.apilar(origen.primero());
			origen.desacolar();
		}
		while(!colaClon.colaVacia() && esCapicua) {
			if (colaClon.primero() == colaInvertida.tope()) {
				colaClon.desacolar();
				colaInvertida.desapilar();
			} else {
				esCapicua = false;
			}
		}
		return esCapicua;
	}
	public static void main(String[] args) {
		ColaTDA miPrimerCola = new Cola();
		miPrimerCola.inicializarCola();
		miPrimerCola.acolar(1);
		miPrimerCola.acolar(2);
		miPrimerCola.acolar(3);
		miPrimerCola.acolar(2);
		miPrimerCola.acolar(1);
		
		boolean esCapicua = colaEsCapicua(miPrimerCola);

		// Esto deberia imprimir true
		System.out.println(esCapicua);
		
		
		ColaTDA miOtraCola = new Cola();
		miOtraCola.inicializarCola();
		miOtraCola.acolar(2);
		miOtraCola.acolar(3);
		miOtraCola.acolar(5);
		miOtraCola.acolar(8);
		
		
		boolean esCapicua2 = colaEsCapicua(miOtraCola);

		// Esto deberia imprimir false
		System.out.println(esCapicua2);
	}
}
