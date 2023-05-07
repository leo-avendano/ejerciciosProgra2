package usoTP3;

import implementacionDinamica.Cola;
import implementacionDinamica.Conjunto;

public class EJ2_Cola {
	/* 
	 * a. Eliminar de una Cola C las repeticiones de elementos, dejando un representante
	 * 		de cada uno de los elementos presentes originalmente. Se deberá respetar el
	 * 		orden original de los elementos, y en el caso de los repetidos se conservará el
	 * 		primero que haya ingresado en C.
	 * b. Repartir una Cola C en dos mitades M1 y M2 de elementos consecutivos,
	 * 		respetando el orden. Asumir que la cantidad de elementos de C es par.
	 * c. Generar el conjunto de elementos que se repiten en una Cola,
	 */
	public static void main(String[] args) {
		EJ2_Cola.A();
		EJ2_Cola.B();
		EJ2_Cola.C();
	}
	
	public static void A() {
		// Test 1
		Cola c1 = new Cola();
		c1.inicializarCola();
		c1.acolar(1);
		c1.acolar(2);
		c1.acolar(3);
		c1.acolar(2);
		c1.acolar(1);
		
		System.out.print("Res A1 - Tiene que dar: [1,2,3] ");
		Cola res = eliminarRepetidos(c1);
		res.print();
	}
	public static void B() {
		// Test 1
		Cola p1 = new Cola();
		p1.inicializarCola();
		p1.acolar(1);
		p1.acolar(2);
		p1.acolar(3);
		p1.acolar(4);
		p1.acolar(5);
		p1.acolar(6);
		
		Cola[] res = dividirCola(p1);
		
		System.out.print("Res B1 - Tiene que dar [1,2,3]: ");
		res[0].print();
		
		System.out.print("Res B2 - Tiene que dar [4,5,6]: ");
		res[1].print();
	}
	public static void C() {
		// Test 1
		Cola p1 = new Cola();
		p1.inicializarCola();
		p1.acolar(1);
		p1.acolar(2);
		p1.acolar(3);
		p1.acolar(2);
		p1.acolar(1);
		
		System.out.print("Res C1 - Tiene que ser [1, 2]: ");
		Conjunto res = repetidos(p1);
		res.print();
	}
	
	private static Cola clonarCola(Cola p) {
		Cola invertida = new Cola();
		invertida.inicializarCola();
		while (!p.colaVacia()) {
			invertida.acolar(p.primero());
			p.desacolar();
		}
		Cola clon = new Cola();
		clon.inicializarCola();
		while (!invertida.colaVacia()) {
			clon.acolar(invertida.primero());
			/* Esto es porque como use implementacion dinamica,
			 * al tocar p, edito la estructura original por lo tanto
			 * tengo que volver a armar p */ 
			p.acolar(invertida.primero());
			invertida.desacolar();
		}
		return clon;
	}

	private static Cola eliminarRepetidos(Cola p) {
		Cola res = new Cola();
		res.inicializarCola();
		Conjunto repetidos = new Conjunto();
		
		while(!p.colaVacia()) {
			if (!repetidos.pertenece(p.primero())) {
				res.acolar(p.primero());
				repetidos.agregar(p.primero());
			}
			p.desacolar();
		}
		return res;
	}
	
	private static Cola[] dividirCola(Cola p){
		Cola[] res = new Cola[2];
		Cola mitad1 = new Cola();
		Cola mitad2 = new Cola();
		mitad1.inicializarCola();
		mitad2.inicializarCola();
		
		Cola clon = clonarCola(p);
		int length = 0;
		while (!clon.colaVacia()) {
			length++;
			clon.desacolar();
		}
		
		for (int i = 0; i < length / 2; i++) {
			mitad2.acolar(p.primero());
			p.desacolar();
		}
		
		for (int i = 0; i < length / 2; i++) {
			mitad1.acolar(p.primero());
			p.desacolar();
		}
		
		res[1] = mitad1;
		res[0] = mitad2;
		
		return res;
	}
	
	private static Conjunto repetidos(Cola p) {
		Conjunto repe = new Conjunto();
		Conjunto existentes = new Conjunto();
		repe.inicializarConjunto();
		existentes.inicializarConjunto();
		
		while (!p.colaVacia()) {
			if (existentes.pertenece(p.primero())) {
				repe.agregar(p.primero());
			}
			existentes.agregar(p.primero());
			p.desacolar();
		}
		
		return repe;
	}
}
