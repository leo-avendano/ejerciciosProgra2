package usoTP2;

import implementacionDinamica.Conjunto;
import tdas.ConjuntoTDA;


public class EJ6_MetodosExtConjunto {
	static public Conjunto interseccion(ConjuntoTDA<Integer> conjA, ConjuntoTDA<Integer> conjB) {
		Conjunto resultado = new Conjunto();
		while (!conjA.conjuntoVacio()) {
			int valor = conjA.elegir();
			conjA.sacar(valor);
			if (conjB.pertenece(valor)) {
				resultado.agregar(valor);
			}
		}
		return resultado;
	}
	
	static public Conjunto union(ConjuntoTDA<Integer>  conjA, ConjuntoTDA<Integer>  conjB) {
		Conjunto resultado = new Conjunto();
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
	
	static public Conjunto diferencia(ConjuntoTDA<Integer>  conjA, ConjuntoTDA<Integer>  conjB) {
		Conjunto resultado = new Conjunto();
		while (!conjA.conjuntoVacio()) {
			int valor = conjA.elegir();
			conjA.sacar(valor);
			if (!conjB.pertenece(valor)) {
				resultado.agregar(valor);
			} else {
				conjB.sacar(valor);
			}
		}
		while (!conjB.conjuntoVacio()) {
			int valor = conjB.elegir();
			conjB.sacar(valor);
			if (!conjA.pertenece(valor)) {
				resultado.agregar(valor);
			} else {
				conjA.sacar(valor);
			}
		}
		return resultado;
	}
	
	public static void main(String[] args) {
	
		Conjunto conjA = new Conjunto();
		conjA.inicializarConjunto();
		conjA.agregar(1);
		conjA.agregar(2);
		conjA.agregar(3);
		
		Conjunto conjB = new Conjunto();
		conjB.inicializarConjunto();
		conjB.agregar(3);
		conjB.agregar(4);
		conjB.agregar(5);
		
		Conjunto resultado1 = interseccion(conjA, conjB);
		// Deberia imprimir (3)
		System.out.println("Resultado 1: ");
		resultado1.print();
		
		Conjunto conjC = new Conjunto();
		conjC.inicializarConjunto();
		conjC.agregar(1);
		conjC.agregar(2);
		conjC.agregar(3);
		
		Conjunto conjD = new Conjunto();
		conjD.inicializarConjunto();
		conjD.agregar(3);
		conjD.agregar(4);
		conjD.agregar(5);
		
		Conjunto resultado2 = union(conjC, conjD);
		// Deberia imprimir (1, 2, 3, 4, 5)
		System.out.println("Resultado 2: ");
		resultado2.print();
		
		Conjunto conjE = new Conjunto();
		conjE.inicializarConjunto();
		conjE.agregar(1);
		conjE.agregar(2);
		conjE.agregar(3);
		
		Conjunto conjF = new Conjunto();
		conjF.inicializarConjunto();
		conjF.agregar(3);
		conjF.agregar(4);
		conjF.agregar(5);
		
		Conjunto resultado3 = diferencia(conjE, conjF);
		// Deberia imprimir (1, 2, 4, 5)
		System.out.println("Resultado 3: ");
		resultado3.print();
	}
}
