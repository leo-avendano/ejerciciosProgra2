package usoTP1;

import implementacion.Cola;
import tdas.ColaTDA;

public class EJ4_c_InvertirCola {
	private static ColaTDA invertirCola(ColaTDA origen) {
		ColaTDA resultado = new Cola();
		resultado.inicializarCola();
		if (!origen.colaVacia()) {
			int ultimo = origen.primero();
			origen.desacolar();
			resultado = invertirCola(origen);
			resultado.acolar(ultimo);
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
		
		
		ColaTDA segundaCola = invertirCola(miPrimerCola);

		// Esto deberia imprimir 6,5,3,2,1
		while (!segundaCola.colaVacia()) {
			System.out.println(segundaCola.primero());
			segundaCola.desacolar();
		}
	}
}
