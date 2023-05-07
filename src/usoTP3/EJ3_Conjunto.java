package usoTP3;

import implementacionDinamica.Cola;
import implementacionDinamica.Conjunto;
import implementacionDinamica.Pila;

public class EJ3_Conjunto {
	/*
	 * a. Calcular la diferencia simétrica entre dos conjuntos A y B (definido en clase).
	 * 		i. Sin utilizar las operaciones unión, intersección y diferencia.
	 * 		ii. Utilizando las operaciones unión, intersección y diferencia.
	 * b. Determinar si dos conjuntos son iguales.
	 * c. Calcular la cardinalidad (cantidad de elementos) de un conjunto.
	 * d. Generar el conjunto de elementos que están tanto en la Pila P y en la Cola C.
	 * e. Determinar si los elementos de una Pila P son los mismos que los de una Cola
	 */
	
	public static void main(String[] args) {
		EJ3_Conjunto.A1();
		EJ3_Conjunto.A2();
		EJ3_Conjunto.B();
		EJ3_Conjunto.C();
		EJ3_Conjunto.D();
		EJ3_Conjunto.E();
	}
	
	public static void A1() {}
	
	public static void A2() {}
	
	public static void B() {}
	
	public static void C() {}
	
	public static void D() {}
	
	public static void E() {}
	
	static public Conjunto interseccion(Conjunto c1, Conjunto c2) {
		Conjunto conjA = clonar(c1);
		Conjunto conjB = clonar(c2);
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
	
	static public Conjunto union(Conjunto c1, Conjunto c2) {
		Conjunto conjA = clonar(c1);
		Conjunto conjB = clonar(c2);
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
	

	static public Conjunto diferencia(Conjunto c1, Conjunto c2) {
		Conjunto conjA = clonar(c1);
		Conjunto conjB = clonar(c2);
		Conjunto resultado = new Conjunto();
		while (!conjA.conjuntoVacio()) {
			int valor = conjA.elegir();
			conjA.sacar(valor);
			if (!conjB.pertenece(valor)) {
				resultado.agregar(valor);
			} 
		}
		return resultado;
	}
	
	
	static public Conjunto clonar(Conjunto c) {
		Conjunto clon = new Conjunto();
		Conjunto aux = new Conjunto();
		clon.inicializarConjunto();
		aux.inicializarConjunto();
		
		while (!c.conjuntoVacio()) {
			int valor = c.elegir();
			c.sacar(valor);
			clon.agregar(valor);
			aux.agregar(valor);
		}
		
		while (!aux.conjuntoVacio()) {
			int valor = aux.elegir();
			aux.sacar(valor);
			c.agregar(valor);
		}
		
		return clon;
	}
	
	
	static public Conjunto diferenciaSimetrica(Conjunto c1, Conjunto c2) {
		Conjunto res = union(c1, c2);
		Conjunto interseccion = interseccion(c1, c2);
		res = diferencia(res, interseccion);
		return res;
	}
	

	static public Conjunto diferenciaSimetricaPuro(Conjunto c1, Conjunto c2) {
		Conjunto conjA = clonar(c1);
		Conjunto conjB = clonar(c2);
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
	
	static public boolean sonIgualesV1(Conjunto c1, Conjunto c2) {
		boolean sonIguales = true;
		Conjunto interseccion = interseccion(c1, c2);
		Conjunto union = union(c1, c2);
		
		Conjunto aux = diferencia(interseccion, union);
		
		if (!aux.conjuntoVacio()) {
			sonIguales = false;
		}
		
		return sonIguales;
	}
	
	static public boolean sonIgualesV2(Conjunto c1, Conjunto c2) {
		boolean sonIguales = true;
		Conjunto conjA = clonar(c1);
		Conjunto conjB = clonar(c2);
		
		while (!conjA.conjuntoVacio() && sonIguales) {
			int valor = conjA.elegir();
			conjA.sacar(valor);
			if (conjB.pertenece(valor)) {
				conjB.sacar(valor);
			} else {
				sonIguales = false;
			}
		}
		
		if (!conjB.conjuntoVacio()) sonIguales = false;
		
		return sonIguales;
	}
	
	static public int cardinalidad(Conjunto c) {
		Conjunto aux = clonar(c);
		int cardinalidad = 0;
		
		while (!aux.conjuntoVacio()) {
			cardinalidad++;
			int valor = aux.elegir();
			aux.sacar(valor);
		}
		return cardinalidad;
	}
	
	static public Conjunto pasarPilaAConjunto(Pila p) {
		Conjunto elementosPila = new Conjunto();
		elementosPila.inicializarConjunto();
		while (!p.pilaVacia()) {
			elementosPila.agregar(p.tope());
			p.desapilar();
		}
		
		return elementosPila;
	}
	
	static public Conjunto pasarColaAConjunto(Cola c) {
		Conjunto elementosCola = new Conjunto();
		elementosCola.inicializarConjunto();
		while (!c.colaVacia()) {
			elementosCola.agregar(c.primero());
			c.desacolar();
		}
		
		return elementosCola;
	}
	
	static public Conjunto interseccionPilaCola(Pila p, Cola c) {
		Conjunto elementosPila = pasarPilaAConjunto(p);
		Conjunto elementosCola = pasarColaAConjunto(c);
		
		return interseccion(elementosPila, elementosCola);
	}
	
	static public boolean esColaIgualPila(Cola c, Pila p) {
		Conjunto elementosPila = pasarPilaAConjunto(p);
		Conjunto elementosCola = pasarColaAConjunto(c);
		
		return sonIgualesV2(elementosPila, elementosCola);
	}
}
