package usoTP3;

import implementacionDinamica.Conjunto;
import implementacionDinamica.Pila;

public class EJ1_Pila {
	/*
	 * a. Comprobar si una Pila P es capicúa (el elemento del tope es igual al de la base,
	 * 		el segundo igual al anteúltimo, etc.)
	 * b. Eliminar de una Pila P las repeticiones de elementos, dejando un representante
	 * 		de cada uno de los elementos presentes originalmente. Se deberá respetar el
	 * 		orden original de los elementos, y en el caso de los repetidos se conservará el
	 * 		primero que haya ingresado en P.
	 * c. Repartir una Pila P en dos mitades M1 y M2 de elementos consecutivos,
	 * 		respetando el orden. Asumir que la Pila P contiene un número par de elementos.
	 * d. Generar el conjunto de elementos que se repiten en una Pila.
	 */
	
	public static void main(String[] args) {
		EJ1_Pila.A();
		EJ1_Pila.B();
		EJ1_Pila.C();
		EJ1_Pila.D();
	}
	
	public static void A() {
		// Test 1
		Pila p1 = new Pila();
		p1.inicializarPila();
		p1.apilar(1);
		p1.apilar(2);
		p1.apilar(3);
		p1.apilar(2);
		p1.apilar(1);
		
		System.out.print("Res A1 - Tiene que ser true: ");
		System.out.println(esCapicua(p1));
		
		// Test 2
		Pila p2 = new Pila();
		p2.inicializarPila();
		p2.apilar(1);
		p2.apilar(2);
		p2.apilar(3);
		p2.apilar(4);
		p2.apilar(1);
		
		System.out.print("Res A2 - Tiene que ser false: ");
		System.out.println(esCapicua(p2));
	}
	
	public static void B() {
		// Test 1
		Pila p1 = new Pila();
		p1.inicializarPila();
		p1.apilar(1);
		p1.apilar(2);
		p1.apilar(3);
		p1.apilar(2);
		p1.apilar(1);
		
		System.out.print("Res B1 - Tiene que dar: [1,2,3] ");
		Pila res = eliminarRepetidos(p1);
		res.print();
	}
	
	public static void C() {
		// Test 1
		Pila p1 = new Pila();
		p1.inicializarPila();
		p1.apilar(1);
		p1.apilar(2);
		p1.apilar(3);
		p1.apilar(4);
		p1.apilar(5);
		p1.apilar(6);
		
		Pila[] res = dividirPila(p1);
		
		System.out.print("Res C1 - Tiene que dar [3,2,1]: ");
		res[0].print();
		
		System.out.print("Res C2 - Tiene que dar [6,5,4]: ");
		res[1].print();
	}
	
	public static void D() {
		// Test 1
		Pila p1 = new Pila();
		p1.inicializarPila();
		p1.apilar(1);
		p1.apilar(2);
		p1.apilar(3);
		p1.apilar(2);
		p1.apilar(1);
		
		System.out.print("Res D1 - Tiene que ser [1, 2]: ");
		Conjunto res = repetidos(p1);
		res.print();
	}
	
	private static Pila invertirPila(Pila p) {
		Pila res = new Pila();
		res.inicializarPila();
		Pila clon = clonarPila(p);
		while (!clon.pilaVacia()) {
			res.apilar(clon.tope());
			clon.desapilar();
		}
		return res;
	}
	
	private static Pila clonarPila(Pila p) {
		Pila invertida = new Pila();
		invertida.inicializarPila();
		while (!p.pilaVacia()) {
			invertida.apilar(p.tope());
			p.desapilar();
		}
		Pila clon = new Pila();
		clon.inicializarPila();
		while (!invertida.pilaVacia()) {
			clon.apilar(invertida.tope());
			/* Esto es porque como use implementacion dinamica,
			 * al tocar p, edito la estructura original por lo tanto
			 * tengo que volver a armar p */ 
			p.apilar(invertida.tope());
			invertida.desapilar();
		}
		return clon;
	}
	
	private static boolean esCapicua(Pila p) {
		Pila invertida = invertirPila(p);
		boolean esCapicua = true;
		while (!p.pilaVacia() && esCapicua) {
			if (p.tope() != invertida.tope()) {
				esCapicua = false;
			}
			p.desapilar();
			invertida.desapilar();
		}
		return esCapicua;
	}
	
	private static Pila eliminarRepetidos(Pila p) {
		Pila res = new Pila();
		res.inicializarPila();
		Conjunto repetidos = new Conjunto();
		
		while(!p.pilaVacia()) {
			if (!repetidos.pertenece(p.tope())) {
				res.apilar(p.tope());
				repetidos.agregar(p.tope());
			}
			p.desapilar();
		}
		res = invertirPila(res);
		return res;
	}
	
	private static Pila[] dividirPila(Pila p){
		Pila[] res = new Pila[2];
		Pila mitad1 = new Pila();
		Pila mitad2 = new Pila();
		mitad1.inicializarPila();
		mitad2.inicializarPila();
		
		Pila clon = clonarPila(p);
		int length = 0;
		while (!clon.pilaVacia()) {
			length++;
			clon.desapilar();
		}
		
		for (int i = 0; i < length / 2; i++) {
			mitad2.apilar(p.tope());
			p.desapilar();
		}
		
		for (int i = 0; i < length / 2; i++) {
			mitad1.apilar(p.tope());
			p.desapilar();
		}
		
		res[0] = invertirPila(mitad1);
		res[1] = invertirPila(mitad2);
		
		return res;
	}
	
	private static Conjunto repetidos(Pila p) {
		Conjunto repe = new Conjunto();
		Conjunto existentes = new Conjunto();
		repe.inicializarConjunto();
		existentes.inicializarConjunto();
		
		while (!p.pilaVacia()) {
			if (existentes.pertenece(p.tope())) {
				repe.agregar(p.tope());
			}
			existentes.agregar(p.tope());
			p.desapilar();
		}
		
		return repe;
	}
}
