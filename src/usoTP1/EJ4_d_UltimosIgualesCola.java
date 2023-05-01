package usoTP1;

import implementacion.Cola;
import tdas.ColaTDA;

public class EJ4_d_UltimosIgualesCola {
	private static boolean ultimosIgualesCola(ColaTDA cola1, ColaTDA cola2) {
		int ultimoElementoCola1 = 0;
		int ultimoElementoCola2 = 0;
		while (!(cola1.colaVacia() && cola2.colaVacia())) {
			if (!cola1.colaVacia()) {
				ultimoElementoCola1 = cola1.primero();
				cola1.desacolar();
			}
			if (!cola2.colaVacia()) {
				ultimoElementoCola2 = cola2.primero();
				cola2.desacolar();
			}
		}
		return ultimoElementoCola1 == ultimoElementoCola2;
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
		miOtraCola.acolar(2);
		miOtraCola.acolar(3);
		miOtraCola.acolar(4);
		miOtraCola.acolar(6);
		
		boolean sonIguales = ultimosIgualesCola(miPrimerCola, miOtraCola);

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
		miOtraCola2.acolar(2);
		miOtraCola2.acolar(3);
		miOtraCola2.acolar(5);
		miOtraCola2.acolar(8);
		
		
		boolean sonIguales2 = ultimosIgualesCola(miPrimerCola2, miOtraCola2);

		// Esto deberia imprimir false
		System.out.println(sonIguales2);
			
	}
}
