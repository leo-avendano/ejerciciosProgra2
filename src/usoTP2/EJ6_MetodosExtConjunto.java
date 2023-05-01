package usoTP2;

import tdas.ConjuntoTDA;
import implementacion.ConjuntoMaximo;


public class EJ6_MetodosExtConjunto {
	static public ConjuntoTDA<Integer> interseccion(ConjuntoTDA<Integer> conjA, ConjuntoTDA<Integer> conjB) {
		ConjuntoTDA<Integer> resultado = new ConjuntoMaximo(20);
		while (!conjA.conjuntoVacio()) {
			int valor = conjA.elegir();
			conjA.sacar(valor);
			if (conjB.pertenece(valor)) {
				resultado.agregar(valor);
			}
		}
		return resultado;
	}
	
	static public ConjuntoTDA<Integer> union(ConjuntoTDA<Integer> conjA, ConjuntoTDA<Integer> conjB) {
		ConjuntoTDA<Integer> resultado = new ConjuntoMaximo(20);
		while (!conjA.conjuntoVacio()) {
			int valor = conjA.elegir();
			conjA.sacar(valor);
			resultado.agregar(valor);
		}
		while (!conjB.conjuntoVacio()) {
			int valor = conjB.elegir();
			conjB.sacar(valor);
			resultado.agregar(valor);
		}
		return resultado;
	}
	
	static public ConjuntoTDA<Integer> diferencia(ConjuntoTDA<Integer> conjA, ConjuntoTDA<Integer> conjB) {
		ConjuntoTDA<Integer> resultado = new ConjuntoMaximo(20);
		while (!conjA.conjuntoVacio()) {
			int valor = conjA.elegir();
			conjA.sacar(valor);
			if (!conjB.pertenece(valor)) {
				resultado.agregar(valor);
			}
		}
		return resultado;
	}
	
	public static void main(String[] args) {
	
		ConjuntoTDA<Integer> conjA = new ConjuntoMaximo(10);
		conjA.inicializarConjunto();
		conjA.agregar(1);
		conjA.agregar(2);
		conjA.agregar(3);
		
		ConjuntoTDA<Integer> conjB = new ConjuntoMaximo(10);
		conjB.inicializarConjunto();
		conjB.agregar(3);
		conjB.agregar(4);
		conjB.agregar(5);
		
		ConjuntoTDA<Integer> resultado1 = interseccion(conjA, conjB);
		// Deberia imprimir (3)
		System.out.println("Resultado 1: ");
		while(!resultado1.conjuntoVacio()) {
			int valor = resultado1.elegir();
			System.out.println(valor);
			resultado1.sacar(valor);
		}
		
		ConjuntoTDA<Integer> resultado2 = union(conjA, conjB);
		// Deberia imprimir (1, 2, 3, 4, 5)
		System.out.println("Resultado 2: ");
		while(!resultado2.conjuntoVacio()) {
			int valor = resultado2.elegir();
			System.out.println(valor);
			resultado2.sacar(valor);
		}
		
		ConjuntoTDA<Integer> resultado3 = diferencia(conjA, conjB);
		// Deberia imprimir (1, 2)
		System.out.println("Resultado 3: ");
		while(!resultado3.conjuntoVacio()) {
			int valor = resultado3.elegir();
			System.out.println(valor);
			resultado3.sacar(valor);
		}
	}
}
